package leetcode.sub0126;

import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        List<String> wordList;
        wordList = new ArrayList<>(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));
        System.out.println(solution.findLadders("nape", "mild", wordList));
        System.out.println("[[nape, gape, gale, male, mile, mild], [nape, nope, mope, mole, mold, mild], [nape, naps, nips, nils, mils, mild], [nape, rape, ripe, rile, mile, mild], [nape, tape, tale, tile, mile, mild], [nape, nope, mope, mole, mile, mild], [nape, nate, mate, mite, mile, mild], [nape, tape, tale, male, mile, mild], [nape, nate, mate, male, mile, mild]]");
//        wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        System.out.println(solution.findLadders("hit", "cog", wordList));
//        wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
//        System.out.println(solution.findLadders("hit", "cog", wordList));
//        wordList = new ArrayList<>(Arrays.asList("a","b","c"));
//        System.out.println(solution.findLadders("a", "c", wordList));
//        wordList = new ArrayList<>(Arrays.asList("aaaaa","waaaa","wbaaa","xaaaa","xbaaa","bbaaa","bbwaa","bbwba","bbxaa","bbxba","bbbba","wbbba","wbbbb","xbbba","xbbbb","cbbbb","cwbbb","cwcbb","cxbbb","cxcbb","cccbb","cccwb","cccwc","cccxb","cccxc","ccccc","wcccc","wdccc","xcccc","xdccc","ddccc","ddwcc","ddwdc","ddxcc","ddxdc","ddddc","wdddc","wdddd","xdddc","xdddd","edddd","ewddd","ewedd","exddd","exedd","eeedd","eeewd","eeewe","eeexd","eeexe","eeeee","weeee","wfeee","xeeee","xfeee","ffeee","ffwee","ffwfe","ffxee","ffxfe","ffffe","wfffe","wffff","xfffe","xffff","gffff","gwfff","gwgff","gxfff","gxgff","gggff","gggwf","gggwg","gggxf","gggxg","ggggg","wgggg","whggg","xgggg","xhggg","hhggg","hhwgg","hhwhg","hhxgg","hhxhg","hhhhg","whhhg","whhhh","xhhhg","xhhhh","ihhhh","iwhhh","iwihh","ixhhh","ixihh","iiihh","iiiwh","iiiwi","iiixh","iiixi","iiiii","wiiii","wjiii","xiiii","xjiii","jjiii","jjwii","jjwji","jjxii","jjxji","jjjji","wjjji","wjjjj","xjjji","xjjjj","kjjjj","kwjjj","kwkjj","kxjjj","kxkjj","kkkjj","kkkwj","kkkwk","kkkxj","kkkxk","kkkkk","wkkkk","wlkkk","xkkkk","xlkkk","llkkk","llwkk","llwlk","llxkk","llxlk","llllk","wlllk","wllll","xlllk","xllll","mllll","mwlll","mwmll","mxlll","mxmll","mmmll","mmmwl","mmmwm","mmmxl","mmmxm","mmmmm","wmmmm","wnmmm","xmmmm","xnmmm","nnmmm","nnwmm","nnwnm","nnxmm","nnxnm","nnnnm","wnnnm","wnnnn","xnnnm","xnnnn","onnnn","ownnn","owonn","oxnnn","oxonn","ooonn","ooown","ooowo","oooxn","oooxo","ooooo","woooo","wpooo","xoooo","xpooo","ppooo","ppwoo","ppwpo","ppxoo","ppxpo","ppppo","wpppo","wpppp","xpppo","xpppp","qpppp","qwppp","qwqpp","qxppp","qxqpp","qqqpp","qqqwp","qqqwq","qqqxp","qqqxq","qqqqq","wqqqq","wrqqq","xqqqq","xrqqq","rrqqq","rrwqq","rrwrq","rrxqq","rrxrq","rrrrq","wrrrq","wrrrr","xrrrq","xrrrr","srrrr","swrrr","swsrr","sxrrr","sxsrr","sssrr","ssswr","sssws","sssxr","sssxs","sssss","wssss","wtsss","xssss","xtsss","ttsss","ttwss","ttwts","ttxss","ttxts","tttts","wttts","wtttt","xttts","xtttt","utttt","uwttt","uwutt","uxttt","uxutt","uuutt","uuuwt","uuuwu","uuuxt","uuuxu","uuuuu","zzzzz","zzzzy","zzzyy","zzyyy","zzyyx","zzyxx","zzxxx","zzxxw","zzxww","zzwww","zzwwv","zzwvv","zzvvv","zzvvu","zzvuu","zzuuu","zzuut","zzutt","zzttt","zztts","zztss","zzsss","zzssr","zzsrr","zzrrr","zzrrq","zzrqq","zzqqq","zzqqp","zzqpp","zzppp","zzppo","zzpoo","zzooo","zzoon","zzonn","zznnn","zznnm","zznmm","zzmmm","zzmml","zzmll","zzlll","zzllk","zzlkk","zzkkk","zzkkj","zzkjj","zzjjj","zzjji","zzjii","zziii","zziih","zzihh","zzhhh","zzhhg","zzhgg","zzggg","zzggf","zzgff","zzfff","zzffe","zzfee","zzeee","zzeed","zzedd","zzddd","zzddc","zzdcc","zzccc","zzccz","azccz","aaccz","aaacz","aaaaz","uuuzu","uuzzu","uzzzu","zzzzu"));
//        System.out.println(solution.findLadders("aaaaa", "uuuuu", wordList));
    }

    class Solution {
        // 结果集
        List<List<String>> result;
        // 可达树：{当前单词 : 可到达的下一层单词}
        HashMap<String, List<String>> reachableTree;
        Map<Integer, Set<Character>> charsOfCol;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            result = new ArrayList<>();
            Set<String> words = new HashSet<>(wordList);
            // 1、检测 `endWord` 是否在 `wordList` 中
            if (!words.contains(endWord)) {
                return result;
            }

            Set<String> begins = new HashSet<>(), ends = new HashSet<>();
            begins.add(beginWord);
            ends.add(endWord);
            reachableTree = new HashMap<>();
            parseColChar(wordList);

            // 2、可达性检测
            if (reachable(words, begins, ends, false)) {
                ArrayDeque<String> deque = new ArrayDeque<>();
                deque.add(beginWord);
                backtracking(beginWord, endWord, deque);
            }
            return result;
        }

        private void parseColChar(List<String> wordList) {
            charsOfCol = new HashMap<>();
            for (String word : wordList) {
                int length = word.length();
                for (int i = 0; i < length; i++) {
                    if (!charsOfCol.containsKey(i)) {
                        charsOfCol.put(i, new HashSet<>());
                    }
                    charsOfCol.get(i).add(word.charAt(i));
                }
            }
        }

        private boolean reachable(Set<String> words, Set<String> begins, Set<String> ends, boolean reversed) {
            if (begins.isEmpty()) {
                return false;
            }
            words.removeAll(begins);
            Set<String> nextLevelWords = new HashSet<>();
            String key, nextWord;
            boolean found = false;
            for (String word : begins) {
                char[] wordCharArr = word.toCharArray();
                int size = word.length();
                for (int i = 0; i < size; i++) {
                    char temp = wordCharArr[i];
                    Set<Character> chars = charsOfCol.get(i);
                    for (Character ch : chars) {
                        wordCharArr[i] = ch;
                        String str = String.valueOf(wordCharArr);
                        if (!words.contains(str)) {
                            continue;
                        }
                        nextLevelWords.add(str);
                        if (ends.contains(str)) {
                            found = true;
                        }
                        if (reversed) {
                            key = str;
                            nextWord = word;
                        } else {
                            key = word;
                            nextWord = str;
                        }
                        if (!reachableTree.containsKey(key)) {
                            reachableTree.put(key, new ArrayList<>());
                        }
                        reachableTree.get(key).add(nextWord);
                    }
                    wordCharArr[i] = temp;
                }
            }
            if (found) {
                return true;
            }
            if (nextLevelWords.size() > ends.size()) {
                return reachable(words, ends, nextLevelWords, !reversed);
            }
            return reachable(words, nextLevelWords, ends, reversed);
        }

        private void backtracking(String beginWord, String endWord, ArrayDeque<String> deque) {
            if (beginWord.equals(endWord)) {
                result.add(new ArrayList<>(deque));
                return;
            }
            List<String> words = reachableTree.get(beginWord);
            if (words == null) {
                return;
            }
            for (String word : words) {
                deque.addLast(word);
                backtracking(word, endWord, deque);
                deque.removeLast();
            }
        }
    }
}
