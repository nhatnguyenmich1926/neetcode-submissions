class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums){
            maxheap.offer(num);
        }

        for (int i = 0; i < k - 1; i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
}
