package Pizza;

public class Slice {
  private int rowx,colx,rowy,coly;

  public Slice(int rx, int ry,int cx, int cy) {
    this.rowx = rx;
    this.colx = cx;
    this.rowy = ry;
    this.coly = cy;
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

  @Override
  public String toString() {
    String s = getRowx() + " " +
               getRowy() + " " +
               getColx() + " " +
               getColy();
    return s;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Slice slice = (Slice) o;

    if (getRowx() != slice.getRowx()) return false;
    if (getColx() != slice.getColx()) return false;
    if (getRowy() != slice.getRowy()) return false;
    return getColy() == slice.getColy();
  }

  @Override
  public int hashCode() {
    int result = getRowx();
    result = 31 * result + getColx();
    result = 31 * result + getRowy();
    result = 31 * result + getColy();
    return result;
  }
}
