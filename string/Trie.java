

//208. 实现 Trie (前缀树)


class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next = new TrieNode[26];
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i)-'a';
            if (p.next[u] == null) {
                p.next[u] = new TrieNode();
            }
            p = p.next[u];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i)-'a';
            if (p == null) {
                return false;
            }
            p = p.next[u];
        }

        if (p != null && p.isEnd == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i)-'a';
            if (p == null) {
                return false;
            }
            p = p.next[u];
        }

        if (p != null) {
            return true;
        } else {
            return false;
        }
    }
}
