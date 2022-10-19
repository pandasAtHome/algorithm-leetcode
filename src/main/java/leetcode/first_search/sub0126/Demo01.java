package leetcode.first_search.sub0126;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        List<String> wordList;
        wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(solution.findLadders("hit", "cog", wordList));
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
        // 工作节点图
        Map<String, Node> wordNodes;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            result = new ArrayList<>();
            // 1、单词字典中，可能不包含 beginWord，加入构建
            wordList.add(beginWord);
            // 2、建立单词连接图：单词A => (匹配模式)连接点 => 单词B
            /* ----- 空间 O(n * L) ----- */
            /* +++++ 时间 O(n * L) +++++ */
            buildGraph(wordList, beginWord.length());
            if (!wordNodes.containsKey(endWord)) {
                // 3、不包含 endWord => 退出
                return result;
            }

            // 4、获取头节点，并初始化 坐标点为 0
            Node beginNode = wordNodes.get(beginWord);
            beginNode.index = 0;
            /** 5、构建路径方向，确定单词坐标点
             *       wordA(1) -- wordB(1)
             *        /               \
             * beginWord(0)          wordC(2) -- endWord(3)
             *        \               /
             *       wordD(1) -- wordB(1)
             */
            /* ----- 空间 O(n * L) ----- */
            /* +++++ 时间 O(n * L) +++++ */
            buildPathPosition(beginNode);

            // 6、判断是否可达
            Node endNode = wordNodes.get(endWord);
            if (endNode.index == Integer.MAX_VALUE) {
                // 不可达：beginNode ≠> endWord
                return result;
            }
            // 7、初始化路径位置
            /* ----- 空间 O(S) ----- */
            /* +++++ 时间 O(S) +++++ */
            List<String> deque = new ArrayList<>();
            deque.add(beginWord);
            for (int i = 0; i < endNode.index; i++) {
                deque.add("");
            }
            // 8、从后往前，寻找所有的最短路径
            /* ----- 空间 O(n * L) ----- */
            /* +++++ 时间 O(n * L) +++++ */
            backtrack(endNode, deque);

            return result;
        }

        class Node {
            String word;
            List<Node> neighborNodes;
            int index;

            Node(String word) {
                this.word = word;
                neighborNodes = new ArrayList<>();
                index = Integer.MAX_VALUE;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "word='" + word + '\'' +
                        ", index=" + index +
                        '}';
            }
        }

        // 连接节点，构建图
        private void buildGraph(List<String> words, int wordLen) {
            wordNodes = new HashMap<>();
            for (String word : words) {
                if (wordNodes.containsKey(word)) {
                    // 排除重复单词：即 beginWord
                    continue;
                }
                Node curNode = new Node(word);
                wordNodes.put(word, curNode);

                // 遍历每个单词 所有的匹配模式
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    char temp = wordChars[i];
                    // 替换位置用星号表示
                    wordChars[i] = '*';
                    // 匹配模型
                    String pattern = String.valueOf(wordChars);

                    // 建立关系：（匹配模式）连接点 => 单词节点
                    wordNodes.putIfAbsent(pattern, new Node(pattern));
                    Node connectedNode = wordNodes.get(pattern);

                    // 建立关系：单词节点 => （匹配模式）连接点
                    curNode.neighborNodes.add(connectedNode);
                    connectedNode.neighborNodes.add(curNode);

                    // 复原被替换字符
                    wordChars[i] = temp;
                }
            }
        }

        // 建立方向坐标
        private void buildPathPosition(Node curNode) {
            for (Node connectedNode : curNode.neighborNodes) {
                if (connectedNode.neighborNodes.size() == 1) {
                    continue;
                }
                for (Node nextNode : connectedNode.neighborNodes) {
                    if (nextNode.index > curNode.index + 1) {
                        nextNode.index = curNode.index + 1;
                        buildPathPosition(nextNode);
                    }
                }
            }
        }

        // 从后往前，寻找最短路径
        private void backtrack(Node curNode, List<String> deque) {
            if (curNode.index == 0) {
                result.add(new ArrayList<>(deque));
                return;
            }
            deque.set(curNode.index, curNode.word);
            for (Node connectedNode : curNode.neighborNodes) {
                for (Node prevNode : connectedNode.neighborNodes) {
                    // 寻找上一层级节点
                    if (prevNode.index == curNode.index - 1) {
                        backtrack(prevNode, deque);
                    }
                }
            }
        }
    }
}
