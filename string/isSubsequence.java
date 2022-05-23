

//392. 判断子序列
class Solution {
    //思路：双指针
    public boolean isSubsequence(String s, String t) {
        int idx1 = 0; //字符串s上的指针
        int idx2 = 0; //字符串t上的指针

        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
            }
            idx2++;
        }

        return idx1 == s.length();
    }
}