import static java.lang.Integer.parseInt;

public class Password {

	public int range1;
	public int range2;
	public char key;
	public String passwd;

	public Password(String linea) {
		String[] cadena = linea.split("-|:| ");
		range1 = parseInt(cadena[0]);
		range2 = parseInt(cadena[1]);
		key = cadena[2].charAt(0);
		passwd = cadena[4];
	}

	public String toString() {
		return range1 + range2 + key + passwd;

	}

	public boolean checkPartOne() {
		int keyCont = 0;
		for (int i = 0; i < passwd.length(); i++) {
			if (passwd.charAt(i) == key)
				keyCont++;
		}
		if (range1 <= keyCont && keyCont <= range2)
			return true;
		return false;
	}

	public boolean checkPartTwo() {
		if (passwd.charAt(range1 - 1) == key ^ passwd.charAt(range2 - 1) == key)
			return true;
		return false;
	}
}
