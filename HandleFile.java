package Outsource;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Scanner;

public class HandleFile {
	
	private static void saveFile(String filename,HashMap<String, String> hm) throws IOException {
        File f = new File(filename);
        if (!f.exists()) {
            f.delete();
        }
        RandomAccessFile r = new RandomAccessFile(filename, "rw");
        Set<Entry<String, String>> entries = hm.entrySet();
		for (Entry entry : entries) {
			r.writeBytes(entry.getKey() + ";" + entry.getValue() + "\n");
		}
        r.close();
    }

	private static void loadData(HashMap<String, String> hm) throws IOException {
		RandomAccessFile f = new RandomAccessFile("D:\\dictionary.txt", "r");
		String S;
		while ((S = f.readLine()) != null) {
			S = S.trim();
			if (S.length() > 0) {
				StringTokenizer stk = new StringTokenizer(S, ";");
				String english = stk.nextToken();
				String vietnam = stk.nextToken();
				hm.put(english, vietnam);
			}
		}
		f.close();
	}
	
	
	
	
	
	
	
	private static final Scanner in = new Scanner(System.in);

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static void checkInputPath() {
        System.out.print("Please input Path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
        } else {
            System.err.println("Path isn't file.");
        }
    }

    private static String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk + 1, toNameFile);
    }

    private static String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    private static String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot, path.length());
    }

    private static String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon + 1);
    }

    private static String getForder(String path) {
        int positionColon = path.indexOf("\\");
        int positionDot = path.lastIndexOf("\\");
        path = path.substring(positionColon, positionDot);
        String[] splitFile = path.split("\\");
        return splitFile[splitFile.length - 1];
    }
}
