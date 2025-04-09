package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) { return new Tweet(); }
}

class Node implements Comparable<Node> {
    Tweet tweet;
    int timestamp;
    static int time = 0;
    Node(Tweet t) { tweet = t; timestamp = time++; }
    public int compareTo(Node other) {
        if (this.timestamp < other.timestamp) return -1;
        if (this.timestamp == other.timestamp) return 0;
        return 1;
    }
}

public class I0501MiniTwitter {
    
    public class MiniTwitter {

        private Map<Integer, Set<Integer>> following = new HashMap<>();
        private Map<Integer, List<Node>> tweets = new HashMap<>();
        final int COUNT = 10;

        public MiniTwitter() {}
    
        public Tweet postTweet(int user_id, String tweet_text) {
            Tweet t = Tweet.create(user_id, tweet_text);
            if (!tweets.containsKey(user_id)) tweets.put(user_id, new ArrayList<>());
            tweets.get(user_id).add(new Node(t));
            return t;
        }

        private List<Node> getLast(List<Node> list, int count) {
            List<Node> ans = new ArrayList<>();
            for (int i = list.size() - 1, j = 0; i >= 0 && j < count; i--, j++) {
                ans.add(list.get(i));
            }
            return ans;
        }

        private List<Node> getLast(int user_id, int count) {
            List<Node> ans = new ArrayList<>();
            if (!tweets.containsKey(user_id)) return ans;
            return getLast(tweets.get(user_id), count);
        }

        private List<Tweet> getTweets(List<Node> list) {
            List<Tweet> ans = new ArrayList<>();
            for (Node x : list) ans.add(x.tweet);
            return ans;
        }
    
        public List<Tweet> getNewsFeed(int user_id) {
            List<Node> merged = new ArrayList<>();
            merged.addAll(getLast(user_id, COUNT));
            if (following.containsKey(user_id)) {
                for (int f : following.get(user_id)) {
                    merged.addAll(getLast(f, COUNT));
                }
            }
            Collections.sort(merged);
            merged = getLast(merged, COUNT);
            return getTweets(merged);
        }
    
        public List<Tweet> getTimeline(int user_id) {
            return getTweets(getLast(user_id, COUNT));
        }
    
        public void follow(int from_user_id, int to_user_id) {
            if (!following.containsKey(from_user_id)) following.put(from_user_id, new HashSet<>());
            following.get(from_user_id).add(to_user_id);
        }
    
        public void unfollow(int from_user_id, int to_user_id) {
            if (!following.containsKey(from_user_id)) return;
            Set<Integer> f = following.get(from_user_id);
            if (f.contains(to_user_id)) f.remove(to_user_id);
        }
    }
}
