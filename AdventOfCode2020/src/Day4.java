import static java.lang.Integer.parseInt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day4 {

	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	private static Collection<String> required = new HashSet<>(
			Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
	static String[][] data;

	public static void main(String[] args) throws IOException {
		Path fileName = Path.of("C:\\Users\\bosco\\Desktop\\AdventOfCode\\input4.txt");
		String in = Files.readString(fileName);
		data = Arrays.stream(in.split("\n\n")).map(str -> str.replace("\n", " ")).map(str -> str.split(" "))
				.toArray(String[][]::new);
		partOne();
		partTwo();
	}

	private static void partOne() {
		int valid = 0;
		Set<String> given = new HashSet<>();
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > 6) {
				for (int j = 0; j < data[i].length; j++) {
					given.add(data[i][j].split(":")[0]);
				}
				valid += valid(given);
				given.clear();
			}
		}
		System.out.println(valid);
	}

	private static int valid(Set<String> password) {
		if (password.containsAll(required))
			return 1;
		return 0;
	}

	private static void partTwo() {
		int valid = 0;
		HashMap<String, String> passport = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			int correct = 0;
			if (data[i].length > 6) {
				for (int j = 0; j < data[i].length; j++) {
					passport.put(data[i][j].split(":")[0], data[i][j].split(":")[1]);
				}
				if (valid(passport.keySet()) == 1) {
					for (Map.Entry<String, String> me : passport.entrySet()) {
						correct += validAndCorrect(me.getKey(), me.getValue());
					}
					if (correct == 7) 
						valid++;
				}					
				passport.clear();
			}
		}
		System.out.println(valid);
	}

	private static int validAndCorrect(String key, String value) {
		//System.out.println(key + "    " + value);
		if (key.equals("byr") && parseInt(value) >= 1920 && parseInt(value) <= 2002) {
			return 1;
		}
		if (key.equals("iyr") && parseInt(value) >= 2010 && parseInt(value) <= 2020){
			return 1;
		}
		if (key.equals("eyr") && parseInt(value) >= 2020 && parseInt(value) <= 2030){
			return 1;
		}
		if (key.equals("hgt"))
			if (value.matches("(1[5-8][0-9]|19[0-3])cm") || value.matches("(59|6[0-9]|7[0-6])in")){
				return 1;
			}
		if (key.equals("hcl")) 
				if (value.matches("#[a-f0-9]{6}")){
					return 1;
				}
		if (key.equals("ecl") && value.matches("amb|blu|brn|gry|grn|hzl|oth")){
			return 1;
		}
		if (key.equals("pid") && value.matches("[0-9]{9}")){
			return 1;
		}
		return 0;
	}

}
