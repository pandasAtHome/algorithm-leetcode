package leetcode.data_structure.sub0332;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        List<List<String>> tickets;
        System.out.println("[JFK,MUC,LHR,SFO,SJC] ----");
        tickets = arrayToList(new String[][]{
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        });
        System.out.println(solution.findItinerary(tickets));
        System.out.println("[JFK,NRT,JFK,KUL] ----");
        tickets = arrayToList(new String[][]{
                {"JFK", "KUL"},
                {"JFK", "NRT"},
                {"NRT", "JFK"}
        });
        System.out.println(solution.findItinerary(tickets));
        System.out.println("[JFK,ATL,JFK,SFO,ATL,SFO] ----");
        /*
         * {
         *   JFK: [ATL, SFO],
         *   ATL: [JFK, SFO],
         *   SFO: [ATL]
         * }
         *
         * JFK -> ATL -> JFK -> SFO -> ATL -> SFO
         */
        tickets = arrayToList(new String[][]{
                {"JFK", "SFO"},
                {"JFK", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "JFK"},
                {"ATL", "SFO"}
        });
        System.out.println(solution.findItinerary(tickets));
    }

    public static List<List<String>> arrayToList(String[][] tickets) {
        List<List<String>> result = new ArrayList<>();
        for (String[] ticket : tickets) {
            result.add(Arrays.asList(ticket));
        }

        return result;
    }

    class Solution {
        Map<String, Queue<String>> graph;
        List<String> result;

        public List<String> findItinerary(List<List<String>> tickets) {
            // 建立站点路径：{起始站: [终点站, ...]}
            /* ----- 空间 O(n) ----- */
            graph = new HashMap<>();
            /* +++++ 时间 O(n) +++++ */
            for (List<String> ticket : tickets) {
                // 按终点站名字升序
                Queue<String> queue = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
                queue.offer(ticket.get(1));
                graph.put(ticket.get(0), queue);
            }
            result = new ArrayList<>();
            // 从 JFK 出发，寻找所有路径
            /* +++++ 时间 O(n) +++++ */
            dfs("JFK");
            Collections.reverse(result);

            return result;
        }

        private void dfs(String start) {
            /*
             * 入队条件：
             * 1、已经是终点站：queue == null
             * 2、起始站的机票已经遍历完
             */
            Queue<String> queue = graph.get(start);
            if (queue != null) {
                while (!queue.isEmpty()) {
                    dfs(queue.poll());
                }
            }
            result.add(start);
        }
    }
}
