import org.junit.jupiter.api.Test;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            List<Integer[]> path = graph.getOrDefault(flight[0], new ArrayList<>());
            path.add(new Integer[] {flight[1], flight[2]});
            graph.put(flight[0], path);
        }

        Map<Integer, Info> dist = new HashMap<>();
        dist.put(src, new Info(0, k));

        while (true) {
            Integer closest = Integer.MAX_VALUE;
            Integer here = null;
            Info hereInfo = null;

            for (Integer node : dist.keySet()) {
                Info candidate = dist.get(node);
                if (!candidate.visited && candidate.price < closest) {
                    closest = candidate.price;
                    here = node;
                    hereInfo = candidate;
                }
            }

            if (here == null) {
                break;
            }
            hereInfo.visited = true;

            if (hereInfo.remain >= 0) {
                List<Integer[]> adj = graph.get(here);
                if (adj != null) {
                    for (Integer[] path : adj) {
                        Info there = dist.get(path[0]);
                        if (there == null) {
                            there = new Info(Integer.MAX_VALUE, k);
                        }

                        if (!there.visited) {
                            Integer alt = hereInfo.price + path[1];

                            if (there.price > alt) {
                                there.price = alt;
                                if (here == src) {
                                    there.remain = hereInfo.remain;
                                } else {
                                    there.remain = hereInfo.remain - 1;
                                }
                                dist.put(path[0], there);
                            }
                        }
                    }
                }
            }
        }

        Info result = dist.get(dst);
        if (result == null || result.remain < -1) {
            return -1;
        } else {
            return result.price;
        }
        /*
        PriorityQueue<Via> q = new PriorityQueue<>();
        q.add(new Via(0, src, k));

        while (!q.isEmpty()) {
            Via current = q.poll();
            if (current.node.equals(dst)) {
                return current.price;
            }

            if (current.remain >= 0) {
                List<Integer[]> adj = graph.get(current.node);
                if (adj != null) {
                    adj.forEach(path -> {
                        Integer alt = current.price + path[1];
                        q.add(new Via(alt, path[0], current.remain - 1));
                    });
                }
            }
        }

        return -1;
         */
    }

    static class Info implements Comparable<Info> {
        Integer price, remain;
        boolean visited = false;

        public Info(Integer price, Integer remain) {
            this.price = price;
            this.remain = remain;
        }

        @Override
        public int compareTo(Info o) {
            return price - o.price;
        }
    }

    static class Via implements Comparable<Via> {
        Integer price, node, remain;

        public Via(Integer price, Integer node, Integer remain) {
            this.price = price;
            this.node = node;
            this.remain = remain;
        }

        @Override
        public int compareTo(Via o) {
            return price - o.price;
        }
    }

    @Test
    public void run() {
        /*
        int[][] flights = new int[][] {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(
                findCheapestPrice(3, flights, 0, 2, 1));
         */

        int[][] flights = new int[][] {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        System.out.println(
                findCheapestPrice(4, flights, 0, 3, 1));

        /*
        int[][] flights = new int[][] {
                {11,12,74}, {1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},{4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},{6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},{7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},{9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},{0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},{12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},{9,7,62},{5,3,67}
        };
        long startTime = System.currentTimeMillis();
        System.out.println(
                findCheapestPrice(13, flights, 10, 1, 10));
        System.out.println(System.currentTimeMillis() - startTime);
         */
    }
}
