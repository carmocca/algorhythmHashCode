package Pizza;

public class PizzaSolver {

  private Pizza pizza;

  public PizzaSolver(Pizza pizza) {
    this.pizza = pizza;
  }

  public void generateSlices(int min, int max) {
    for (int i = 0; i < pizza.getCellMatrix().length; i++) {
      for (int j = 0; j < pizza.getCellMatrix()[0].length; j++) {
        if (pizza.belongsToSlice(i,j)) {
          continue;
        } else {
          generateSlice(min, max, i, j);
        }
      }
    }
  }

  /**
   * maxSum, (rowX, colX),(rowY, colY)
   * minIngredient = minimum number of ingredients per slice
   * maxCells = maximum number of cells in a slice
   * startingRow = starting row (0-based)
   * startingCol = starting column (0-based)
   */
  public void generateSlice(int minIngredient, int maxCells, int startingRow, int startingCol) {
    Cell [][] matrix = pizza.getCellMatrix();
    int cols = matrix[0].length;
    int rows = matrix.length;
    int maxSum = 0;
    int rowY = -1, colY = -1;
    int columnSize = (maxCells < rows - startingRow) ? maxCells : rows - startingRow;
    int rowSize = (maxCells < cols - startingCol) ? maxCells : cols - startingCol;
    int mushrooms = 0, tomatoes = 0;

    for (int col = startingCol; col < cols; col++) {
      if (maxSum + columnSize > maxCells) { break; }
      for (int row = startingRow; row < columnSize + startingRow; row ++) {
        if (pizza.getIngredient(row, col) == 'M') {
          mushrooms++;
        } else {
          tomatoes++;
        }
      }
      maxSum += columnSize;
      colY = col;
      if (maxSum >= columnSize && columnSize == maxCells) {
        break;
      }
    }

    boolean aux = false;
    if (mushrooms < minIngredient || tomatoes < minIngredient) {
      aux = true;
    } else {
      if (maxSum != 0) {
        if (columnSize == maxCells) {
          rowY = startingRow + columnSize - 1;
        } else {
          rowY = rows - 1;
        }
      }
    }

    if (maxSum < maxCells || aux) { // TODO, think about the case where maxCells is bigger than the best possible maxSum, we might not need to recalculate
      maxSum = 0;
      mushrooms = 0;
      tomatoes = 0;
      for (int row = startingRow; row < rows; row++) {
        for (int col = startingCol; col < rowSize + startingCol; col++) {
          if (pizza.getIngredient(row, col) == 'M') {
            mushrooms++;
          } else {
            tomatoes++;
          }
        }
        if (maxSum + rowSize > maxCells) { break; }
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

    if (mushrooms < minIngredient || tomatoes < minIngredient) {
      return;
    }

    Slice slice = new Slice (startingRow, rowY, startingCol, colY);
    pizza.addSlice(slice);
    for (int row = startingRow; row <= rowY; row++) {
      for (int col = startingCol; col <= colY; col++) {
        pizza.setCellSlice(row, col, slice);
      }
    }
    // System.out.printf("MaxSum: %d, range: [(%d, %d)(%d, %d)]\n", maxSum, startingRow, startingCol, rowY, colY);
  }
}
