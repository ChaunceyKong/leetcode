import com.sun.deploy.util.StringUtils;

import java.util.*;

//438. 找到字符串中所有字母异位词
public class Test {
    public static void main(String[] args) {
        String s ="cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams2(s,p));
    }
}
class Solution {
    //思路：暴力解法
    //每三个排序后相比较，若相同则输出索引
    //超时
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        for (int i = 0; i < sLen - pLen + 1; i++) {
            String sSubStr = s.substring(i,i+pLen);
            char[] sSubChar = sSubStr.toCharArray();
            Arrays.sort(sSubChar);
            char[] pSubChar = p.toCharArray();
            Arrays.sort(pSubChar);
            if (Arrays.equals(sSubChar,pSubChar)) {
                res.add(i);
            }
        }
        return res;
    }

    //改进：记录字符个数，相同则为异位词
    public List<Integer> findAnagrams2(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }
        int[] sCount = new int[256]; //记录s字符个数
        int[] pCount = new int[256]; //记录p字符个数
        for (char c : p.toCharArray()) {
            pCount[c]++;
        }

        // 将窗口初始大小为pLen
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i)]++;
        }
        if (Arrays.equals(sCount,pCount)) { //
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            //窗口滑动一次
            sCount[s.charAt(i+pLen)]++;
            sCount[s.charAt(i)]--;
            if (Arrays.equals(sCount,pCount)) {
                res.add(i+1);
            }
        }
        return res;
    }

    //滑动窗口
    public List<Integer> findAnagrams3(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        Map<Character, Integer> pMap = new HashMap<>(); //记录p字符个数
        Map<Character, Integer> win = new HashMap<>(); //记录窗口字符个数
        for (char c : p.toCharArray()) {
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (right < sLen) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (pMap.containsKey(c)) {//p中有字符c，加入win
                win.put(c,win.getOrDefault(c,0)+1); //字符c存入win
                if (win.get(c).equals(pMap.get(c))) { //字符c，达到数量要求
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= pLen) { //注意:right先++，所以这里可以=
                //满足要求
                if (valid == pMap.size()) {
                    res.add(left);
                }

                //缩小窗口
                char d = s.charAt(left);
                left++;
                if (pMap.containsKey(d)) { //p中有字符d，移除win
                    if (win.get(d).equals(pMap.get(d)) ) { //字符d达到数量要求，移除d需要valid--
                        valid--;
                    }
                    win.put(d,win.getOrDefault(d,0)-1);
                }
            }
        }
        return res;
    }

    
}