

//211. 添加与搜索单词 - 数据结构设计

//思路：前缀树/字典树
class WordDictionary {

    class Node {
        boolean isWord;
        //26个英文字母
        Node[] next = new Node[26];
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.next[u] == null) {
                p.next[u] = new Node();
            }
            p = p.next[u];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    //子树遍历
    public boolean dfs(Node root, String word, int start) {

        if (start == word.length()) {
            return root.isWord;
        }
        int u = word.charAt(start) - 'a';
        if (u >= 0 && u <= 25) { // word.charAt(i) 为字母
            if (root.next[u] == null) {
                return false;
            }
            return dfs(root.next[u], word, start + 1);
        } else { // word.charAt(i) 为 .
            //需要对其所有子树进行遍历匹配
            for (int i = 0; i < 26; i++) {
                if (root.next[i] != null && dfs(root.next[i], word, start + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}