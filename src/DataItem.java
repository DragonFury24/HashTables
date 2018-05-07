import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DataItem implements Comparable {
    private int number;
    private String word;

    public DataItem(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public int getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }


    public int hashCode(){
        return Math.abs(word.hashCode());
    }
    public int hashCode(int j) {
        char[] letters = word.toCharArray();
        int[] charID = IntStream.range(0, letters.length)
                                .map(i -> (int) (letters[i]))
                                .toArray();
        int hash = Arrays.stream(charID)
                         .reduce(0, (x, y) -> x + y);

        hash ^= (hash >> 3);
        hash ^= (hash >> 5);
        hash ^= (hash >> 7);

        while (hash > 999)
            hash = hash >> 1;

        //Scrapped for shorter, simpler version above
//        for (int i = 0; i < charID.length; i++) {
//            if ((i & 1) == 0) {
//                if ((charID[i] & 1) == 0) {
//                    hash += charID[i];
//                } else {
//                    hash += charID[i] * 2;
//                }
//            } else {
//                if ((charID[i] & 1) == 0) {
//                    hash -= charID[i] / 2;
//                } else {
//                    hash += (charID[i] * 2) + 3;
//                }
//            }
//        }

        return hash;
    }

    public int compareTo(Object o) {
        return word.compareTo(((DataItem)(o)).getWord());
    }
}
