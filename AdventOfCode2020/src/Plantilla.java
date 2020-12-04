import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Plantilla {

	public static ArrayList<Integer> lista = new ArrayList<Integer>();

	public static void main(String[] args) {
		File input = new File("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String linea;
			while ((linea = br.readLine()) != null) {
				lista.add(parseInt(linea));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		partOne();
		partTwo();
	}

	private static void partOne() {

	}

	private static void partTwo() {

	}

}
