
class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1
        maxHeap.offer(num);

        // Step 2
        minHeap.offer(maxHeap.poll());

        // Step 3
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return ((double) maxHeap.peek()
                + minHeap.peek()) / 2.0;
    }
}