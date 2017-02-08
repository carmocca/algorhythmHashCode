package Pizza;

import java.util.List;
import java.util.ArrayList;

public class Pizza {
	private char [][] pizza;
	private List<Slice> sliceList;

	public Pizza(int r, int c) {
		pizza = new char[r][c];
		sliceList = new ArrayList<Slice>();
	}

	public void setPizza(char[][] pizza) {
		this.pizza = pizza;
	}

	public char[][] getPizza() {
		return pizza;
	}

	public void setIngredient(int r, int c, char i) {
	    if (i == 'T' || i == 'M') {
	        pizza[r][c] = i;
        }
	}
	
	public char getIngredient(int r, int c) {
		return pizza[r][c];
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
}
