import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    public static ArrayList<String> readFile(File file) {
        String          tempInput;
        ArrayList<String> countryInfo = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((tempInput = br.readLine()) != null) {
                countryInfo.add(tempInput);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        return countryInfo;
    }

    public static void writeToFile(String[] outputs) {
        File hashData = new File("src/hashData.txt");

        if (hashData.exists())
            hashData.delete();

        try {
            hashData.createNewFile();
        } catch (IOException io) {
            io.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(hashData))) {
            for (String line : outputs) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
