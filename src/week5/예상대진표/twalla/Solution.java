package week5.예상대진표.twalla;

// ✏️ 프로그래머스 예상 대진표

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/12985

// ⏱️ 풀이 시간
// 5분

// ✅ 풀이 근거
// 코테에 이런 문제 나왔으면 좋겠음.
// 근데 나만 풀고 다 틀렸으면 좋겠음.

public class Solution {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer += 1;
        }

        return answer;
    }
}
