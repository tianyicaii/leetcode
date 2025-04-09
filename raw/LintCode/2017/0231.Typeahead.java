
/*

Implement typeahead. Given a string and a dictionary, return all words that contains the string as a substring.
The dictionary will give at the initialize method and wont be changed.
The method to find all words with given substring would be called multiple times.

Example

    Given dictionary = {"Jason Zhang", "James Yu", "Bob Zhang", "Larry Shi"}
    search "Zhang", return ["Jason Zhang", "Bob Zhang"].
    search "James", return ["James Yu"].

*/


    public class Typeahead {
        
        private HashMap<String, List<String>> map = new HashMap<String , List<String>>();
        
        public Typeahead(Set<String> dict) {
            
            for (String str : dict) {
                for (int i = 0; i < str.length(); ++i) {  // use all possible substrings as indices
                    for (int j = i + 1; j <= str.length(); ++j) {
                            String key = str.substring(i, j);
                            
                            
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<String>());
                            map.get(key).add(str);
                        } else {
                            List<String> words = map.get(key);
                            if (!str.equals(words.get(words.size() - 1))) {  // avoid duplicate, same substring may appear more than once in a word
                                    words.add(str);
                            }
                        }
                        
                        
                    }
                }
            }
        }

        public List<String> search(String str) {
            if (!map.containsKey(str)) return new ArrayList<String>();  // return empty list instead of null
            else return map.get(str);
        }
    }   
