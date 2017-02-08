package Pizza;

public class Cell {
  char ingredient;
  Slice slice;

  public Cell(char ingredient, Slice slice) {
    this.ingredient = ingredient;
    this.slice = slice;
  }

  public Cell() {
  }

  public char getIngredient() {
    return ingredient;
  }

  public void setIngredient(char ingredient) {
    this.ingredient = ingredient;
  }

  public Slice getSlice() {
    return slice;
  }

  public void setSlice(Slice slice) {
    this.slice = slice;
  }

  @Override
  public String toString() {
    return "[" + ingredient + ", " + slice + "]";
  }
}
