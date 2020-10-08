/** Minesweeper */
public class Minesweeper {
  public static void main(String[] args) {
    // read commandline arguments
    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);
    if (k > m * n) throw new RuntimeException("k cannot be bigger than m*n");

    int[][] grid = new int[m + 2][n + 2];
    boolean[][] mines = new boolean[m + 2][n + 2];

    // placing k mines uniformly among the mn cells
    while (k > 0) {
      int i = 1 + (int) (Math.random() * m);
      int j = 1 + (int) (Math.random() * n);
      if (!mines[i][j]) {
        mines[i][j] = true;
        k--;
      }
    }

    // count the number of neighboring mines
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        int mineCount = 0;
        if (!mines[i][j]) {
          if (mines[i + 1][j]) mineCount++;
          if (mines[i - 1][j]) mineCount++;
          if (mines[i][j + 1]) mineCount++;
          if (mines[i][j - 1]) mineCount++;
          if (mines[i + 1][j + 1]) mineCount++;
          if (mines[i - 1][j - 1]) mineCount++;
          if (mines[i - 1][j + 1]) mineCount++;
          if (mines[i + 1][j - 1]) mineCount++;
          // put numbers into grid
          if (mineCount == 0) grid[i][j] = -1;
          else grid[i][j] = mineCount;
        }
      }
    }

    // print the results
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (grid[i][j] != 0 && grid[i][j] != -1) System.out.print(grid[i][j] + "  ");
        else if (grid[i][j] == -1) System.out.print("0  ");
        else System.out.print("*  ");
      }
      System.out.println();
    }
  }
}
