import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Day6 {

	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	private static String[] data;
	private static String[][] data2;
	
	public static void main(String[] args) throws IOException {
		Path fileName = Path.of("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input6.txt");
		String in = Files.readString(fileName);
		data = Arrays.stream(in.split("\n\n")).map(str ->str.replace("\n", "")).toArray(String[]::new);
		data2 = Arrays.stream(in.split("\n\n")).map(str ->str.split("\n")).toArray(String[][]::new);
		
		partOne();
		partTwo();
	}

	private static void partOne() {
		int sum = 0;
		Set<Character> lista = new HashSet<Character>();
		for (String element : data) {
			for(int i = 0; i<element.length(); i++)
				lista.add(element.charAt(i));
			sum += lista.size();
			lista.clear();
		}
		System.out.println(sum);
	}
	
	private static void partTwo() {
		int sum = 0;
		Map<Character, Integer> lista = new HashMap<Character, Integer>();
		for (String group[] : data2) {
			for (String element : group) {
				for(int i = 0; i<element.length(); i++) {
					if (lista.containsKey(element.charAt(i))) {
						lista.put(element.charAt(i), lista.get(element.charAt(i)) + 1);
					}
					else {
						lista.put(element.charAt(i), 1);
					}
				}
			}
			for (Character t : lista.keySet()) {
				if (lista.get(t) == group.length)
					sum++;
			}
			lista.clear();
		}
		System.out.println(sum);
	}

}
