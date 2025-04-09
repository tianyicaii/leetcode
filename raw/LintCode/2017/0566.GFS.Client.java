/*

Implement a simple client for GFS (Google File System, a distributed file system), it provides the following methods:

read(filename). Read the file with given filename from GFS.
write(filename, content). Write a file with given filename & content to GFS.
There are two private methods that already implemented in the base class:

readChunk(filename, chunkIndex). Read a chunk from GFS.
writeChunk(filename, chunkIndex, chunkData). Write a chunk to GFS.
To simplify this question, we can assume that the chunk size is chunkSize bytes. (In a real world system, it is 64M). The GFS Client's job is splitting a file into multiple chunks (if need) and save to the remote GFS server. chunkSize will be given in the constructor. You need to call these two private methods to implement read & write methods.

Example
    GFSClient(5)  // chunckSize = 5;
    read("a.txt")
    >> null
    write("a.txt", "World")
    >> You don't need to return anything, but you need to call writeChunk("a.txt", 0, "World") to write a 5 bytes chunk to GFS.
    read("a.txt")
    >> "World"
    write("b.txt", "111112222233")
    >> You need to save "11111" at chink 0, "22222" at chunk 1, "33" at chunk 2.
    write("b.txt", "aaaaabbbbb")
    read("b.txt")
    >> "aaaaabbbbb"

*/

    class BaseGFSClient {
        private Map<String, String> chunk_list;
        public BaseGFSClient() {}
        public String readChunk(String filename, int chunkIndex) { return null; }
        public void writeChunk(String filename, int chunkIndex, String content) { }
    }
    
    public class GFSClient extends BaseGFSClient {

        public int chunkSize;
        public Map<String, Integer> numChunks = new HashMap<>();  // how many chunk are there in each file

        public GFSClient(int chunkSize) { this.chunkSize = chunkSize; }
        
        public String read (String filename) {
            if (!numChunks.containsKey(filename)) return null;  // does not contain file
            StringBuffer content = new StringBuffer();
            for (int i = 0; i < numChunks.get(filename); ++i) {
                String block = readChunk(filename, i);
                content.append(block);
            }
            return content.toString();
        }

        public void write (String filename, String content) {
            int length = content.length();
            int count = 0;
            if (length % chunkSize == 0) count = length / chunkSize;
            else count = length / chunkSize + 1;
            numChunks.put(filename, count);
            for (int i = 0; i < count; ++i) {
                int start = i * chunkSize;
                int end = ((i + 1) * chunkSize) > length ? length : ((i + 1) * chunkSize);
                String block = content.substring(start, end);
                writeChunk(filename, i, block);
            }
        }
    }
