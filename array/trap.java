

//42. 接雨水
public class Test {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));
    }
}

class Solution {
    // 思路：按列求
    // 当前列 i 所能存的水 = 左右两边最矮的墙高度 - height[i]
    public int trap(int[] height) {
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            int lMax = 0;
            int rMax = 0;
            for (int j = i - 1; j >= 0; j--) {//从右往左求左边最高的墙
                lMax = Math.max(lMax, height[j]);
            }
            for (int k = i + 1; k < height.length; k++) {//从左往右求右边最高的墙
                rMax = Math.max(rMax, height[k]);
            }
            if (Math.min(lMax, rMax) > height[i]) {
                water += Math.min(lMax, rMax) - height[i];
            }
        }
        return water;
    }

    // 改进：
    // 上面两层for循环，时间复杂度为O(n^2)，使用动态规划思想降为O(n)
    public int trap(int[] height) {
        //lMax[i] 表示 height[i]左边最高的高度，不包括i
        int[] lMax = new int[height.length];
        //lMax[i] 表示 height[i]右边最高的高度，不包括i
        int[] rMax = new int[height.length];
        //因此，对于lMax[i+1] 只需要比较i的高度height[i]和i左侧最高高度lMax[i]
        //对于rMax[i] 只需要比较rMax[i+1]和height[i+1]

        //初始化
        lMax[0] = height[0];
        rMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i+1]);
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) { //两端点存不了水
            int min = Math.min(lMax[i],rMax[i]);
            if ( min - height[i] > 0) {
                water += min - height[i];
            }
        }
        return water;
    }

    
}

