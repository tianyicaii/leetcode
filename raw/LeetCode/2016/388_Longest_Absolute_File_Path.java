// https://leetcode.com/contest/1/problems/longest-absolute-file-path/


public class Solution {


	private class MyFile {
		
		int level;
		boolean isFile;
		String fileName;
		
		public MyFile (int level, boolean isFile, String fileName) {
			this.level = level;
			this.isFile = isFile;
			this.fileName  = fileName;
		}
		
		public String toString() {
			StringBuilder ans = new StringBuilder();
			ans.append('\n');
			for (int i = 0; i < level - 1; i++) {
				ans.append("    ");
			}
			ans.append(fileName);
			if (isFile) ans.append("  *");
			ans.append("(" + level + ")");
			ans.append('\n');
			return ans.toString();
		}
	}
	
	
	private MyFile getFile (String rawName) {
		
		int level = 0;
		boolean isFile = false;
		String fileName = null;
		
		String[] s = rawName.split("\\t");
		level = s.length;
		if (s[s.length - 1].indexOf('.') != -1) isFile = true;				
		fileName = s[s.length - 1];
		
		return new MyFile(level, isFile, fileName);
	}
	
	
	private List<MyFile> getFiles(String input) {
		List<MyFile> ans = new ArrayList<>();

		String[] rawNames = input.split("\\n");
		for (String s : rawNames)
			ans.add(getFile(s));
		return ans;
	}

	
	public int lengthLongestPath (String input) {

		List<MyFile> files = getFiles(input);

		int max = 0;
		int pre = 0;
		Deque<MyFile> stack = new ArrayDeque<>();
		for (MyFile f : files) {
			while (f.level <= stack.size()) {
				MyFile dir = stack.pollLast();
				pre -= dir.fileName.length() + 1;  // plus one for '/'
			}
			if (f.isFile) {
				max = Math.max(max, pre + f.fileName.length());
			}
			else {
				pre += f.fileName.length() + 1;  // plus one for '/'
				stack.offerLast(f);
			}
		}
		
		
		// System.out.println(files);
		return max;
	}		
		

}

