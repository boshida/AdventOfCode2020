import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {

	public static ArrayList<Password> passwdList = new ArrayList();

	public static void main(String[] args) {
		String linea;
		try {
			File input = new File("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input2.txt");
			BufferedReader br = new BufferedReader(new FileReader(input));
			while ((linea = br.readLine()) != null) {
				passwdList.add(new Password(linea));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Couldn't open the file");
			e.printStackTrace();
		}

		partOne();
		partTwo();

	}

	private static void partOne() {
		int cont = 0;
		for (int i = 0; i < passwdList.size(); i++) {
			if (passwdList.get(i).checkPartOne()) {
				cont++;
			}
		}
		System.out.println(cont);

	}

	private static void partTwo() {
		int cont = 0;
		for (int i = 0; i < passwdList.size(); i++) {
			if (passwdList.get(i).checkPartTwo()) {
				cont++;
			}
		}
		System.out.println(cont);

	}

}
