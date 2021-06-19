import collections
import heapq
from typing import List


class Solution:
    def network_delay_time(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list)  # dict -> list -> tuple
        for u, v, w in times:
            graph[u].append((v, w))

        # put starting node K into heap
        q = [(0, k)]  # heap q means visited nodes

        # memorize shortest distances, initialize with None
        dist = collections.defaultdict(int)

        while q:
            # select most shortest node for current phase
            time, node = heapq.heappop(q)
            if node not in dist:
                dist[node] = time
                # evaluate every node via heappop(node)
                for v, w in graph[node]:  # list[node] -> tuple
                    # print(node, v, w)  # s -> node -(w)-> v
                    alt = time + w
                    heapq.heappush(q, (alt, v))

        if len(dist) == n:
            return max(dist.values())

        return -1


if __name__ == '__main__':
    graph = [[2, 1, 1], [2, 3, 1], [3, 4, 1]]
    N = 4
    K = 2
    print(Solution().network_delay_time(graph, N, K))
