package MyApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyApp implements DataConnection {

    private final String pathname = "1.txt";
    private String year;
    private static int loadEntranceCounter = 0;
    private static int saveCounter = 0;

    public MyApp(String year) {
        this.year = year;
    }

    public static int getLoadEntranceCounter() {
        return loadEntranceCounter;
    }

    @Override
    public int loadData(int initialValue) throws IOException {

        int sum = initialValue;
        int firstIndex = 0;

        File file = new File(pathname);
        String stringFromFile = getStringFromFile(file);

        while (true) {

            int endOfStringIndex = stringFromFile.indexOf("\r\n", firstIndex + 1);
            if (endOfStringIndex == -1) {
                break;
            }

            String lineData = stringFromFile.substring(firstIndex, endOfStringIndex);
            String[] valueTokens = lineData.split(" ");

            if (valueTokens[2].contains(year)) {
                sum = sum + Integer.parseInt(valueTokens[3]);
            }

            loadEntranceCounter++;
            firstIndex = endOfStringIndex;
        }
        return sum;
    }

    private String getStringFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String str = "";
        int i = fis.read();
        do {
            str = str + new String(new byte[]{(byte) i});
            i = fis.read();
        } while (i != -1);
        return str;
    }

    @Override
    public void saveData(int year, double devResult) throws IOException {
        FileOutputStream fis = new FileOutputStream(new File("Statistics.txt"), true);
        String s = saveCounter + " " + year + " " + devResult + "\n";
        fis.write(s.getBytes());
        saveCounter++;
    }
}
