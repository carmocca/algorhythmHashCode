package Pizza;

import java.lang.*;
import static org.junit.Assert.assertEquals;

/*    BASED ON http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 */
class Subarray
{
  private static Pizza pizza;

  public static void main (String[] args) throws java.lang.Exception
  {
    pizza = new Pizza(4, 5);
    System.out.println("TESTS FOR row and col generation");
    assertEquals("MaxSum: 20, range: [(0, 0)(3, 4)]", generateSlice(0, 0));
    assertEquals("MaxSum: 15, range: [(1, 0)(3, 4)]", generateSlice(1, 0));
    assertEquals("MaxSum: 16, range: [(0, 1)(3, 4)]", generateSlice(0, 1));
    assertEquals("MaxSum: 12, range: [(1, 1)(3, 4)]", generateSlice(1, 1));
    assertEquals("MaxSum: 10, range: [(2, 0)(3, 4)]", generateSlice(2, 0));
    assertEquals("MaxSum: 12, range: [(0, 2)(3, 4)]", generateSlice(0, 2));
    assertEquals("MaxSum: 2, range: [(3, 3)(3, 4)]",  generateSlice(3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]",  generateSlice(3, 4));
    System.out.println("\nTESTS FOR maxCell");
    int maxSize = 25;
    assertEquals("MaxSum: 20, range: [(0, 0)(3, 4)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 15, range: [(1, 0)(3, 4)]", generateSlice(maxSize, 1, 0));
    assertEquals("MaxSum: 16, range: [(0, 1)(3, 4)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 12, range: [(1, 1)(3, 4)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 10, range: [(2, 0)(3, 4)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 12, range: [(0, 2)(3, 4)]", generateSlice(maxSize, 0, 2));
    assertEquals("MaxSum: 2, range: [(3, 3)(3, 4)]",  generateSlice(maxSize, 3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]",  generateSlice(maxSize, 3, 4));
    maxSize = 3;
    System.out.println("");
    assertEquals("MaxSum: 3, range: [(0, 0)(2, 0)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 3, range: [(1, 0)(3, 0)]", generateSlice(maxSize, 1, 0));
    assertEquals("MaxSum: 3, range: [(0, 1)(2, 1)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 3, range: [(1, 1)(3, 1)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 3, range: [(2, 0)(2, 2)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 3, range: [(0, 2)(2, 2)]", generateSlice(maxSize, 0, 2));
    maxSize = 4;
    System.out.println("");
    assertEquals("MaxSum: 4, range: [(0, 0)(3, 0)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 4, range: [(1, 0)(2, 1)]", generateSlice(maxSize, 1, 0));  // TODO, NOT WORKING
    assertEquals("MaxSum: 4, range: [(0, 1)(3, 1)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 4, range: [(1, 1)(2, 2)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 4, range: [(2, 0)(3, 1)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 4, range: [(0, 2)(3, 2)]", generateSlice(maxSize, 0, 2));
    maxSize = 1;
    System.out.println("");
    assertEquals("MaxSum: 1, range: [(0, 0)(0, 0)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 1, range: [(1, 0)(1, 0)]", generateSlice(maxSize, 1, 0));
    assertEquals("MaxSum: 1, range: [(0, 1)(0, 1)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 1, range: [(1, 1)(1, 1)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 1, range: [(2, 0)(2, 0)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 1, range: [(0, 2)(0, 2)]", generateSlice(maxSize, 0, 2));
    assertEquals("MaxSum: 1, range: [(3, 3)(3, 3)]", generateSlice(maxSize, 3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]", generateSlice(maxSize, 3, 4));
  }

  public static int[] kadaneForDownRight(int[] a, int row, int col) {
    //result[0] == maxSum, result[1] == end;
    int[] result = new int[]{0, -1};
    int currentSum = 0;

    for (int i = 0; i < a.length; i++) {
      currentSum += a[i];
      if (currentSum > result[0]) {
        result[0] = currentSum;
        if (row == 0 && col != 0) {
          result[1] = i;
        } else if (row != 0 && col == 0) {
          result[1] = i + row;
        } else {
          result[1] = i + col;
        }
      }
    }
    return result;
  }

  public static int[] kadaneForRightDown(int[] a, int row, int col) {
    //result[0] == maxSum, result[1] == end;
    int[] result = new int[]{0, -1};
    int currentSum = 0;

    for (int i = 0; i < a.length; i++) {
      currentSum += a[i];
      if (currentSum > result[0]) {
        result[0] = currentSum;
        if (row != 0 && col == 0) {
          result[1] = i;
        } else if (row == 0 && col != 0) {
          result[1] = i + row;
        } else {
          result[1] = i + col;
        }
      }
    }
    return result;
  }

  /**
   * VERSION WITHOUT minIngredient IMPLEMENTED
   * maxSum, (rowX, colX),(rowY, colY)
   * minIngredient = minimum number of ingredients per slice
   * maxCells = maximum number of cells in a slice
   * startingRow = starting row (0-based)
   * startingCol = starting column (0-based)
   */
  public static String generateSlice(int maxCells, int startingRow, int startingCol) {
    int cols = pizza.getCellMatrix()[0].length;
    int rows = pizza.getCellMatrix().length;
    int maxSum = 0;
    int rowX = startingRow;
    int colX = startingCol;
    int rowY = startingRow;
    int colY = startingCol;

    if ((startingRow == rows - 1 && startingCol == cols - 1) || // In case the subarray is equal to the array
        (maxCells == 1)){                       // In case that only one cell is allowed per slice
      System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", 1, rowX, colX, rowY, colY);
      return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", 1, rowX, colX, rowY, colY);
    }
    // Search first down, and then to the right
    int kadaneArrSize = (maxCells < rows - startingRow) ? maxCells : rows - startingRow;
    int[] kadaneArr = new int[kadaneArrSize];
    for (int col = startingCol; col < cols; col++) {
      for (int i = 0; i < kadaneArrSize; i++) { // TODO, is this necessary? Maybe for checks when we do minIngredients
        kadaneArr[i] += 1;
      }
      int[] currentResult = kadaneForDownRight(kadaneArr, startingRow, startingCol);
      if (currentResult[0] > maxSum && currentResult[0] <= maxCells) {
        maxSum = currentResult[0];
        rowY = currentResult[1];
        colY = col;
      }
      if (kadaneArrSize == maxCells) {
        break;
      }
    }
    // If there is a possible better value
    if (maxSum < maxCells) {  // TODO, think about the case where maxCells is bigger than the best possible maxSum, we might not need to recalculate
      // Searches first right and then down
      kadaneArrSize = (maxCells < cols - startingCol) ? maxCells : cols - startingCol;
      kadaneArr = new int[kadaneArrSize];
      for (int row = startingRow; row < rows - 1; row++) {
        for (int i = 0; i < kadaneArrSize; i++) {
          kadaneArr[i] += 1;
        }
        int[] currentResult = kadaneForRightDown(kadaneArr, startingRow, startingCol);
        if (currentResult[0] > maxSum && currentResult[0] <= maxCells) {
          maxSum = currentResult[0];
          rowY = startingRow;
          colY = currentResult[1];
        }
        if (kadaneArrSize == maxCells) {
          break;
        }
      }
    }
    System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", maxSum, rowX, colX, rowY, colY);
    return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", maxSum, rowX, colX, rowY, colY);
  }

  /**
   * VERSION WITHOUT maxCells NOR minIngredient IMPLEMENTED
   * maxSum, (rowX, colX),(rowY, colY)
   * minIngredient = minimum number of ingredients per slice
   * maxCells = maximum number of cells in a slice
   * startingRow = starting row (0-based)
   * startingCol = starting column (0-based)
   */
  public static String generateSlice(int startingRow, int startingCol) {
    Cell [][] matrix = pizza.getCellMatrix();
    int cols = matrix[0].length;
    int rows = matrix.length;
    int[] currentResult;
    int maxSum = Integer.MIN_VALUE;
    int rowX = startingRow;
    int colX = startingCol;
    int rowY = startingRow;
    int colY = startingCol;

    if (startingRow == rows - 1 && startingCol == cols - 1) {
      System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", 1, rowX, colX, rowY, colY);
      return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", 1, rowX, colX, rowY, colY);
    }

    int[] kadaneArr = new int[rows - startingRow];
    for (int col = startingCol; col < cols; col++) {
      for (int i = 0; i < rows - startingRow; i++) {
        kadaneArr[i] += 1;
      }
      currentResult = kadaneForDownRight(kadaneArr, startingRow, startingCol);
      if (currentResult[0] > maxSum) {
        maxSum = currentResult[0];
        rowY = currentResult[1];
        colY = col;
      }
    }

    System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", maxSum, rowX, colX, rowY, colY);
    return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", maxSum, rowX, colX, rowY, colY);
  }
}