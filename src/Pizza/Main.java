package Pizza;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		processFile("resources/Pizza/example.in", "out/Pizza/example.out");
		processFile("resources/Pizza/small.in", "out/Pizza/small.out");
		processFile("resources/Pizza/medium.in", "out/Pizza/medium.out");
		processFile("resources/Pizza/big.in", "out/Pizza/big.out");
	}

	public static void processFile(String inputFilePath, String outputFilePath) {
		Pizza pizza;
		List<Slice> slicesList;
		final int R, C, L, H;
		int S;

		Scanner sc = null;
		PrintWriter pw = null;
		try {
			sc = new Scanner(new File(inputFilePath));
			pw = new PrintWriter(outputFilePath);

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
					pizza.setCellSlice(i,j,null);
				}
			}
			sc.close();

			// Show the input
			// System.out.printf("R:%d C:%d L:%d H:%d\nPizza:\n%s\n", R, C, L, H, pizza.toString());

			PizzaSolver pizzaSolver = new PizzaSolver(pizza);
			pizzaSolver.generateSlices(L, H);

			slicesList = pizza.getSlices();
			S = slicesList.size();
			pw.println(S);
			for (int i = 0; i < S; i++) {
				pw.println(slicesList.get(i).toString());
			}
			pw.close();

			// Percentage of the pizza covered
			System.out.println((double) pizza.getCellsInSlice()/(R*C));

		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
