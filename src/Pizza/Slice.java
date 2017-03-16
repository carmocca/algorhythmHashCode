package Pizza;

public class Slice {
  /*  rowX = row of point 1
      colX = column of point 1
      rowY = row of point 2
      colY = column of point 2
   */
  private int rowX, colX, rowY, colY;

  public Slice(int rx, int cx, int ry, int cy) {
    this.rowX = rx;
    this.colX = cx;
    this.rowY = ry;
    this.colY = cy;
  }

  public int getRowX() {
    return rowX;
  }

  public void setRowX(int rowX) {
    this.rowX = rowX;
  }

  public int getColX() {
    return colX;
  }

  public void setColX(int colX) {
    this.colX = colX;
  }

  public int getRowY() {
    return rowY;
  }

  public void setRowY(int rowY) {
    this.rowY = rowY;
  }

  public int getColY() {
    return colY;
  }

  public void setColY(int colY) {
    this.colY = colY;
  }

  @Override
  public String toString() {
    return getRowX() + " " +
            getColX() + " " +
            getRowY() + " " +
            getColY();
  }
}
