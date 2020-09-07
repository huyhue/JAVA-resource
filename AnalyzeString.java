package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnalyzeString {
//------------------------------------------------------------------------
	String str = checkInputString(); //I AM a stuDENT in FPT uniVersity
	System.out.println(handle(str)); //RESULT: I Am A Student In Fpt University
	private static void handle(String str) {
		String s = str.toLowerCase().trim();
		s=s.replaceAll("\\s+"," ");
		 StringBuffer stringBuffer = new StringBuffer(s);
		for (int i = 0; i < stringBuffer.length()-1; i++) {
			stringBuffer.setCharAt(0, Character.toUpperCase(stringBuffer.charAt(0)));
			if (stringBuffer.charAt(i) == ' ') {
				char after = stringBuffer.charAt(i + 1);
				stringBuffer.setCharAt(i+1, Character.toUpperCase(after));
			}
		}
		return stringBuffer.toString();
	}
//------------------------------------------------------------------------
	/*Enter your content: heel heel no stop
	{no=1, heel=2, stop=1}
	{p=1, s=1, t=1, e=4, h=2, l=2, n=1, o=2}
	*/
	private Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
	private Map<String, Integer> wordCounter = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your content: ");
		String content = scanner.nextLine();
		main counter = new main();
		counter.analyze(content);
		counter.display();
	}

	public void display() {
		System.out.println(wordCounter);
		System.out.println(charCounter);
	}

	public void analyze(String content) {
		for (char ch : content.toCharArray()) {
			if (Character.isSpaceChar(ch))
				continue;
			if (!charCounter.containsKey(ch)) {
				charCounter.put(ch, 1);
			} else {
				charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
			}
		}
		StringTokenizer tokenizer = new StringTokenizer(content);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (!wordCounter.containsKey(token)) {
				wordCounter.put(token, 1);
			} else {
				wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
			}
		}
	}
//------------------------------------------------------------------------
    private static final Scanner in = new Scanner(System.in);

    private static boolean checkSquareNumber(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }

    private static void getNumber(String inputString) {
        HashMap<String, ArrayList<Integer>> hmNumber = new HashMap<>();
        String number = inputString.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;

        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }
            if (checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);

        for (Map.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    private static void getCharacter(String inputString) {
        HashMap<String, String> hmString = new HashMap<>();
        String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = inputString.replaceAll("\\w", "");
        String allCharacter = inputString.replaceAll("\\W", "");
        hmString.put("Uppercase: ", uppercase);
        hmString.put("Lowercase: ", lowercase);
        hmString.put("Special: ", special);
        hmString.put("All Character: ", allCharacter);
        for (Map.Entry m : hmString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    public static void main(String[] args) {
        getNumber("32hg321sdhkjDFGH!@#$%^22fdsf3fdgdf/");
        getCharacter("32hg321sdhkjDFGH!@#$%^22fdsf3fdgdf/");

    }
}
