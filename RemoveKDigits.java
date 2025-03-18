
/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // Remove remaining k digits, if necessary
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result from stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return "0" if all digits were removed
        return sb.length() == 0 ? "0" : sb.toString();
    }
}