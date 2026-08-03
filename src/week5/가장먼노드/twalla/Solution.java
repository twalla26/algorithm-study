package week5.가장먼노드.twalla;

// ✏️ 프로그래머스 가장 먼 노드

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/49189

// ⏱️ 풀이 시간
// 10분

// ✅ 풀이 근거
// BFS로 풀되, 가장 먼 노드가 나올 때까지 계속 cnt와 curDist를 갱신해주면 된다!

import java.util.*;

public class Solution {

    int N;
    List<List<Integer>> graph;

    int bfs() {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        int cnt = 1;
        int curDist = -1;
        while (!q.isEmpty()) {

            Node cur = q.poll();

            if (curDist == cur.dist) {
                cnt += 1;
            } else {
                cnt = 1;
                curDist = cur.dist;
            }

            for (int next : graph.get(cur.index)) {
                if (visited[next]) {
                    continue;
                }

                q.add(new Node(next, cur.dist + 1));
                visited[next] = true;
            }
        }

        return cnt;
    }

    public int solution(int n, int[][] edge) {

        N = n;
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int result = bfs();

        return result;
    }
}

class Node {
    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

