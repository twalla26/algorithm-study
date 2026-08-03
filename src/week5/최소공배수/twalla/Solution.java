package week5.최소공배수.twalla;

// ✏️ 프로그래머스 최소공배수

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/12953

// ⏱️ 풀이 시간
// 10분

// ✅ 풀이 근거
// 완전 탐색으로 풀었는데, 뭔가 더 효율적으로 풀 수 있는 방법이 있다면 알려주세요...!!!

public class Solution {
    public long solution(int[] arr) {

        int N = arr.length;

        long max = 1;
        for (int i = 0; i < N; i++) {
            max *= arr[i];
        }

        long answer = 1;
        while (answer <= max) {

            boolean result = true;
            for (int i = 0; i < N; i++) {
                if (answer % arr[i] != 0) {
                    result = false;
                    break;
                }
            }

            if (result) {
                return answer;
            }

            answer += 1;
        }

        return answer;
    }
}