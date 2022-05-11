

//79. 单词搜索

public class Test {
    public static void main(String[] args) {
        // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'a'}};
        String word = "a";

        Solution solution = new Solution();

        System.out.println(solution.exist(board, word));
    }

}

class Solution {
    // 思路：dfs/回溯
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                traverse(board, word, i, j,0);
                if (existFlag) {
                    return true;
                }
            }
        }
        return existFlag;
    }

    // int index = 0; //word的索引
    boolean existFlag = false; //是否存在标志位
    boolean[][] isVisited;
    public void traverse(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] != word.charAt(index) || isVisited[i][j]) {
            return;
        }

        if (index == word.length() - 1) {
            existFlag = true;
            return;
        }

        isVisited[i][j] = true;
        traverse(board,word, i,j-1, index+1); //左
        traverse(board,word, i-1,j, index+1); //上
        traverse(board,word, i,j+1, index+1); //右
        traverse(board,word, i+1,j, index+1); //下
        isVisited[i][j] = false;
    }
}

