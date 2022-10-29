package lombok.bug;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

@Value
@Builder
@ToString
public class Result {
    @NonNull
    private List<Integer> list1;
    @NonNull
    private List<Integer> list2;
    @NonNull
    private List<Integer> list3;
    @NonNull
    private List<Integer> list4;

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(this.list1)
                && CollectionUtils.isEmpty(this.list2)
                && CollectionUtils.isEmpty(this.list3)
                && CollectionUtils.isEmpty(this.list4);
    }

    public String echo(String input) {
        System.out.println("input: " + input);
        return input;
    }

}
