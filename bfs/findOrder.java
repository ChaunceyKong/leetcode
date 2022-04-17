import java.util.*;

//210. 课程表 II
public class Test {

    public static void main(String[] args) {


    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 思路：构造图，bfs输出结点 拓扑排序
        LinkedList<Integer>[] graph = buildGraph(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[numCourses]; //各课程结点的入度

        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            inDegree[to]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) { //入度为0，可以直接作为起始结点
                q.offer(i);
            }
        }

        int[] course = new int[numCourses];
        int idx = 0; //课程索引

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                course[idx] = cur;
                idx++;
                for (int next : graph[cur]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) { //next没有任何依赖
                        q.offer(next);
                    }
                }
            }
        }
        if (idx != numCourses) { //存在环
            return new int[]{};
        }

        return course;

    }

    //构造图
    //使用邻接表方式存储图
    public LinkedList<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        //初始化graph
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }

}


