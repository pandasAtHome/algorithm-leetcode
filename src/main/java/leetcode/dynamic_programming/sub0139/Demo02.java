package leetcode.dynamic_programming.sub0139;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")) + " = true");
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")) + " = true");
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")) + " = false");
    }

    class Solution {
        int n;
        char[] target;
        private Map<Character, List<char[]>> strToChars;

        public boolean wordBreak(String s, List<String> wordDict) {
            target = s.toCharArray();
            n = target.length;
            parseWordDict(wordDict);
            return findWord(0);
        }

        private void parseWordDict(List<String> wordDict) {
            strToChars = new HashMap<>();
            for (String s : wordDict) {
                char[] chars = s.toCharArray();
                if (!strToChars.containsKey(chars[0])) {
                    strToChars.put(chars[0], new ArrayList<>());
                }
                strToChars.get(chars[0]).add(chars);
            }
        }

        private boolean findWord(int pos) {
            if (pos == n) {
                return true;
            }
            char ch = target[pos];
            if (!strToChars.containsKey(ch)) {
                return false;
            }
            List<char[]> wordList = strToChars.get(ch);
            int len;
            boolean matching;
            int i;
            for (char[] word : wordList) {
                len = word.length;
                if (len + pos > n) {
                    continue;
                }
                ch = target[pos + len - 1];
                if (ch != word[len - 1]) {
                    continue;
                }
                matching = true;
                i = pos;
                for (int j = 0; j < len; j++) {
                    if (target[i++] != word[j]) {
                        matching = false;
                        break;
                    }
                }
                if (!matching) {
                    continue;
                }
                if (findWord(pos + len)) {
                    return true;
                }
            }
            return false;
        }
        
    }
}
