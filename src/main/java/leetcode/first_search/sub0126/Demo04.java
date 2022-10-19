package leetcode.first_search.sub0126;

import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        Solution solution = new Demo04().new Solution();
        List<String> wordList;
        wordList = new ArrayList<>(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));
        System.out.println(solution.findLadders("nape", "mild", wordList));
        System.out.println("[[nape, gape, gale, male, mile, mild], [nape, nope, mope, mole, mold, mild], [nape, naps, nips, nils, mils, mild], [nape, rape, ripe, rile, mile, mild], [nape, tape, tale, tile, mile, mild], [nape, nope, mope, mole, mile, mild], [nape, nate, mate, mite, mile, mild], [nape, tape, tale, male, mile, mild], [nape, nate, mate, male, mile, mild]]");
//        wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        System.out.println(solution.findLadders("hit", "cog", wordList));
//        wordList = new ArrayList<>(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));
//        System.out.println(solution.findLadders("nape", "mild", wordList));
//        System.out.println("[[nape, gape, gale, male, mile, mild], [nape, nope, mope, mole, mold, mild], [nape, naps, nips, nils, mils, mild], [nape, rape, ripe, rile, mile, mild], [nape, tape, tale, tile, mile, mild], [nape, nope, mope, mole, mile, mild], [nape, nate, mate, mite, mile, mild], [nape, tape, tale, male, mile, mild], [nape, nate, mate, male, mile, mild]]");
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
        int wordLen;
        Map<String, Set<String>> patterns;
        Map<String, Set<String>> relations;
        Map<String, List<String>> reachableTree;
        int size = 0;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            result = new ArrayList<>();
            wordList.add(beginWord);
            wordLen = beginWord.length();
            buildPatterns(wordList);
            if (!patterns.containsKey(endWord)) {
                return result;
            }

            Set<String> words = new HashSet<>(wordList);
//            words.remove(beginWord);

            Set<String> begins = new HashSet<>(), ends = new HashSet<>();
            begins.add(beginWord);
            ends.add(endWord);

            reachableTree = new HashMap<>();

            if (reachable(words, begins, ends, false)) {
                Deque<String> queue = new LinkedList<>();
                queue.add(beginWord);
                backtrack(beginWord, endWord, queue);
            }

            return result;
        }

        private void buildPatterns(List<String> wordList) {
            patterns = new HashMap<>();
            Map<String, Set<String>> result = new HashMap<>();
            for (String word : wordList) {
                if (result.containsKey(word)) {
                    continue;
                }
                patterns.put(word, new HashSet<>());
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    char temp = wordChars[i];
                    wordChars[i] = '*';

                    String pattern = String.valueOf(wordChars);
                    result.putIfAbsent(pattern, new HashSet<>());

                    patterns.get(word).add(pattern);
                    result.get(pattern).add(word);

                    wordChars[i] = temp;
                }
            }
            relations = new HashMap<>();
            for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
                if (entry.getValue().size() == 1) {
                    continue;
                }
                relations.put(entry.getKey(), entry.getValue());
            }
        }

        private boolean reachable(Set<String> words, Set<String> begins, Set<String> ends, boolean reversed) {
            boolean found = false;
            words.removeAll(begins);
            Set<String> nextLevelWords = new HashSet<>();
            Set<String> nextWords;
            String key, nextWord;
            for (String curWord : begins) {
                Set<String> nextWordPatterns = patterns.remove(curWord);
                for (String pattern : nextWordPatterns) {
                    if (!relations.containsKey(pattern)) {
                        continue;
                    }
                    nextWords = relations.get(pattern);
                    for (String word : nextWords) {
                        if (!words.contains(word)) {
                            continue;
                        }
                        if (ends.contains(word)) {
                            found = true;
                        }
                        if (reversed) {
                            key = word;
                            nextWord = curWord;
                        } else {
                            key = curWord;
                            nextWord = word;
                        }

                        reachableTree.putIfAbsent(key, new ArrayList<>());
                        reachableTree.get(key).add(nextWord);

                        nextLevelWords.add(word);
                    }
                }
            }
            if (found) {
                return true;
            }
            if (nextLevelWords.isEmpty()) {
                return false;
            }

            if (nextLevelWords.size() > ends.size()) {
                begins = ends;
                ends = nextLevelWords;
                reversed = !reversed;
            } else {
                begins = nextLevelWords;
            }
            return reachable(words, begins, ends, reversed);
        }

        private void backtrack(String beginWord, String endWord, Deque<String> queue) {
            if (endWord.equals(beginWord)) {
                result.add(new ArrayList<>(queue));
                System.out.println(queue);
                return;
            }
            if (!reachableTree.containsKey(beginWord)) {
                System.out.println(queue);
                return;
            }
            for (String nextWord : reachableTree.get(beginWord)) {
                queue.add(nextWord);
                backtrack(nextWord, endWord, queue);
                queue.removeLast();
            }
        }
    }
}
