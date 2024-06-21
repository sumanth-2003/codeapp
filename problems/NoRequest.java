// We have N servers.
// Input integers N, NOL(number of logs)
// Input a 2D 0-indexed integer array logs of length NOL, where logs[i] =
// [server_id, TIME] denotes that the server with id server_id received a
// request at time TIME.

// Also input integers X, NOQ and a 0-indexed integer array 'queries' of length
// NOQ.

// Return a 0-indexed integer array 'arr' of length NOQ.

// arr[i] represents the number of servers that did not receive any requests
// during the time interval (queries[i] - x, queries[i]).

// Note: the time intervals are inclusive.

// Sample Test Cases
// case=1
// input =3 //N
// 3 //NOL
// 1 3 //Logs
// 2 6
// 1 5
// 5 //X
// 2 //NOQ
// 10 11 //Querries
// output=1 2
// Explanation:
// For queries[0]: The servers with ids 1 and 2 get requests in the duration of
// [5, 10]. Hence, only server 3 gets zero requests.
// For queries[1]: Only the server with id 2 gets a request in duration of
// [6,11]. Hence, the servers with ids 1 and 3 are the only servers that do not
// receive any requests during that time period.

// case=2
// input=3 //N
// 4 //NOL
// 2 4 //Logs
// 2 1
// 1 2
// 3 1
// 2 //X
// 2 //NOQ
// 3 4 //Querries
// output= 0 1
// Explanation:
// For queries[0]: All servers get at least one request in the duration of [1,
// 3].
// For queries[1]: Only server with id 3 gets no request in the duration [2,4].

// Constraints:
// 1 <= N <= 105
// 1 <= NOL <= 105
// 1 <= NOQ <= 105
// logs[i].length == 2
// 1 <= logs[i][0] <= N
// 1 <= logs[i][1] <= 106
// 1 <= x <= 105
// x < queries[i] <= 106

import java.util.*;

public class NoRequest {
    public static void main(String[] args) {
        int N = 3;
        int NOL = 3;
        int[][] logs = { { 1, 3 }, { 2, 6 }, { 1, 5 } };
        int X = 5;
        int NOQ = 2;
        int[] queries = { 10, 11 };

        System.out.println(Arrays.toString(countQuietServers(N, logs, X, queries)));
    }

    public static int[] countQuietServers(int N, int[][] logs, int X, int[] queries) {
        List<List<Integer>> serverLogs = new ArrayList<>(N);
        for (int i = 0; i <= N; i++) {
            serverLogs.add(new ArrayList<>());
        }

        // Storing the logs for each server
        for (int[] log : logs) {
            int serverId = log[0];
            int time = log[1];
            serverLogs.get(serverId).add(time);
        }

        // Sorting the logs for each server
        for (int i = 1; i <= N; i++) {
            Collections.sort(serverLogs.get(i));
        }

        int NOQ = queries.length;
        int[] result = new int[NOQ];

        // Answering each query
        for (int q = 0; q < NOQ; q++) {
            int query = queries[q];
            int from = query - X;
            int countQuietServers = 0;

            // Check each server if it has no logs in the interval (from, query]
            for (int i = 1; i <= N; i++) {
                List<Integer> logsList = serverLogs.get(i);

                // We want to see if there is any log in the interval (from, query]
                if (logsList.isEmpty() ||
                        (getFirstGreaterOrEqual(logsList, from + 1) > query)) {
                    countQuietServers++;
                }
            }
            result[q] = countQuietServers;
        }

        return result;
    }

    // Helper function to find the smallest element in list which is greater or
    // equal to 'value'
    private static int getFirstGreaterOrEqual(List<Integer> list, int value) {
        int low = 0, high = list.size() - 1;
        if (high == -1 || list.get(high) < value) {
            return Integer.MAX_VALUE; // No element is greater or equal to 'value'
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return list.get(low);
    }
}
