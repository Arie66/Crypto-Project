
public class Test {

	
	public static void main(String[] args) {

		String input = "This is some \"really\" great. (Text)!?"; //"AAABBBCCC"; //"This is some \"really\" great. (Text)!?";
		int shift = 0;
		int a = 0;
		String txt = "";
		String codedtxt;
		
		codedtxt = encryptString(input, shift, a) ;
		System.out.println(codedtxt);
	}

	
	
	
	public static String encryptString(String input, int shift, int a ) {
		
		String txt;
		String newtxt;
		String codedtxt;
		
		
		
		txt = normalizeText(input);

		newtxt = ceasarify(txt, shift);
		
		codedtxt = groupify(newtxt, a);
		
		
		return codedtxt;
	}

	
	
	public static String normalizeText(String txt) {
/*		
		txt = txt.replace(" ", "");	
		txt = txt.replace(".", "");
		txt = txt.replace("?", "");
		txt = txt.replace("\"", "");
		txt = txt.replace("(", "");
		txt = txt.replace(")", "");
		txt = txt.replace("!", "");
		txt = txt.toUpperCase();
		System.out.println(txt);
*/		
		txt = txt.toUpperCase().trim().replaceAll("[ .,!?()\"]" , "");
		//System.out.println(txt);
		return txt;
	}

	
	public static String shiftAlphabet(int shift) {
		int start = 0;
		if (shift < 0) {
			start = (int) 'Z' + shift + 1;
		} else {
			start = 'A' + shift;
		}
		String result = "";
		char currChar = (char) start;
		for (; currChar <= 'Z'; ++currChar) {
			result = result + currChar;
		}
		if (result.length() < 26) {
			for (currChar = 'A'; result.length() < 26; ++currChar) {
				result = result + currChar;
			}
		}
		return result;

	}

	public static String ceasarify(String input, int shift) {

		String newtxt = "";
		int ind = 0;
		int i = 0;

		//System.out.println("Input Word - " + input);

		// System.out.println(shiftAlphabet(a));

		while (i < input.length()) {

			char c = input.charAt(i);
			if (c == 'Z' && shift > 0) {

				ind = (shiftAlphabet(shift).lastIndexOf("Z")) + shift;
				newtxt = newtxt + shiftAlphabet(shift).charAt(ind);

			} else if (c == 'A' && shift < 0) {
				
						ind = (shiftAlphabet(shift).lastIndexOf("A")) + shift;
						newtxt = newtxt + shiftAlphabet(shift).charAt(ind);
							
			}else {

			 	ind = (shiftAlphabet(0).lastIndexOf(c)) + shift;
				newtxt = newtxt + shiftAlphabet(0).charAt(ind);
			}

			i++;
		}
		// System.out.println(newtxt);
		return newtxt;

	}

	
	public static String groupify(String input, int a) {
		String newtxt = "";
		String txt = "";
		String chunk = "";

		// System.out.println(input);

		if (input.length() % a != 0) {
			while (input.length() % a != 0) {
				input = input + "x";
			}
		}

		// System.out.println(input);

		for (int i = 0; (i) < (input.length()); i = i + a) {

			// System.out.println(i);
			txt = input.substring(i, i + a);
			chunk = (input.substring(i, i + a) + " ");
			// System.out.println(chunk);
			newtxt = newtxt + chunk;
			// break;
		}

		// System.out.println(newtxt);
		return newtxt;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
