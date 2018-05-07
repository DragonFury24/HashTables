import java.util.ArrayList;
import java.util.Random;

public class Generate {
    public static String randomWord() {
        Random               gen = new Random();
        int                  length = gen.nextInt(6) + 3;
        ArrayList<Character> letters = new ArrayList<>();

        for (int i = 0; i < length; i++) {
        if ((i & 1) != 0) {
            int choice = gen.nextInt(5);
            char letter = 0;
            switch (choice) {
                case 0:
                    letter = 'a';
                    break;
                case 1:
                    letter = 'e';
                    break;
                case 2:
                    letter = 'i';
                    break;
                case 3:
                    letter = 'o';
                    break;
                case 4:
                    letter = 'u';
            }
            letters.add(letter);

            continue;
        }

        int choice = 0;

        do {
            choice = gen.nextInt(26) + 97;
        } while (choice == 'a' || choice == 'e' || choice == 'i' || choice == 'o' || choice == 'u');

        letters.add((char)choice);
    }

    String result = "";
        for (char letter : letters) {
            result += letter;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] data = new String[10000];

        for (int i = 0; i < 10000; i++) {
            data[i] = i + " " + Generate.randomWord();
        }

        FileUtils.writeToFile(data);
    }
}
