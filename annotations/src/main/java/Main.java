import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));

        int a = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        List<String> list = new LinkedList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        System.out.println(list1.stream().map(String::valueOf).collect(Collectors.joining("-")));
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums从小到大排序
        Arrays.sort(nums);
        // 处理数组中的重复元素
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        // 不可能情况判断
        if (nums[0] >= 0 || len < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= len - 2; i++) {
            System.out.println("i = " + i);
            // 初始化 left 和 right
            int left = i + 1, right = len;
            // 寻找三元组
            while (left < right) {
                int gap = nums[i] - nums[left] - nums[right];
                System.out.println("gap = " + gap + ", left = " + left + ", right = " + right);
                if (gap < 0) {
                    right--;
                } else if (gap > 0) {
                    left++;
                } else {
                    List<Integer> var = new ArrayList<>();
                    var.add(nums[i]);
                    var.add(nums[left++]);
                    var.add(nums[right--]);
                    res.add(var);
                }
            }
        }
        return res;
    }
}