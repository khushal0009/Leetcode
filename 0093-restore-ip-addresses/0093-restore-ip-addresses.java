class Solution {

    public void bt(String s, List<String> result, LinkedList<String> comb) {
        // If both s is empty and we have 4 numbers we did it!
        if (s.isEmpty() && comb.size() == 4) {
            result.add(String.join(".", comb));
            return;
        // if only one of those things is true back out
        } else if (!s.isEmpty() && comb.size() == 4) {
            return;
        }

        // take 1-3 numbers from the start
        int limit = Math.min(3, s.length());
        for (int i = 0; i < limit; i++) {
            String trial = s.substring(0, i + 1);

            // 2 elimination cases
                // if a string with more than 1 digit starts with 0
                // a number is greater than 255
            if (trial.startsWith("0") && trial.length() > 1) continue;
            if (Integer.parseInt(trial) > 255) continue;

            comb.addLast(trial);
            // recurse with used substring removed
            bt(s.substring(i + 1), result, comb);
            comb.removeLast();
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // pre-elimination since these cases are invalid since all numbers MUST be used
        if (s.length() < 4 || s.length() > 12) return result;
        bt(s, result, new LinkedList<>());
        return result;
    }
}