package week5.더맵게.twalla;

import java.util.*;

// ✏️ 프로그래머스 더 맵게

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/42626

// ⏱️ 풀이 시간
// 10분

// ✅ 풀이 근거
// 후보군 중 제일 작은 두 elem을 합치는 문제!
// 매 순간 정렬이 자동으로 유지되는 Priority Queue로 해결


public class Solution {
    public int solution(int[] scoville, int K) {

        int N = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        while (pq.size() >= 2) {
            int first = pq.poll();

            if (first >= K) {
                return answer;
            }

            int second = pq.poll();

            pq.add(first + second * 2);
            answer += 1;
        }

        if (pq.size() == 1 && pq.peek() >= K) {
            return answer;
        }

        return -1;
    }
}