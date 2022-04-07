import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 130. 被围绕的区域
public class Test {

    public static void main(String[] args) {


        Solution solution = new Solution();

        Queue<Integer> list = new LinkedList<>();
        list.offer();
        list.offer(2);
        System.out.println(list);
//        list.remove();
//        System.out.println(list);


    }
}

class Solution {
    // 思路：DFS
    // 以边界'O'为起点遍历，该元素赋值为'A'
    // 遍历board，A--‘O’，其他全为'X'
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) { // 遍历左右边界
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for (int i = 0; i < n; i++) { // 遍历上下边界
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        //填充
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        if (board[i][j] == 'O') { // 标记为‘A’
            board[i][j] = 'A';
        }

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);

    }
}

