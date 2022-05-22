//239. 滑动窗口最大值

class Solution {
    //思路2：单调队列实现时间复杂度O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numsLen = nums.length;
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[numsLen - k + 1];
        int idx = -1;

        for (int i = 0; i < numsLen; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
                continue;
            }
            // 窗口向前滑动，加入新数字
            window.push(nums[i]);
            // 记录当前窗口的最大值
            res[++idx] = window.max();
            // 移出旧数字
            window.pop(nums[i-k+1]);
        }
        return res;
    }

    class MonotonicQueue {
        LinkedList<Integer> queue = new LinkedList();
        public void push(int n) {
            //从队尾放入n之前，删除前面比n小的元素
            //则队列存放了大于等于当前元素的元素
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.removeLast();
            }
            queue.addLast(n);
        }

        public void pop(int n) {
            //若对头元素不是n，则不删除
            if (queue.getFirst() == n) {
                queue.removeFirst();
            }
        }

        public int max() {
            //获取最大值，即对头元素
            return queue.getFirst();
        }
    }
}