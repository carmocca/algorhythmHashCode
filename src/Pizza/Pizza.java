package Pizza;

public class Pizza {
	private char [][] pizza;

	public Pizza(int r, int c) {
		pizza = new char[r][c];
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
