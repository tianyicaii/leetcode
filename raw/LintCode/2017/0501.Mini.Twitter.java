/*

Implement a simple twitter. Support the following method:

postTweet(user_id, tweet_text). Post a tweet.

getTimeline(user_id). Get the given user's most recently 10 tweets posted by himself, 
order by timestamp from most recent to least recent.

getNewsFeed(user_id). Get the given user's most recently 10 tweets in his news feed (posted by his friends and himself). 
Order by timestamp from most recent to least recent.

follow(from_user_id, to_user_id). from_user_id followed to_user_id.
unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.

*/


    // given Tweet class
    public static class Tweet {
        public int id;
        public int user_id;
        public String text;
        public static Tweet create (int user_id, String tweet_text) { return null; }
    }
    
    public class MiniTwitter {
        
        class Node implements Comparable<Node>{
            public int timeStamp;  // wrap around tweet to add timestamp
            public Tweet tweet;
            public Node (int o, Tweet t) {
                this.timeStamp = o;
                this.tweet = t;
            }
            public int compareTo (Node other) {  // ordered by time
                    return this.timeStamp - other.timeStamp;
            }
        }

        private Map<Integer, Set<Integer>> friends;  // map user id to its friends ids
        private Map<Integer, List<Node>> tweets;  // map user id to its tweets
        private int timeStamp;
        
        public MiniTwitter() {
            this.friends = new HashMap<Integer, Set<Integer>>();
            this.tweets = new HashMap<Integer, List<Node>>();
            this.timeStamp = 0;
        }
    
        public Tweet postTweet (int user, String text) {
            Tweet tweet = Tweet.create(user, text);
            if (!tweets.containsKey(user))  // first tweet
                    tweets.put(user, new ArrayList<Node>());
            tweets.get(user).add(new Node(timeStamp++, tweet));  // each list is in increasing time order
            return tweet;
        }

        public List<Tweet> getNewsFeed (int user) {
            List<Node> feed = new ArrayList<Node>();
            if (tweets.containsKey(user))  // user's most recent tweet
                    feed.addAll(getLastTen(tweets.get(user)));
            if (friends.containsKey(user)) {  // friends' most recent tweet
                for (Integer friend : friends.get(user)) {
                    if (tweets.containsKey(friend))
                            feed.addAll(getLastTen(tweets.get(friend)));
                }
            }

            Collections.sort(feed);  // get sorted by time order
            feed = getLastTen(feed);  // get overral most recent, also reverse the order
            List<Tweet> ans = new ArrayList<>();
            for (Node node : feed) {
                ans.add(node.tweet);
            }
            return ans;
        }
            
        public List<Tweet> getTimeline (int user) {
            List<Node> list = new ArrayList<Node>();
            if (tweets.containsKey(user))
                    list.addAll(getLastTen(tweets.get(user)));  // will reverse order as well
            List<Tweet> ans = new ArrayList<Tweet>();           
            for (Node node : list)
                ans.add(node.tweet);
            return ans;
        }
        
        private List<Node> getLastTen (List<Node> list) {  // pick last ten from given list, also revere the order
                List<Node> lastTen = new ArrayList<>();
                for (int i = list.size() - 1; list.size() - i <= 10 && i >= 0; i--) {
                    lastTen.add(list.get(i));
                }
                return lastTen;
        }

        public void follow (int from, int to) {
            if (!friends.containsKey(from))
                friends.put(from, new HashSet<Integer>());
            friends.get(from).add(to);
        }

        public void unfollow (int from, int to) {
            if (friends.containsKey(from))  // no effect if not following
                friends.get(from).remove(to);
        }
    }
