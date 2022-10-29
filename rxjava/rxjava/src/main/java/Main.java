import java.util.*;

public class Main {
    HashMap<Character, Integer> map = new HashMap<>();
    int res = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.solution("test");
        System.out.println("test res = " + main.res);

        main = new Main();
        main.solution("good");
        System.out.println("good res = " + main.res);

        System.out.println((2 & 1) == 1);
    }

    void solution(String password) {
        char[] passwordArr = password.toCharArray();
        for (int len = 0; len < passwordArr.length; len++) {
            for (int i = 0; i < passwordArr.length - len; i++) {
                if (i == 0) {
                    for (int j = 0; j <= len; j++) {
                        addEle(passwordArr[j]);
                    }
                } else {
                    removeEle(passwordArr[i - 1]);
                    addEle(passwordArr[i + len]);
                }
                res += map.size();
            }
            map.clear();
        }
    }

    void addEle(char ele) {
        map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    void removeEle(char ele) {
        int cnt = map.getOrDefault(ele, 0);
        if (cnt <= 1) {
            map.remove(ele);
        } else {
            map.put(ele, cnt - 1);
        }
    }

}
