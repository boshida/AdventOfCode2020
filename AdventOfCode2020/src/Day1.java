import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Integer.parseInt;

public class Day1 {

	private static ArrayList<Integer> list = new ArrayList();

	public static void main(String[] args) {

		String linea;
		try {
			File input = new File("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input.txt");
			BufferedReader br = new BufferedReader(new FileReader(input));
			while ((linea = br.readLine()) != null) {
				list.add(parseInt(linea));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Couldn't open the file");
			e.printStackTrace();
		}
		part1();
		part2();
	}

	private static void part1() {
		for (int i = 0; i < list.size(); i++)
			if (list.contains(2020 - list.get(i))) {
				System.out.println(list.get(i) * (2020 - list.get(i)));
				return;
			}
	}

	private static void part2() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				int a = list.get(i);
				int b = list.get(j);
				if (list.contains(2020 - a - b)) {
					System.out.println(a * b * (2020 - a - b));
					return;
				}
			}
		}
	}
}
