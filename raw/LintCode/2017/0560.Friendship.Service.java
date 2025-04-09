/*
    Support follow & unfollow, getFollowers, getFollowings.
*/

    public class FriendshipService { 

        private Map<Integer, Set<Integer>> followings;
        private Map<Integer, Set<Integer>> followers;
        
        public FriendshipService() {
            this.followers = new HashMap<Integer, Set<Integer>>();
            this.followings = new HashMap<Integer, Set<Integer>>();
        }

        public List<Integer> getFollowers (int id) {
            if (!followers.containsKey(id))
                return new ArrayList<Integer>();  // empty
            return new ArrayList<Integer>(followers.get(id));
        }
        
        public List<Integer> getFollowings (int id) {
            if (!followings.containsKey(id))
                return new ArrayList<Integer>();  // empty
            return new ArrayList<Integer>(followings.get(id));
        }

        public void follow (int to, int from) {
            if (!followers.containsKey(to))
                followers.put(to, new TreeSet<Integer>());  // ordered
            followers.get(to).add(from);
            if (!followings.containsKey(from))
                followings.put(from, new TreeSet<Integer>());
            followings.get(from).add(to);
        }

        public void unfollow (int to, int from) {
            if (followers.containsKey(to))
                followers.get(to).remove(from);
            if (followings.containsKey(from))
                followings.get(from).remove(to);
        }
    }
