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

  public void generateSlice(int minIngredient, int maxCells, int startingRow, int startingCol) {

  }
}
