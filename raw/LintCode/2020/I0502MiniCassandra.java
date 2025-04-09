package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class I0502MiniCassandra {
    

    public class Column {
        public int key;
        public String value;
        public Column(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    public class MiniCassandra {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public MiniCassandra() {}
    
        public void insert(String row_key, int column_key, String value) {
            if (!map.containsKey(row_key)) map.put(row_key, new TreeMap<>());
            Map<Integer, String> tm = map.get(row_key);
            tm.put(column_key, value);
        }

        public List<Column> query(String row_key, int column_start, int column_end) {
            List<Column> ans = new ArrayList<>();
            if (!map.containsKey(row_key)) return ans;
            SortedMap<Integer, String> tm = map.get(row_key).subMap(column_start, column_end + 1);
            for (Map.Entry<Integer, String> e : tm.entrySet()) {
                ans.add(new Column(e.getKey(), e.getValue()));
            }
            return ans;
        }
    }

}
