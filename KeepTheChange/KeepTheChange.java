import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> result = new ArrayList<>();
        if (amount < 0 || coins == null || coins.isEmpty()) {
            return result;
        }

        int[] dp = new int[amount + 1];
        int[] prev = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        Arrays.fill(prev, -1);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (Integer c : coins) {
                if (c != null && c <= a && dp[a - c] + 1 < dp[a]) {
                    dp[a] = dp[a - c] + 1;
                    prev[a] = c;
                }
            }
        }

        if (prev[amount] == -1) {
            return result; // no solution
        }

        int a = amount;
        while (a > 0) {
            int c = prev[a];
            result.add(c);
            a -= c;
        }
        return result;
    }
}