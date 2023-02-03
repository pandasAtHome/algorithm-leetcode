package leetcode.data_structure.sub0332;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            graph = new HashMap<>();
            for (List<String> ticket : tickets) {
                Queue<String> queue = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
                queue.offer(ticket.get(1));
                graph.put(ticket.get(0), queue);
            }
            result = new ArrayList<>();
            dfs();
            Collections.reverse(result);

            return result;
        }

        private void dfs() {
            Deque<String> stack = new ArrayDeque<>();
            stack.push("JFK");

            Queue<String> queue;
            while (!stack.isEmpty()) {
                while ((queue = graph.get(stack.peek())) != null && queue.size() > 0) {
                    stack.push(queue.poll());
                }
                result.add(stack.pop());
            }
        }
    }
}
