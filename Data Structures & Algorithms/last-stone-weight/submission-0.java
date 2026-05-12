class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0 ; i < stones.length; i++){
            queue.offer(stones[i]);
        }

        while (queue.size() > 1){
            int heavy_first = queue.poll();
            int heavy_second = queue.poll();

            if (heavy_first != heavy_second){
                queue.offer(heavy_first - heavy_second);
            }
        }

        if (!queue.isEmpty()){
            return queue.poll();
        }
        else return 0;
    }
}
