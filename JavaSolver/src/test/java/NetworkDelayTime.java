import org.junit.jupiter.api.Test;

import java.util.*;

/*
Dijkstra with Priority Queue, Java Ver.

06/20/2021 02:10	Accepted	29 ms	44.5 MB	java
06/20/2021 00:54	Accepted	572 ms	16.6 MB	python3
 */

public class NetworkDelayTime {

    @Test
    public void run() {
        int[][] times = new int[][] {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] row : times) {
            int u = row[0], v = row[1], w = row[2];
            Map<Integer, Integer> uMap = graph.getOrDefault(u, new HashMap<>());
            uMap.put(v, w);
            graph.put(u, uMap);
        }

        /* Map Stream
        graph.forEach((u, value) ->
                value.forEach((v, w) ->
                        System.out.println(u + " > " + v + ": " + w)));
         */

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(k, 0));

        Map<Integer, Integer> dist = new HashMap<>();

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            final int via = cur.node, d = cur.weight;

            if (dist.get(via) == null) {
                dist.put(via, d);
                Map<Integer, Integer> adj = graph.get(via);

                if (adj != null) {
                    adj.forEach((v, w) -> {
                        int alt = d + w;
                        q.add(new Pair(v, alt));
                    });

                    /* ALT.
                    for (Integer v : adj.keySet()) {
                        int alt = d + adj.get(v);
                        q.add(new Pair(v, alt));
                    }
                     */
                }
            }
        }

        if (dist.size() == n) {
            return dist.values().stream().max(Integer::compareTo).orElse(-1);
        }

        return -1;
    }

    static class Pair implements Comparable<Pair> {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }
}
