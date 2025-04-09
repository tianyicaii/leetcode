/*

Cassandra is a NoSQL storage. The structure has two-level keys.

Level 1: raw_key. The same as hash_key or shard_key.
Level 2: column_key.
Level 3: column_value
raw_key is used to hash and can not support range query. let's simplify this to a string.
column_key is sorted and support range query. let's simplify this to integer.
column_value is a string. you can serialize any data into a string and store it in column value.

implement the following methods:
    insert(raw_key, column_key, column_value)
    query(raw_key, column_start, column_end) // return a list of entries

Example
    insert("google", 1, "haha")
    query("google", 0, 1)
    >> [（1, "haha")]

*/


    public class Column {
        public int key;
        public String value;
        public Column (int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public class MiniCassandra {

        private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public void insert (String raw_key, int column_key, String column_value) {
            if (!map.containsKey(raw_key))
                map.put(raw_key, new TreeMap<Integer, String>());
            map.get(raw_key).put(column_key, column_value);
        }

        public List<Column> query (String raw_key, int column_start, int column_end) {
            List<Column> ans = new ArrayList<Column>();
            if (!map.containsKey(raw_key))
                return ans;  // empty
            
            SortedMap<Integer, String> range = map.get(raw_key).subMap(column_start, column_end + 1);
            for (Map.Entry<Integer, String> e : range.entrySet()) {
                    ans.add(new Column(e.getKey(), e.getValue()));
            }
            
            return ans;
        }
    }   
