class Solution {

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        // build max heap
        for (int i = 1; i < n; i++) {
            insert(nums, i);
        }

        // heap sort
        for (int i = n - 1; i >= 1; i--) {
            delete(nums, i);
        }

        return nums;
    }

    // heapify up
    public void insert(int[] a, int index) {

        int temp = a[index];
        int i = index;

        while (i > 0 && temp > a[(i - 1) / 2]) {

            a[i] = a[(i - 1) / 2];
            i = (i - 1) / 2;
        }

        a[i] = temp;
    }

    // heapify down
    public void delete(int[] a, int end) {

        swap(a, 0, end);

        int i = 0;

        while (true) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int largest = i;

            if (left < end && a[left] > a[largest]) {
                largest = left;
            }

            if (right < end && a[right] > a[largest]) {
                largest = right;
            }

            if (largest == i) break;

            swap(a, i, largest);

            i = largest;
        }
    }

    public void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}