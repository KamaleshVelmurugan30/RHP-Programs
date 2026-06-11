import java.util.*;

class Solution {
    public int countSubstrings(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                sum--;
            } else {
                sum++;
            }

            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
