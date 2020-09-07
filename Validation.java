package Outsource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private final static Scanner in = new Scanner(System.in);
    /*
	 * \\d{10} user must be input 10 number \\d* user can input more number or not
     */
    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    /*
	 * [A-Za-z0-9.-+%]+ user must be input from a-z ignore case,0-9 and .-+% least
	 * one times
	 * 
	 * @ user must be input "@" [A-Za-z.-]+ user mustbe input from a-z ignore case,
	 * "." "-" least one times \\. user must be input "." [A-Za-z]{2,4} user must be
	 * input from a-z ignore 2 - 4 times
     */
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    private static final String DATE_VALID = "^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$";

    // check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        // loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    // check user input string
    public static String checkInputString() {
        // loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

public static String checkInputPathFile() {
        System.out.print("Enter path file: ");
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    // check user input y/Y or n/N
    public static boolean checkInputYN() {
        // loop until user input correct
        while (true) {
            String result = checkInputString();
            // check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check user input int
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }

    private static float checkInputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Enter again.");
            }
        }
    }

    private static String checkInputDate1() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                if (result.matches(DATE_VALID)) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static Date checkInputDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        while (true) {
            String result = checkInputString();
            try {
                date = formater.parse(result);
                return date;
            } catch (ParseException e) {
                System.err.println("Please input in format (dd/MM/yyyy)");
                System.out.print("Enter again: ");
            }
        }
    }

    public static Date checkInputDischargedDate(Date dischargedDate) {
        Date date = new Date();
        while (true) {
            date = checkInputDate();
            if ((date.getTime() - dischargedDate.getTime()) > 0) {
                return date;
            }
            System.err.println("Discharged date must later than hospitalized date");
            System.out.print("Enter again: ");
        }
    }
    
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    // check phone is number with minimum 10 characters
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            // check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }

    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    //check input phone

    public static String checkInputPhone1() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone flow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputCode() {
        while (true) {
            String result = checkInputString();
            if (result.length() == 4) {
                return result;
            }
            System.err.println("Tour's code must have 4 characters");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputGender() {
        while (true) {
            String result = in.nextLine();
            if (result.equalsIgnoreCase("m")) {
                return "Male";
            }
            if (result.equalsIgnoreCase("f")) {
                return "Female";
            }
            if (result.equalsIgnoreCase("u")) {
                return "Unknown";
            }
            System.err.println("Please enter m/f/u");
            System.out.print("Enter again: ");
        }
    }

    // check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
    public static String checkInputEmail() {
        // loop until user input correct
        while (true) {
            String result = checkInputString();
            // check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    // check user input graduation rank
    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence") || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair") || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    // check id exist or not
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    // check experience must be smaller then age
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    private static int checkInputMark(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                if (result > 10) {
                    System.err.println(nameSubject + " is less than equal ten");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
                System.out.print(nameSubject + ":");
            }
        }
    }

    public static boolean checkIdFormat(String id) {
        if (id.matches("[A-Za-z0-9]+")) {
            return true;
        }
        return false;
    }

    public static boolean checkNameFormat(String name) {
        if (name.matches("[A-Za-z0-9 ]+")) {
            return true;
        }
        return false;
    }

    public static boolean checkIntFormat(String n) {
        if (n.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    public static boolean checkIntRange(int a, int b, String n) {
        int number = Integer.parseInt(n);
        if (number <= a || number >= b) {
            return false;
        }
        return true;
    }

    public static boolean checkIdExited(Vector<Vector<String>> data, String id) {
        for (Vector<String> i : data) {
            if (i.get(0).equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneFormat(String phone) {
        if (phone.matches("[0\\d{9}]") && phone.length() == 10) {
            return true;
        }
        return false;
    }

}
