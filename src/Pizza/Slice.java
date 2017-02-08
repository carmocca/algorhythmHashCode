package Pizza;

public class Slice {
  int rowx,colx,rowy,coly;
  int max;

  public Slice(int rx, int ry,int cx, int cy, int max) {
    this.rowx = rx;
    this.colx = cx;
    this.rowy = ry;
    this.coly = cy;
    this.max = max;
  }

  public int getRowx() {
    return rowx;
  }

  public void setRowx(int rowx) {
    this.rowx = rowx;
  }

  public int getColx() {
    return colx;
  }

  public void setColx(int colx) {
    this.colx = colx;
  }

  public int getRowy() {
    return rowy;
  }

  public void setRowy(int rowy) {
    this.rowy = rowy;
  }

  public int getColy() {
    return coly;
  }

  public void setColy(int coly) {
    this.coly = coly;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

}
