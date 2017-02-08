package Pizza;

import java.util.List;
import java.util.ArrayList;

public class Pizza {
	private Cell [][] pizza;
	private List<Slice> sliceList;

	public Pizza(int r, int c) {
		pizza = new Cell[r][c];
		for(int i= 0; i<r;i++){
			for(int j = 0;j<c;j++){
				pizza[i][j]= new Cell();
			}
		}
		sliceList = new ArrayList<Slice>();
	}

	public void setPizza(Cell[][] pizza) {
		this.pizza = pizza;
	}

	public Cell[][] getCellMatrix() {
		return pizza;
	}

	public void setIngredient(int r, int c, char i) {
	  if (i == 'T' || i == 'M') {
	    pizza[r][c].setIngredient(i);
    }
	}

	public void setSlice(int r, int c, Slice s){
		pizza[r][c].setSlice(s);
	}
	
	public char getIngredient(int r, int c) {
		return pizza[r][c].getIngredient();
	}

	public void addSlice(Slice s) {
	  sliceList.add(s);
  }

  public void removeSlice(Slice s) {
	  sliceList.remove(s);
  }

	public List<Slice> getSlices() {
	  return sliceList;
  }

  @Override
	public String toString() {
		String str = "";
		for (int i = 0; i < pizza.length; i++) {
			for (int j = 0; j < pizza[0].length; j++) {
				str += pizza[i][j];
			}
			str += '\n';
		}
		return str;
	}

	public boolean hasSliceIn(int r, int c){
		return pizza[r][c].getSlice() ==  null;
	}
}
