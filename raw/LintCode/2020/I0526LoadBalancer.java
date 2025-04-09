package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class LoadBalancer {

    Map<Integer, Integer> serverId2Index = new HashMap<>();
    List<Integer> serverIds = new ArrayList<>();

    public LoadBalancer() {}

    public void add(int server_id) {
        // assume server_id is unique
        serverId2Index.put(server_id, serverIds.size());
        serverIds.add(server_id);
    }

    private void swap(int i, int j) {
        int tmp = serverIds.get(i);
        serverIds.set(i, serverIds.get(j));
        serverIds.set(j, tmp);
        serverId2Index.put(serverIds.get(i), i);
        serverId2Index.put(serverIds.get(j), j);
    }

    private void pop() {
        int lastServerId = serverIds.get(serverIds.size()-1);
        serverId2Index.remove(lastServerId);
        serverIds.remove(serverIds.size()-1);
    }

    public void remove(int server_id) {
        if (!serverId2Index.containsKey(server_id)) return;
        int i = serverId2Index.get(server_id);
        int j = serverIds.size() - 1;
        swap(i, j);
        pop();
    }

    public int pick() { return serverIds.get((int)(Math.random() * serverIds.size())); }
}


public class I0526LoadBalancer {
}
