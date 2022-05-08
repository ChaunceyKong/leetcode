import java.util.*;


//57. 插入区间

public class Test {
    // 思路：分三种情况
    // 1.左边没有重叠  2.有重叠  3.右边没有重叠
    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> res = new LinkedList<>();
        int len = intervals.length;
        int i = 0;

        //左边没有重叠
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        //有重叠
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        //右边没有重叠
        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
}

