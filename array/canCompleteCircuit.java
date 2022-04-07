

// 134. 加油站
public class Test {

    public static void main(String[] args) {

//        int[] gas = {5,1,2,3,4};
//        int[] cost = {4,4,1,5,1};
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
//        int[] gas = {3,1,1};
//        int[] cost = {1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit3(gas,cost));


    }
}

class Solution {
    // 思路：暴力解
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int oil = 0;
        for (int j = 0; j < gas.length; j++) {
            int start = j;
            int end = gas.length;
            oil = gas[start];
            //构成环形数组
            int i;
            for (i = start; i < end; ) { //汽车开一圈

                if (oil < cost[i]) {
                    oil -= cost[i];
                    break;
                }
                //操作:加油和耗油
                if (i == gas.length - 1) {
                    oil = oil - cost[i] + gas[0];
                }
                else if (i == start - 1) {
                    oil = oil - cost[i] ;
                }
                else {
                    oil = oil - cost[i] + gas[i+1];
                }

                i++;
                if (i == gas.length) { //当遍历到尾，循环从头开始
                    i = 0;
                    end = start;
                }
                if (oil == 0) { //中途没油了，直接退出循环
                    break;
                }

            }
            if (oil >= 0 && i == start) { //最后还剩油或正好不剩油
                return start;
            }
        }
        return -1;

    }

    //改进暴力解
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int remainOil = 0;

        int n = gas.length;

        for (int j = 0; j < n; j++) {
            int start = j;
            int end = j + n;

            remainOil = gas[start];
            for (int i = start; i < end; i++) { //汽车开一圈

                remainOil = remainOil - cost[i%n]; //开往第 i+1 站，剩余油量

                if (remainOil< 0) { // 剩余油量<到i+1站消耗量，无法到达 i+1 站
                    break;
                }
                remainOil += gas[(i+1)%n]; //到达站点 i+1 加油

            }
            remainOil -= gas[start]; //最后多加了一次gas[start]
            if (remainOil >= 0) { //最后还剩油或正好不剩油
                return start;
            }
        }
        return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i]; // gas[i] - cost[i] 表示此站加的油，足不足够到下一站
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}

