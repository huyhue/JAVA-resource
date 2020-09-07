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

    private static void saveFile(String filename, HashMap<String, String> hm) throws IOException {
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
//	-------------------------------------------------------------------------------------------

    public static void coppyFile() throws IOException {
        String pathIn = Validation.checkInputPathFile();
        File f1 = new File(pathIn);
        String pathOut = Validation.checkInputPathFile();
        File f2 = new File(pathOut);
        if (!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(f1).getChannel();
            destChannel = new FileOutputStream(f2).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
        //	-------------------------------------------------------------------------------------------
        //file cho doi tuong dung SerializeFile (public class DanhBa implements Serializable)

    public static boolean saveFile(ArrayList<DanhBa> dsDB, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsDB);
            oos.close();
            fos.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<DanhBa> readFile(String path) {
        ArrayList<DanhBa> dsDB = new ArrayList<DanhBa>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            dsDB = (ArrayList<DanhBa>) data;
            ois.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsDB;
    }
//	-------------------------------------------------------------------------------------------

    @Override
    public Vector getInitialData() throws RemoteException {
        Vector data = new Vector(0);
        try {
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line;
            StringTokenizer stk;
            String code, name;
            int salary;
            while ((line = br.readLine()) != null) {
                stk = new StringTokenizer(line, ",");
                Vector v = new Vector();
                v.add(stk.nextToken());
                v.add(stk.nextToken());
                v.add(Integer.parseInt(stk.nextToken()));
                data.add(v);
            }
            br.close();
            f.close();
        } catch (Exception e) {
        }
        return data;
    }

    @Override
    public boolean saveList(Vector data) throws RemoteException {
        try {
            FileWriter f = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(f);
            for (int i = 0; i < data.size(); i++) {
                Vector v = (Vector) data.get(i);
                String S = "";
                S += v.get(0) + "," + v.get(1) + "," + v.get(2);
                pw.println(S);
                return true;
            }
            pw.close();
            f.close();
        } catch (Exception e) {
        }
        return false;
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
    //-------------------------------------------------------------------------------------
  //allow user copy text to new file
    public static void coppyNewFile() {
        String pathFileInput = Validation.checkInputPathFile();
        String pathFileOutput = Validation.checkInputPathFile();
        String content = getNewContent(pathFileInput); //lay noi dung tu file cu
        System.out.println(content);
        writeNewContent(pathFileOutput, content);
    }

  //get new content
    public static String getNewContent(String pathFileInput) {
        HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFileInput);
        try {
            Scanner input = new Scanner(file);
            int count = 0;
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        String content = "";
        for (String line : newContent) {
            content += line;
        }
        return content;
    }

    //write new content to file
    public static void writeNewContent(String pathFileOutput, String content) {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(content);
            bufferWriter.close();
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //get list person by path file (doc file)
    public static ArrayList<Person> getListPerson(String pathFile) {
        ArrayList<Person> lp = new ArrayList<>();
        File file = new File(pathFile);
        //check file exist or not and path must be file
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                lp.add(new Person(infoPerson[0], infoPerson[1],
                        getSalary(infoPerson[2])));

            }
        } catch (Exception e) {
            System.err.println("Can't read file.");
        }
        return lp;
    }
}
