#include <string>
#include <vector>
#include <deque>
#include <iomanip>
#include <algorithm>

using namespace std;

// 분 단위 -> "HH:MM" 변환
string to_time_str(int minutes) {
    stringstream ss;
    ss << setw(2) << setfill('0') << minutes / 60 << ":"
        << setw(2) << setfill('0') << minutes % 60;
    
    return ss.str();
}

// "HH:MM" -> 분 단위 변환
int to_minutes(string time) {
    return stoi(time.substr(0, 2)) * 60 + stoi(time.substr(3, 2));
}

string solution(int n, int t, int m, vector<string> timetable) {
    
    vector<int> crew_times;
    for (string time : timetable) {
        crew_times.push_back(to_minutes(time));
    }
    
    sort(crew_times.begin(), crew_times.end());
    
    deque<int> crews(crew_times.begin(), crew_times.end());
    
    int shuttle_time = 9 * 60; // 09:00 시작
    int last_crew_time = 0;
    int onboard_count = 0;
    
    for (int i = 0; i < n; i++) {
        onboard_count = 0;
        
        // 이번 셔틀에 탈 수 있는 인원
        while (!crews.empty()) {
            
            if (crews.front() > shuttle_time || onboard_count == m) {
                break;
            }
            
            last_crew_time = crews.front();
            crews.pop_front();
            onboard_count += 1; 
        }
        
        // 마지막 셔틀이 아니라면 다음 셔틀 시간으로 갱신
        if (i < n - 1) {
            shuttle_time += t;
        }
    }
    
    int answer_min = 0;
    
    // 마지막 셔틀
    if (onboard_count == m) { // 만석이면 마지막 승객보다 1분 먼저
        answer_min = last_crew_time - 1;
    } else { // 만석이 아니면 셔틀 정각에 탑승
        answer_min = shuttle_time;
    }
    
    string answer = to_time_str(answer_min);
    
    return answer;
}