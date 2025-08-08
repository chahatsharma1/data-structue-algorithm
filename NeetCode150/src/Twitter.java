import java.util.*;

public class Twitter {
    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private int timeStamp;
    private final HashMap<Integer, List<Tweet>> userTweets;
    private final HashMap<Integer, Set<Integer>> following;

    public Twitter() {
        timeStamp = 0;
        userTweets = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        if(userTweets.containsKey(userId)){
            maxHeap.addAll(userTweets.get(userId));
        }

        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());
        for(int followeesId : followees){
            if(userTweets.containsKey(followeesId)){
                maxHeap.addAll(userTweets.get(followeesId));
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;

        while (!maxHeap.isEmpty() && count < 10){
            feed.add(maxHeap.poll().tweetId);
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}