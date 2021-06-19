import org.junit.jupiter.api.Test;

public class NumberOfIslands {

    @Test
    public void run() {
        char[][] input = new char[][] {
                /*
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
                 */
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(input));
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    private void dfs(int y, int x, char[][] grid, boolean[][] visited) {
        if (y -1 >= 0 && grid[y - 1][x] == '1' && !visited[y - 1][x]) {
            visited[y - 1][x] = true;
            dfs(y - 1, x, grid, visited);
        }
        if (y + 1 < grid.length && grid[y + 1][x] == '1' && !visited[y + 1][x]) {
            visited[y + 1][x] = true;
            dfs(y + 1, x, grid, visited);
        }
        if (x -1 >= 0 && grid[y][x - 1] == '1' && !visited[y][x - 1]) {
            visited[y][x - 1] = true;
            dfs(y, x - 1, grid, visited);
        }
        if (x + 1 < grid[0].length && grid[y][x + 1] == '1' && !visited[y][x + 1]) {
            visited[y][x + 1] = true;
            dfs(y, x + 1, grid, visited);
        }
    }
}
