/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();

        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String c: tokens) {
            if(set.contains(c)) {
                int first = st.pop();
                int second = st.pop();

                if(c.equals("+")) {
                    st.add(second+first);
                }
                else if(c.equals("-")) {
                    st.add(second-first);
                }
                else if(c.equals("*")) {
                    st.add(second*first);
                }
                else if(c.equals("/")) {
                    st.add(second/first);
                }
            }
            else {
                st.add(Integer.parseInt(c));
            }
        }

        return st.pop();
    }
}