package Pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
     BASE FOR THE PIZZASOLVER ALGORITHM
 */
class Subarray {
  private static Pizza pizza;

  public static void main(String[] args) throws java.lang.Exception {
    pizza = new Pizza(4, 5);
    System.out.println("TESTS FOR row and col generation");
    assertEquals("MaxSum: 20, range: [(0, 0)(3, 4)]", generateSlice(0, 0));
    assertEquals("MaxSum: 15, range: [(1, 0)(3, 4)]", generateSlice(1, 0));
    assertEquals("MaxSum: 16, range: [(0, 1)(3, 4)]", generateSlice(0, 1));
    assertEquals("MaxSum: 12, range: [(1, 1)(3, 4)]", generateSlice(1, 1));
    assertEquals("MaxSum: 10, range: [(2, 0)(3, 4)]", generateSlice(2, 0));
    assertEquals("MaxSum: 12, range: [(0, 2)(3, 4)]", generateSlice(0, 2));
    assertEquals("MaxSum: 2, range: [(3, 3)(3, 4)]", generateSlice(3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]", generateSlice(3, 4));

    int maxSize = 1;
    System.out.println("TESTS FOR maxCells");
    assertEquals("MaxSum: 1, range: [(0, 0)(0, 0)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 1, range: [(1, 0)(1, 0)]", generateSlice(maxSize, 1, 0));
    assertEquals("MaxSum: 1, range: [(0, 1)(0, 1)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 1, range: [(1, 1)(1, 1)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 1, range: [(2, 0)(2, 0)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 1, range: [(0, 2)(0, 2)]", generateSlice(maxSize, 0, 2));
    assertEquals("MaxSum: 1, range: [(3, 3)(3, 3)]", generateSlice(maxSize, 3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]", generateSlice(maxSize, 3, 4));

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
    assertEquals("MaxSum: 3, range: [(3, 2)(3, 4)]", generateSlice(maxSize, 3, 2));
    assertTrue(generateSlice(maxSize, 1, 0).equals("MaxSum: 4, range: [(1, 0)(2, 1)]") ||
        generateSlice(maxSize, 1, 0).equals("MaxSum: 4, range: [(1, 0)(1, 3)]"));
    assertEquals("MaxSum: 4, range: [(0, 1)(3, 1)]", generateSlice(maxSize, 0, 1));
    assertTrue(generateSlice(maxSize, 1, 1).equals("MaxSum: 4, range: [(1, 1)(1, 4)]") ||
        generateSlice(maxSize, 1, 1).equals("MaxSum: 4, range: [(1, 1)(2, 2)]"));
    assertEquals("MaxSum: 4, range: [(2, 0)(3, 1)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 4, range: [(0, 2)(3, 2)]", generateSlice(maxSize, 0, 2));
    assertEquals("MaxSum: 4, range: [(2, 2)(3, 3)]", generateSlice(maxSize, 2, 2));
    assertEquals("MaxSum: 4, range: [(2, 3)(3, 4)]", generateSlice(maxSize, 2, 3));
    assertEquals("MaxSum: 4, range: [(1, 3)(2, 4)]", generateSlice(maxSize, 1, 3));

    maxSize = 5;
    System.out.println("");
    assertEquals("MaxSum: 3, range: [(1, 2)(1, 4)]", generateSlice(maxSize, 1, 2));
    assertTrue(generateSlice(maxSize, 1, 2).equals("MaxSum: 3, range: [(1, 2)(1, 4)]") ||
        generateSlice(maxSize, 1, 2).equals("MaxSum: 3, range: [(1, 2)(3, 2)]"));

    maxSize = 6;
    System.out.println("");
    assertEquals("MaxSum: 6, range: [(1, 3)(3, 4)]", generateSlice(maxSize, 1, 3));

    maxSize = 25;
    System.out.println("");
    assertEquals("MaxSum: 20, range: [(0, 0)(3, 4)]", generateSlice(maxSize, 0, 0));
    assertEquals("MaxSum: 15, range: [(1, 0)(3, 4)]", generateSlice(maxSize, 1, 0));
    assertEquals("MaxSum: 16, range: [(0, 1)(3, 4)]", generateSlice(maxSize, 0, 1));
    assertEquals("MaxSum: 12, range: [(1, 1)(3, 4)]", generateSlice(maxSize, 1, 1));
    assertEquals("MaxSum: 10, range: [(2, 0)(3, 4)]", generateSlice(maxSize, 2, 0));
    assertEquals("MaxSum: 12, range: [(0, 2)(3, 4)]", generateSlice(maxSize, 0, 2));
    assertEquals("MaxSum: 2, range: [(3, 3)(3, 4)]", generateSlice(maxSize, 3, 3));
    assertEquals("MaxSum: 1, range: [(3, 4)(3, 4)]", generateSlice(maxSize, 3, 4));
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
    Cell[][] matrix = pizza.getCellMatrix();
    int cols = matrix[0].length;
    int rows = matrix.length;
    int maxSum = 0;
    int rowY = -1, colY = -1;
    int columnSize = (maxCells < rows - startingRow) ? maxCells : rows - startingRow;
    int rowSize = (maxCells < cols - startingCol) ? maxCells : cols - startingCol;

    for (int col = startingCol; col < cols; col++) {
      if (maxSum + columnSize > maxCells) {
        break;
      }
      maxSum += columnSize;
      colY = col;
      if (maxSum >= columnSize && columnSize == maxCells) {
        break;
      }
    }

    if (maxSum != 0) {
      if (columnSize == maxCells) {
        rowY = startingRow + columnSize - 1;
      } else {
        rowY = rows - 1;
      }
    }

    if (maxSum < maxCells) { // TODO, think about the case where maxCells is bigger than the best possible maxSum, we might not need to recalculate
      maxSum = 0;
      for (int row = startingRow; row < rows; row++) {
        if (maxSum + rowSize > maxCells) {
          break;
        }
        maxSum += rowSize;
        rowY = row;
        if (maxSum >= rowSize && rowSize == maxCells) {
          break;
        }
      }

      if (maxSum != 0) {
        if (rowSize == maxCells) {
          colY = startingCol + rowSize - 1;
        } else {
          colY = cols - 1;
        }
      }
    }

    System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", maxSum, startingRow, startingCol, rowY, colY);
    return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", maxSum, startingRow, startingCol, rowY, colY);
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
    Cell[][] matrix = pizza.getCellMatrix();
    int cols = matrix[0].length;
    int rows = matrix.length;
    int maxSum = 0;
    int rowY = startingRow;
    int colY = startingCol;

    for (int col = startingCol; col < cols; col++) {
      maxSum += rows - startingRow;
      colY = col;
    }

    if (maxSum != 0) {
      rowY = rows - 1;
    }

    System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", maxSum, startingRow, startingCol, rowY, colY);
    return String.format("MaxSum: %d, range: [(%d, %d)(%d, %d)]", maxSum, startingRow, startingCol, rowY, colY);
  }
}