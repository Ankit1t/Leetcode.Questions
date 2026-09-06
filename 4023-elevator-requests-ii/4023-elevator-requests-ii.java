import java.util.*;

class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        int m = requests.length;

        int[] a = new int[m + 1];

        for (int i = 0; i < m; i++) {
            a[i] = requests[i];
        }

        a[m] = start;

        Arrays.sort(a);

        int len = 0;
        for (int x : a) {
            if (len == 0 || a[len - 1] != x) {
                a[len++] = x;
            }
        }

        int s = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == start) {
                s = i;
                break;
            }
        }

        boolean[] request = new boolean[len];

        for (int r : requests) {
            for (int i = 0; i < len; i++) {
                if (a[i] == r) {
                    request[i] = true;
                    break;
                }
            }
        }

        int[] prefix = new int[len + 1];

        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + (request[i] ? 1 : 0);
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] left = new long[len][len];
        long[][] right = new long[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(left[i], INF);
            Arrays.fill(right[i], INF);
        }

        left[s][s] = 0;
        right[s][s] = 0;

        for (int size = 1; size <= len; size++) {

            for (int l = 0; l + size - 1 < len; l++) {

                int r = l + size - 1;

                int fulfilled = prefix[r + 1] - prefix[l];
                int remaining = m - fulfilled;

                // Go left
                if (l > 0) {

                    long dist = a[l] - a[l - 1];

                    left[l - 1][r] = Math.min(
                        left[l - 1][r],
                        left[l][r] + dist * remaining
                    );

                    dist = a[r] - a[l - 1];

                    left[l - 1][r] = Math.min(
                        left[l - 1][r],
                        right[l][r] + dist * remaining
                    );
                }

                // Go right
                if (r + 1 < len) {

                    long dist = a[r + 1] - a[r];

                    right[l][r + 1] = Math.min(
                        right[l][r + 1],
                        right[l][r] + dist * remaining
                    );

                    dist = a[r + 1] - a[l];

                    right[l][r + 1] = Math.min(
                        right[l][r + 1],
                        left[l][r] + dist * remaining
                    );
                }
            }
        }

        return Math.min(left[0][len - 1], right[0][len - 1]);
    }
}