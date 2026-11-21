
class CountSquares {

    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yCounts = points.get(x);

        yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int total = 0;

        for (int x2 : points.keySet()) {

            if (x2 == x) {
                continue;
            }

            Map<Integer, Integer> yCounts = points.get(x2);

            for (Map.Entry<Integer, Integer> entry
                    : yCounts.entrySet()) {

                int y2 = entry.getKey();
                int diagonalCount = entry.getValue();

                if (Math.abs(x2 - x) != Math.abs(y2 - y)) {
                    continue;
                }

                int corner1 = getCount(x, y2);
                int corner2 = getCount(x2, y);

                total += diagonalCount * corner1 * corner2;
            }
        }

        return total;
    }

    private int getCount(int x, int y) {
        if (!points.containsKey(x)) {
            return 0;
        }

        return points.get(x).getOrDefault(y, 0);
    }
}
