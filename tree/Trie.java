import java.util.LinkedList;
import java.util.List;

// 208. 实现 Trie (前缀树)
public class Test {

    public static void main(String[] args) {

    }
}

class Trie {

    class TrieNode {
        boolean end;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;


    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.next[word.charAt(i)-'a'] == null) {
                p.next[word.charAt(i)-'a'] = new TrieNode();
            }
            p = p.next[word.charAt(i)-'a'];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            p = p.next[word.charAt(i)-'a'];
            if (p == null) {
                return false;
            }
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            p = p.next[prefix.charAt(i)-'a'];
            if (p == null) {
                return false;
            }
        }
        return true;
    }
}
