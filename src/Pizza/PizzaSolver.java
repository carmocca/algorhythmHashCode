package Pizza;

import java.util.List;

public class PizzaSolver {

  private Pizza pizza;

  public PizzaSolver(Pizza pizza) {
    this.pizza = pizza;
  }

  public void generateSlices(int min, int max) {
    for (int i = 0; i < pizza.getCellMatrix().length; i++) {
      for (int j = 0; j < pizza.getCellMatrix()[0].length; j++) {
        if (pizza.hasSliceIn(i,j))
          continue;
        generateSlice(pizza.getCellMatrix()[i][j], min, max);
      }
    }
  }
}
