package Outsource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Hash {

//    ----------------------------------------------------------------------------------------
    //mau vi du ve hashmap
    static HashMap<Integer, String> map = new HashMap<Integer, String>();

    public static void menu() {
        System.out.println("1.Th�m");
        System.out.println("2.Xu?t");
        System.out.println("3.S?a");
        System.out.println("4.X�a");
        System.out.println("5.T�m");
        System.out.println("6.Tho�t");
        System.out.println("Ch?n g� ?i th�m:");
        int chon = new Scanner(System.in).nextInt();
        switch (chon) {
            case 1:
                them();
                break;
            case 2:
                xuat();
                break;
            case 3:
                sua();
                break;
            case 4:
                xoa();
                break;
            case 5:
                tim();
                break;
            case 6:
                System.err.println("C�m ?n th�m!");
                System.exit(0);
                break;
        }
    }

    private static void tim() {
        System.out.println("Nh?p t�n s�ch mu?n t�m:");
        String ten = new Scanner(System.in).nextLine();
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            if (item.getValue().contains(ten)) {
                System.out.println(item.getKey() + "-" + item.getValue());
            }
        }
    }

    private static void xoa() {
        System.out.println("M?i b?n nh?p m� mu?n x�a:");
        int ma = new Scanner(System.in).nextInt();
        if (map.containsKey(ma) == false) {
            System.out.println("Ch? th?y m� " + ma + " n�o m� x�a");
        } else {
            map.remove(ma);
        }
    }

    private static void sua() {
        System.out.println("M?i b?n nh?p m� mu?n s?a:");
        int ma = new Scanner(System.in).nextInt();
        if (map.containsKey(ma) == false) {
            System.out.println("M� " + ma + " ko t?n t?i");
        } else {
            System.out.println("Nh?p t�n s�ch m?i:");
            String ten = new Scanner(System.in).nextLine();
            map.put(ma, ten);
        }
    }

    private static void xuat() {
        System.out.println("M�\tT�n S�ch");
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }
    }

    private static void them() {
        System.out.println("Nh?p m� s�ch:");
        int ma = new Scanner(System.in).nextInt();
        System.out.println("Nh?p t�n s�ch:");
        String ten = new Scanner(System.in).nextLine();
        if (map.containsKey(ma) == false) {
            map.put(ma, ten);
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }
//    ----------------------------------------------------------------------------------------

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

    private static void translate(HashMap<String, String> hm) {
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
