package lombok.bug;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GetResultHandler {

    private Depenency depenency;

    public GetResultHandler(Depenency depenency) {
        this.depenency = depenency;
    }

    public Result getResult(int eleVal, int elementSize) {
        return depenency.getResultFromDatabase(eleVal, elementSize);
    }

    public List<Result> getResults(int eleVal, int elementSize, int resultSize) {
        return depenency.getResultsFromDatabase(eleVal, elementSize, resultSize);
    }

    public List<Result> getResultsWithoutEmpty(int eleVal, int elementSize, int resultSize) {
        List<Result> results = depenency.getResultsFromDatabase(eleVal, elementSize, resultSize);

        for (Result result : results) {
            System.out.println(result.isEmpty());
            System.out.println(result.getList1() + " " + CollectionUtils.isEmpty(result.getList1()));
            System.out.println(result.getList2() + " " + CollectionUtils.isEmpty(result.getList2()));
            System.out.println(result.getList3() + " " + CollectionUtils.isEmpty(result.getList3()));
            System.out.println(result.getList4() + " " + CollectionUtils.isEmpty(result.getList4()));
            System.out.println("result.echo: " + result.echo("Hello World!"));
        }

        return results.stream()
            .filter(result -> !result.isEmpty())
            .collect(Collectors.toList());
    }

}
