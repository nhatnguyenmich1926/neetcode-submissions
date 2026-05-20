class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // frequency counting
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }

        // heap stores unique numbers
        int[] heap = new int[map.size() + 1];

        int index = 1;

        for (int key : map.keySet()) {
            heap[index++] = key;
        }

        // build max heap based on frequency
        for (int i = 2; i < heap.length; i++) {
            insert(heap, i, map);
        }

        int[] result = new int[k];

        int size = heap.length - 1;

        for (int i = 0; i < k; i++) {

            result[i] = heap[1];

            deletion(heap, size, map);

            size--;
        }

        return result;
    }

    public void insert(int[] heap,
                       int n,
                       HashMap<Integer, Integer> map) {

        int temp = heap[n];

        int i = n;

        while (i > 1 &&
                map.get(temp) > map.get(heap[i / 2])) {

            heap[i] = heap[i / 2];

            i = i / 2;
        }

        heap[i] = temp;
    }

    public void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void deletion(int[] heap,
                         int n,
                         HashMap<Integer, Integer> map) {

        heap[1] = heap[n];

        int i = 1;

        int j = 2 * i;

        while (j <= n - 1) {

            if (j < n - 1 &&
                    map.get(heap[j + 1]) > map.get(heap[j])) {

                j = j + 1;
            }

            if (map.get(heap[i]) < map.get(heap[j])) {

                swap(heap, i, j);

                i = j;

                j = 2 * i;
            }
            else {
                break;
            }
        }
    }
}