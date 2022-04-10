import java.util.LinkedList;
import java.util.List;

// 207. 课程表
public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
    }
}

class Solution {
    // 思路：如果多个课程互相持有对方课程，则false，否则true  类似死锁
    // 暴力解法：超出时间限制
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> course = new LinkedList<>();

        int pre = -1;

        for (int i = 0; i < prerequisites.length; i++) {
            course.add(prerequisites[i][0]);
            pre = prerequisites[i][1];

            for (int j = 0; j < prerequisites.length;) {
                if (prerequisites[j][0] == pre) {
                    if (course.contains(Integer.valueOf(prerequisites[j][1]))) {
                        return false;
                    }
                    course.add(pre);
                    pre = prerequisites[j][1];
                    j = 0;
                }
                j++;
            }
            course.clear();
        }
        return true;
    }

    // 思路2：拓扑排序 DFS
    // 记录一次 traverse 递归经过的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序遍历代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序遍历代码位置
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}
