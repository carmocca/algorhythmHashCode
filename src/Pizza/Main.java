package Pizza;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("resources/Pizza/example.in"));
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(0);
        }
		
		Pizza pizza;
		final int R, C, L, H;
		
		R = sc.nextInt();
		C = sc.nextInt();
		L = sc.nextInt();
		H = sc.nextInt();
		pizza = new Pizza(R, C);

		sc.nextLine();
		for (int i = 0; i < R; i++) {
			String row = sc.nextLine();
			for (int j = 0; j < C; j++) {
				pizza.setIngredient(i, j, row.charAt(j));
			}
		}
		sc.close();

        System.out.printf("R:%d C:%d L:%d H:%d\nPizza:\n%s\n", R, C, L, H, pizza.toString());
	}
}
