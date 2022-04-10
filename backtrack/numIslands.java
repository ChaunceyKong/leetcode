
import java.util.LinkedList;
import java.util.Queue;

// 200. 岛屿数量
public class Test {

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        Solution solution = new Solution();
        System.out.println(solution.numIslands2(grid));
    }
}

class Solution {
    // 思路1：dfs搜索，dfs本质递归回溯
    public int numIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, isVisited);
                    count++;
                }
            }
        }

        return count;

    }

    public void dfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        //base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) { //超出边界
            return;
        }

        if (isVisited[i][j] || grid[i][j] == '0') { // 已经访问过了 或者 grid[i][j]==0
            return;
        }

        // 进入grid[i][j]
        isVisited[i][j] = true;

        dfs(grid, i - 1, j, isVisited); //上
        dfs(grid, i + 1, j, isVisited); //下
        dfs(grid, i , j - 1, isVisited); //左
        dfs(grid, i, j + 1, isVisited); //右
    }

    // 思路2：bfs搜索,路径一定最小
    public int numIslands2(char[][] grid) {
        int count = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    bfs(grid,i,j,isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        Queue<int[]> list = new LinkedList<>();

        //放入首结点
        list.offer(new int[]{i,j});
        isVisited[i][j] = true;

        while (!list.isEmpty()) {
            int sz = list.size();

            //将当前队列里的所有结点向四周扩散
            for (int i1 = 0; i1 < sz; i1++) {
                //取出第一个结点
                int[] temp = list.poll();

                //将temp相邻结点加入队列
                if (temp[0] - 1 >= 0 && grid[temp[0] - 1][temp[1]] == '1') { //上
                    if (!isVisited[temp[0] - 1][temp[1]]) {
                        list.offer(new int[]{temp[0] - 1, temp[1]});
                        isVisited[temp[0] - 1][temp[1]] = true;
                    }
                }
                if (temp[0] + 1 < grid.length && grid[temp[0]+1][temp[1]] == '1') { //下
                    if (!isVisited[temp[0]+1][temp[1]]) {
                        list.offer(new int[]{temp[0]+1,temp[1]});
                        isVisited[temp[0]+1][temp[1]] = true;
                    }
                }
                if (temp[1] - 1 >= 0 && grid[temp[0]][temp[1]-1] == '1') { //左
                    if (!isVisited[temp[0]][temp[1]-1]) {
                        list.offer(new int[]{temp[0],temp[1]-1});
                        isVisited[temp[0]][temp[1]-1] = true;
                    }
                }
                if (temp[1] + 1 < grid[0].length && grid[temp[0]][temp[1]+1] == '1') { //右
                    if (!isVisited[temp[0]][temp[1]+1]) {
                        list.offer(new int[]{temp[0],temp[1]+1});
                        isVisited[temp[0]][temp[1]+1] = true;
                    }
                }
            }
        }
    }
}
