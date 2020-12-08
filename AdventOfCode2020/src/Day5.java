import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Day5 {

	public static ArrayList<String> lista = new ArrayList<String>();

	public static void main(String[] args) {
		File input = new File("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input5.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String linea;
			while ((linea = br.readLine()) != null) {
				lista.add(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		partOne();
		partTwo();
	}

	private static void partOne() {
		int result = 0;
		for (String element : lista) {
			String fila = element.substring(0, 7);
			fila = fila.replace('B', '1');
			fila = fila.replace('F', '0');
			int row = Integer.parseInt(fila, 2);
			String columna = element.substring(7, 10);
			columna = columna.replace('R', '1');
			columna = columna.replace('L', '0');
			int col = Integer.parseInt(columna, 2);
			if (result < row*8 + col) {
				result = row*8 + col;
			}
		}
		System.out.println("Resultado = " + result);
	}

	private static void partTwo() {
		int[] result = new int[829];
		for (String element : lista) {
			String fila = element.substring(0, 7);
			fila = fila.replace('B', '1');
			fila = fila.replace('F', '0');
			int row = Integer.parseInt(fila, 2);
			String columna = element.substring(7, 10);
			columna = columna.replace('R', '1');
			columna = columna.replace('L', '0');
			int col = Integer.parseInt(columna, 2);
			result[row*8 + col] = row*8 + col;
		}
		for(int i = 0; i<result.length; i++)
			if (result[i] != i)
				System.out.println(i);
	}

}
