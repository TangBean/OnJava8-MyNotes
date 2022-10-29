package lombok.bug;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class GetResultHandlerTest {

    GetResultHandler handler;

    Result emptyResult;
    @Mock
    Depenency depenency;
    @Mock
    Result emptyResultMock;
    @Mock
    Result resultMock;

    private AutoCloseable closeable;

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);

        handler = new GetResultHandler(depenency);

        emptyResult = Result.builder()
                .list1(ImmutableList.of())
                .list2(ImmutableList.of())
                .list3(ImmutableList.of())
                .list4(ImmutableList.of())
                .build();

        when(emptyResultMock.getList1()).thenReturn(ImmutableList.of());
        when(emptyResultMock.getList2()).thenReturn(ImmutableList.of());
        when(emptyResultMock.getList3()).thenReturn(ImmutableList.of());
        when(emptyResultMock.getList4()).thenReturn(ImmutableList.of());

        when(resultMock.getList1()).thenReturn(ImmutableList.of(1, 2, 3));
        when(resultMock.getList2()).thenReturn(ImmutableList.of(1, 2, 3));
        when(resultMock.getList3()).thenReturn(ImmutableList.of(1, 2, 3));
        when(resultMock.getList4()).thenReturn(ImmutableList.of(1, 2, 3));

    }

    @Test
    public void getResult() {
        Result result = handler.getResult(2, 3);
        System.out.println(result);
    }

    @Test
    public void getResults() {
        List<Result> results = handler.getResults(2, 3, 4);
        System.out.println(results);
    }

    /*
    Difference between emptyResult and emptyResultMock:
    emptyResult object is created by Builder function, but emptyResultMock is created by @Mock.

    Output:
    true --> the method in emptyResult will return correct results
    [] true
    [] true
    [] true
    [] true
    input: Hello World! --> the method in emptyResult will return correct results
    result.echo: Hello World!
    false --> but the method in emptyResultMock will return the default value of the return type (boolean: false)
    [] true
    [] true
    [] true
    [] true
    result.echo: null --> but the method in emptyResultMock will return the default value of the return type (String: null)
    [emptyResultMock]
     */
    @Test
    public void getResultsWithoutEmpty() {
        when(depenency.getResultsFromDatabase(anyInt(), anyInt(), anyInt()))
                .thenReturn(ImmutableList.of(emptyResult, emptyResultMock));

        List<Result> results = handler.getResultsWithoutEmpty(2, 3, 4);
        System.out.println(results);
    }

}