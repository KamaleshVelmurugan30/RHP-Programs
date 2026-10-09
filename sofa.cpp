#include <bits/stdc++.h>
using namespace std;
int M, N;
vector<vector<char>> g;
bool freeCell(int r, int c) {
    return r >= 0 && r < M && c >= 0 && c < N && g[r][c] != 'H';
}
bool valid(int r, int c, int o) {
    if (!freeCell(r, c)) return false;
    return o == 0 ? freeCell(r, c + 1) : freeCell(r + 1, c);
}
int main() {
    cin >> M >> N;
    g.assign(M, vector<char>(N));
    vector<pair<int,int>> s, S;
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++) {
            cin >> g[i][j];
            if (g[i][j] == 's') s.push_back({i, j});
            else if (g[i][j] == 'S') S.push_back({i, j});
        }
    if (s.size() != 2 || S.size() != 2) { cout << "Impossible" << endl; return 0; }
    auto toState = [](vector<pair<int,int>>& v) {
        sort(v.begin(), v.end());
        int o = (v[0].first == v[1].first) ? 0 : 1;
        return array<int,3>{v[0].first, v[0].second, o};
    };
    auto start = toState(s);
    auto goal = toState(S);
    vector<vector<array<int,2>>> dist(M, vector<array<int,2>>(N, {-1, -1}));
    queue<array<int,3>> q;
    dist[start[0]][start[1]][start[2]] = 0;
    q.push(start);
    int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
    while (!q.empty()) {
        auto cur = q.front(); q.pop();
        int r = cur[0], c = cur[1], o = cur[2];
        int d = dist[r][c][o];
        if (cur == goal) { cout << d << endl; return 0; }
        auto tryPush = [&](int nr, int nc, int no) {
            if (nr < 0 || nc < 0 || nr >= M || nc >= N) return;
            if (!valid(nr, nc, no)) return;
            if (dist[nr][nc][no] != -1) return;
            dist[nr][nc][no] = d + 1;
            q.push({nr, nc, no});
        };
        for (int k = 0; k < 4; k++) tryPush(r + dr[k], c + dc[k], o);
        if (o == 0) {
            for (int br = r - 1; br <= r; br++) {
                int bc = c;
                if (br < 0 || br + 1 >= M || bc + 1 >= N) continue;
                if (freeCell(br, bc) && freeCell(br, bc + 1) &&
                    freeCell(br + 1, bc) && freeCell(br + 1, bc + 1)) {
                    tryPush(br, bc, 1);  
                    tryPush(br, bc + 1, 1); 
                }
            }
        } else {
            for (int bc = c - 1; bc <= c; bc++) {
                int br = r;
                if (bc < 0 || bc + 1 >= N || br + 1 >= M) continue;
                if (freeCell(br, bc) && freeCell(br, bc + 1) &&
                    freeCell(br + 1, bc) && freeCell(br + 1, bc + 1)) {
                    tryPush(br, bc, 0);      
                    tryPush(br + 1, bc, 0); 
                }
            }
        }
    }
    cout << "Impossible" << endl;
    return 0;
}
