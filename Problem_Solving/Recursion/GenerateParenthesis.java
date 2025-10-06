import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Constraints:
     * 1. 1 <= n <= 8
     * 2. The solution set must not contain duplicate combinations.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * @param n - Number of pairs of parentheses.
     * @returns List<String> - A list of all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, n, result, new StringBuilder());
        return result;
    }

    public void backtracking(int open, int close, List<String> result, StringBuilder sb) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        int l1 = sb.length();
        if (open > 0) {
            sb.append('(');
            backtracking(open - 1, close, result, sb);
            sb.setLength(l1);
        }

        int l2 = sb.length();
        if (close > 0) {
            sb.append(')');
            backtracking(open, close - 1, result, sb);
            sb.setLength(l2);
        }
    }

    /**
     * Main method for testing the GenerateParenthesis class.
     */
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> result = gp.generateParenthesis(n);
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        
        assert result.size() == expected.size() && result.containsAll(expected) : "Test case failed";
    }
}
