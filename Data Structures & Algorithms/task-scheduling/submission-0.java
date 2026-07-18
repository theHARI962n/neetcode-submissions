class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Max heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        // Add all non-zero frequencies
        for (int freq : count) {
            if (freq > 0) {
                pq.offer(freq);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            // Store tasks processed in this cycle
            List<Integer> temp = new ArrayList<>();

            // A cycle contains n + 1 positions
            for (int i = 0; i <= n; i++) {

                if (!pq.isEmpty()) {

                    int freq = pq.poll();

                    freq--;

                    if (freq > 0) {
                        temp.add(freq);
                    }
                }

                time++;

                // If nothing is left, no need for idle time
                if (pq.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            // Put remaining tasks back
            for (int freq : temp) {
                pq.offer(freq);
            }
        }

        return time;
    }
}