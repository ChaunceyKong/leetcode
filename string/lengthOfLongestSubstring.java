import java.util.*;
//3. 无重复字符的最长子串

class lengthOfLongestSubstring {
	
    //思路：双指针
    public int lengthOfLongestSubstring1(String s) {
        //如果s的长度为1，直接返回1
        if (s.length() == 1) {
            return 1;
        }

        int l = 0; //无重复子串的起点
        int maxLen = 0; //最大长度

        for (int r = 1; r < s.length(); r++) { //右边界，遍历
            int idx = l; //临时变量idx，用来寻找子串中是否有重复元素
            //判断l-r内是否有重复元素，若有，更新l的位置，最终获得以r结尾的无重复子串
            while (idx < r) {
                if (s.charAt(idx) == s.charAt(r)) {
                    l = idx + 1;
                }
                idx++;
            }
            //r每动一次，获取最大长度
            maxLen = Math.max(maxLen, r - l + 1);

        }
        return maxLen;
    }

    //改进：可以使用HashMap改进上文while获取无重复子串
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

}