/*

Create an inverted index with given documents.

Notice: Ensure that data does not include punctuation.

Example
    Given a list of documents with id and content. (class Document)
        [
            {
                "id": 1,
                "content": "This is the content of document 1 it is very short"
            },
            {
                "id": 2,
                "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
            },
        ]

    Return an inverted index (HashMap with key is the word and value is a list of document ids).
    {
       "This": [1, 2],
       "is": [1, 2],
       ...
    }

*/


public class Solution {

    class Document {
      public int id;
      public String content;
    }

    public Map<String, List<Integer>> invertedIndex (List<Document> docs) {
        Map<String, List<Integer>> ans = new HashMap<String, List<Integer>>();
        for (Document doc : docs) {
            
            StringBuffer word = new StringBuffer("");

            for (int i = 0; i < doc.content.length(); ++i) {
                if (doc.content.charAt(i) == ' ') {  // assume each word is separated by spaces
                    insert(ans, word.toString(), doc.id);
                    word = new StringBuffer("");
                } else
                    word.append(doc.content.charAt(i));
            }
            insert(ans, word.toString(), doc.id);  // insert the last word
        }
        return ans;
    }

    public void insert (Map<String, List<Integer>> index, String word, int id) {
        if (word.equals("") || word == null) return;
        if (!index.containsKey(word))
            index.put(word, new ArrayList<Integer>());
        
        if (index.get(word).isEmpty() || index.get(word).get(index.get(word).size() - 1) != id)  // avoid repeated appearance in one document
            index.get(word).add(id);
    }
}
