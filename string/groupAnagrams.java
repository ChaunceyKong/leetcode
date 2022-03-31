import java.util.*;
//49. 字母异位词分组

public class Test {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));


    }
}

class Solution {
    //思路1：暴力算法
    //1.对每个单词的字母进行排序，则其恢复出相同形式
    //2.将相同单词对应strs放入列表，isUsed[i] = true
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> word = new ArrayList<>();
        boolean[] isUsed = new boolean[strs.length];

        //若strs数组长度为0，直接返回空res链表
        if (strs.length == 0) {
            return res;
        }

        for (int i = 0; i < strs.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            word.add(strs[i]);
            isUsed[i] = true;

            char[] temp1 = strs[i].toCharArray();
            Arrays.sort(temp1);

            for (int j = i + 1; j < strs.length; j++) {
                if (isUsed[j]) {
                    continue;
                }

                char[] temp2 = strs[j].toCharArray();
                Arrays.sort(temp2);

                if (Arrays.equals(temp1, temp2)) {
                    word.add(strs[j]);
                    isUsed[j] = true;
                }
            }

            res.add(word);
            word = new ArrayList<>();

        }
        return res;
    }

    //思路2：
    //1.判断是否是异位词：通过编码实现
    //2.若是，加入到链表
    public List<List<String>> groupAnagrams(String[] strs) {

        // 编码到分组的映射
        HashMap<String, List<String>> codeToGroup = new HashMap<>();

        for (String s : strs) {
            // 对字符串进行编码
            String code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup.putIfAbsent(code, new ArrayList<>());
            codeToGroup.get(code).add(s);
        }
        //获取结果
        List<List<String>> res = new ArrayList<>();
        for (List<String> tmp : codeToGroup.values()) {
            res.add(tmp);
        }
        return res;
    }

    //编码1:排序,耗时
//    public String encode(String s) {
//        char[] arr = s.toCharArray();
//
//        Arrays.sort(arr);
//
//        return new String(arr);
//    }
    //编码2:计算字母出现个数
    public String encode(String s) {
        char[] code = new char[26];
        for (char c : s.toCharArray()) {
            code[c - 'a']++;
        }

        return new String(code);
    }

}