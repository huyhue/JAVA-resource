package Outsource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Hash {

	private static void delete(HashMap<String, String> hm) {
		System.out.println("------------ Delete -------------");
		System.out.print("Enter English: ");
		String english = Validation.checkInputString();
		hm.remove(english);  //xoa
		System.out.println("Successful");
	}

	private static void addNew(HashMap<String, String> hm) {
		System.out.println("------------ Add -------------");
		System.out.print("Enter English: ");
		String english = Validation.checkInputString();
		System.out.print("Enter Vietnamese: ");
		String vietnam = Validation.checkInputString();
		hm.put(english, vietnam);  //them vao
		System.out.println("Successful");
	}

	private static void translate(HashMap<String,String> hm) {
		System.out.println("------------ Translate -------------");
		System.out.print("Enter English: ");
		String english = Validation.checkInputString();
		Set<Entry<String, String>> entries = hm.entrySet();
		for (Entry entry : entries) {
			if (entry.getKey().equals(english)) {
				System.out.println("Vietnamese: " + entry.getValue());
				return;
			}
		}
	}
	
	//check key englist exist
    public static boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
