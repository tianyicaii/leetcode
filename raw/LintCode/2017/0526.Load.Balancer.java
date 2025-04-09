
/*

Implement a load balancer for web servers. It provide the following functionality:

Add a new server to the cluster => add(server_id).
Remove a bad server from the cluster => remove(server_id).
Pick a server in the cluster randomly with equal probability => pick().

Example
    At beginning, the cluster is empty => {}.
    add(1)
    add(2)
    add(3)
    pick()
    >> 1         // the return value is random, it can be either 1, 2, or 3.
    pick()
    >> 2
    pick()
    >> 1
    pick()
    >> 3
    remove(1)
    pick()
    >> 2
    pick()
    >> 3
    pick()
    >> 3


*/


    public class LoadBalancer {

        private Map<Integer, Integer> id2index = new HashMap<Integer, Integer>();  // map server id to index on list
        private ArrayList<Integer> servers = new ArrayList<Integer>();  // list support get(randomIndex)

        public void add (int id) {  // assume server to be does not exist
            id2index.put(id, servers.size());  // add to tail of the list
            servers.add(id);
        }

        public void remove (int id) {  // assume server to be removed exists
            int index = id2index.get(id);
            servers.set(index, servers.get(servers.size() - 1));  // set tail to empty spot
            id2index.put(servers.get(index), index);  // change tail's index
            id2index.remove(id); 
            servers.remove(servers.size() - 1);  // need to remove tail in the end in case the server to remove was the tail
        }

        public int pick() {
            int random = (int)(Math.random() * servers.size());
            return servers.get(random);
        } 
    }
