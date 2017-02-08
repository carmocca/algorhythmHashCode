package Pizza;

import java.util.List;

public class PizzaSolver {

  private Pizza pizza;

  public PizzaSolver(Pizza pizza) {
    this.pizza = pizza;
  }

  public void generateSlices() {
    for (int i = 0; i < pizza.getPizza().length; i++) {
      for (int j = 0; j < pizza.getPizza()[0].length; j++) {
        if (belongsToSlice(pizza.getPizza()[i][j]))
          continue;
        generateSlice(pizza.getPizza()[i][j]);
      }
    }
  }
}
