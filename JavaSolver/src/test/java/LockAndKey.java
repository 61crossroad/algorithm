import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// TODO
public class LockAndKey {

    @Test
    public void run() {
        int[][] key = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] lock =  {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
                /*
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
                */
        };

        if (solution(key, lock)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        // System.out.println("#### keyList ####");
        List<int[]> keyList = new ArrayList<int[]>();
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == 1) {
                    int[] point = new int[2];
                    point[0] = i;
                    point[1] = j;
                    keyList.add(point);
                    // System.out.println("(" + point[0] + ", " + point[1] + ")");
                }
            }
        }

        // System.out.println("#### lockList ####");
        List<int[]> lockList = new ArrayList<int[]>();
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                if (lock[i][j] == 0) {
                    int[] point = new int[2];
                    point[0] = i;
                    point[1] = j;
                    lockList.add(point);
                    // System.out.println("(" + point[0] + ", " + point[1] + ")");
                }
            }
        }

        int n = lockList.size();
        int m = keyList.size();
        int nm = lock.length;
        List<int[]> keyListOffset = new ArrayList<int[]>();
		/*
		System.out.println("n : " + n);
		System.out.println("m : " + m);
		System.out.println("nm : " + nm);
		*/

        for (int i = 0; i < m && answer == false; i++) {
            for (int j = 0; j < n && answer == false; j++) {
                int yOffset = lockList.get(j)[0] - keyList.get(i)[0];
                int xOffset = lockList.get(j)[1] - keyList.get(i)[1];

                // System.out.println("## Key Set with Offset ##");
                keyListOffset.clear();
                for (int k = 0; k < m; k++) {
                    int[] point = new int[2];
                    point[0] = keyList.get(k)[0] + yOffset;
                    point[1] = keyList.get(k)[1] + xOffset;
                    keyListOffset.add(point);
                    // System.out.print("[" + point[0] + ", " + point[1] + "] ");
                }
                // System.out.print("\n");
                // System.out.println("## Validate ##");
                for (int k = 0; k < 4 && answer == false; k++) {
                    for (int l = 0; l < m; l++) {
                        // System.out.print("[" + keyListOffset.get(l)[0] + ", " + keyListOffset.get(l)[1] + "] ");
                    }
                    // System.out.print("\n");

                    int count = n;
                    int positiveKeyCount = 0;

                    for (int l = 0; l < m; l++) {
                        int y = keyListOffset.get(l)[0];
                        int x = keyListOffset.get(l)[1];

                        if (0 <= y && y < nm && 0 <= x && x < nm) {
                            positiveKeyCount++;
                        }
                    }

                    for (int l = 0; l < n; l++) {
                        for (int p = 0; p < m; p++) {
							/*
							System.out.println("(" + lockList.get(l)[0] +
									", " + lockList.get(l)[1] + ") " +
									"(" + keyListOffset.get(p)[0] +
									", " + keyListOffset.get(p)[1] + ")");
							*/
                            if (lockList.get(l)[0] == keyListOffset.get(p)[0]
                                    && lockList.get(l)[1] == keyListOffset.get(p)[1]) {
                                count--;
                                positiveKeyCount--;
                                break;
                            }
                        }
                    }
                    // System.out.println("count : " + count + " key : " + positiveKeyCount);
                    if (count == 0 && positiveKeyCount == 0) {
                        answer = true;
                    }

                    for (int l = 0; l < m && answer == false; l++) {
                        if (l != i) {
                            int y = keyListOffset.get(l)[0];
                            int x = keyListOffset.get(l)[1];
                            keyListOffset.get(l)[0] = lockList.get(j)[0] -lockList.get(j)[1] + x;
                            keyListOffset.get(l)[1] = lockList.get(j)[0] + lockList.get(j)[1] - y;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
