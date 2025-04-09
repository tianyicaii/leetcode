/*

In the Master-Slave architecture, slave server will ping master in every k seconds to tell master server he is alive.
If a master server didn't receive any ping request from a slave server in 2 * k seconds,
the master will trigger an alarm (for example send an email) to administrator.

Let's mock the master server, you need to implement the following three methods:
    initialize(slaves_ip_list, k). salves_ip_list is a list of slaves' ip addresses. k is ping time interval.
    ping(timestamp, slave_ip). This method will be called every time master received a ping request from one of the slave server.
            timestamp is the current timestamp in seconds. slave_ip is the ip address of the slave server who pinged master.
    getDiedSlaves(timestamp). This method will be called periodically (it's not guaranteed how long between two calls).
            timestamp is the current timestamp in seconds, and you need to return a list of slaves' ip addresses that died.
            Return an empty list if no died slaves found.
You can assume that when the master started, the timestamp is 0, and every method will be called with an global increasing timestamp.


Example
    initialize(["10.173.0.2", "10.173.0.3"], 10)
    ping(1, "10.173.0.2")
    getDiedSlaves(20)
    >> ["10.173.0.3"]
    getDiedSlaves(21)
    >> ["10.173.0.2", "10.173.0.3"]
    ping(22, "10.173.0.2")  // come back to life again
    ping(23, "10.173.0.3")  // come back to life again
    getDiedSlaves(24)
    >> []
    getDiedSlaves(42)
    >> ["10.173.0.2"]

*/


    public class HeartBeat {

        public Map<String, Integer> lastPings = new HashMap<String, Integer>();;
        public int k;

        public void initialize (List<String> slavesIpList, int k) {
            this.k = k;
            for (String ip : slavesIpList)
                this.lastPings.put(ip, 0);
        }

        public void ping (int timestamp, String slave_ip) {
            if (!lastPings.containsKey(slave_ip)) return;
            lastPings.put(slave_ip, timestamp);
        }

        public List<String> getDiedSlaves (int timestamp) {
            List<String> ans = new ArrayList<String>();
            for (Map.Entry<String, Integer> e : lastPings.entrySet()) {
                    if (timestamp - e.getValue() >= 2 * k)
                        ans.add(e.getKey());

            }
            return ans;
        }
    }
