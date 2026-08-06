package week5.정수삼각형.twalla;

// ✏️ 프로그래머스 정수 삼각형

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/43105

// ⏱️ 풀이 시간
// 20분

// ✅ 풀이 근거
// 그냥 인덱스 조정만 잘 해주면 쉽게 풀리는 문제

public class Solution {
    public int solution(int[][] triangle) {

        int N = triangle.length;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    triangle[i][0] += triangle[i - 1][0];
                } else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, triangle[N - 1][i]);
        }

        return answer;
    }
}
