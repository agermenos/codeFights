package com.sleepsoft.challenges.leetcode;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
class Islands {
    private void deactivate(char[][]grid, int x, int y){
        grid[y][x]='0';
        if (x<grid[0].length-1 && grid[y][x+1]=='1') deactivate(grid, x+1, y);
        if (x>0 && grid[y][x-1]=='1') deactivate(grid, x-1, y);
        if (y<grid.length-1 && grid[y+1][x]=='1') deactivate(grid, x, y+1);
        if (y>0 && grid[y-1][x]=='1') deactivate(grid, x, y-1);
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int y = 0;y<grid.length;y++) {
            for (int x=0;x<grid[0].length;x++){
                if (grid[y][x]=='1') {
                    islandCount++;
                    deactivate(grid, x, y);
                }
            }
        }
        return islandCount;
    }
}
