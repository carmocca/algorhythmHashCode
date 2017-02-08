package Pizza;

public class Slice {
  int rowx,colx,rowy,coly;
  int max;
  Pizza pizza;

  public Slice(int rx, int ry,int cx, int cy, int max, Pizza pizza) {
    this.rowx = rx;
    this.colx = cx;
    this.rowy = ry;
    this.coly = cy;
    this.max = max;
    this.pizza = pizza;
  }


}
