package lombok.bug;

import java.util.ArrayList;
import java.util.List;

public class Depenency {

    public Result getResultFromDatabase(int eleVal, int elementSize) {
        List<Integer> list1 = new ArrayList<>(elementSize);
        List<Integer> list2 = new ArrayList<>(elementSize);
        List<Integer> list3 = new ArrayList<>(elementSize);
        List<Integer> list4 = new ArrayList<>(elementSize);
        for (int j = 0; j < elementSize; j++) {
            list1.add(eleVal);
            list2.add(eleVal);
            list3.add(eleVal);
            list4.add(eleVal);
        }
        return Result.builder()
                .list1(list1)
                .list2(list2)
                .list3(list3)
                .list4(list4)
                .build();
    }

    public List<Result> getResultsFromDatabase(int eleVal, int elementSize, int resultSize) {
        List<Result> res = new ArrayList<>();
        for (int i = 0; i < resultSize; i++) {
            res.add(getResultFromDatabase(eleVal, elementSize));
        }
        return res;
    }

}
