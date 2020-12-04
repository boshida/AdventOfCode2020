import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Day3 {

	public static ArrayList<String> map = new ArrayList<String>();

	public static void main(String[] args) {
		File input = new File("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input3.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String linea;
			while ((linea = br.readLine()) != null) {
				map.add(linea);
				// System.out.println(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		partOne();
		partTwo();
	}

	private static void partOne() {
		int x = 0;
		int y = 0;
		int trees = 0;
		int length = map.get(0).length();
		int depth = map.size();
		while (y < depth) {
			if (x >= length)
				x = x - length;
			if (y > depth) {
				System.out.println("Trees: " + trees);
				return;
			}
			if (map.get(y).charAt(x) == '#')
				trees++;
			x += 3;
			y += 1;
		}
		System.out.println(trees);
	}

	private static void partTwo() {
		int[] coordinates = { 1, 1, 3, 1, 5, 1, 7, 1, 1, 2 };
		int x, y;
		int trees = 0;
		long mult = 1;
		int length = map.get(0).length();
		int depth = map.size();
		for (int i = 0; i < coordinates.length; i += 2) {
			x = 0;
			y = 0;
			while (y < depth) {
				if (x >= length)
					x = x - length;
				if (map.get(y).charAt(x) == '#')
					trees++;
				x += coordinates[i];
				y += coordinates[i+1];
			}
			mult *= trees;
			trees = 0;
		}
		System.out.println(mult);
		
	}

}
