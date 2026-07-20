class Twitter {

    private HashMap<Integer, List<Tweet>> tweets;
    private HashMap<Integer, HashSet<Integer>> followMap;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time)
        );

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        Set<Integer> users = new HashSet<>();

        // User sees their own tweets
        users.add(userId);

        // Add users they follow
        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        // Max heap: newest tweet first
        PriorityQueue<Tweet> pq =
            new PriorityQueue<>(
                (a, b) -> b.time - a.time
            );

        // Add all relevant tweets
        for (int user : users) {

            if (tweets.containsKey(user)) {

                for (Tweet tweet : tweets.get(user)) {
                    pq.offer(tweet);
                }
            }
        }

        // Get at most 10 newest tweets
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {

            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}


class Tweet {

    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

