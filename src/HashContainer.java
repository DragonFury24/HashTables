import java.io.File;
import java.util.ArrayList;

public class HashContainer {
    private Tree[] list = new Tree[1000];
    private int    size = 0;

    public HashContainer() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Tree();
        }
    }

    public void add(DataItem x) {
        list[x.hashCode()].add(x);
        size++;
    }

    public Comparable[] get(String index) {
        return list[hashString(index)].getAll();
    }

    public Comparable[] remove(String index) {
        Comparable[] removed = get(index);
        list[hashString(index)] = new Tree();
        return removed;
    }

    public Comparable remove(String index, Comparable x) {
        int hash = hashString(index);

        Comparable removed;

        for (Comparable item : list[hash].getAll()) {
            if (item == x) {
                removed = item;
                break;
            }
        }
        list[hashString(index)].remove(x);
    }

    public boolean search(DataItem x) {
        return list[x.hashCode()].search(x) == x;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //Test hashes
    public static void main(String[] args) {
        ArrayList<String> data = FileUtils.readFile(new File("src/hashData.txt"));
        DataItem[] dataItems = new DataItem[10000];

        for (int i = 0; i < dataItems.length; i++) {
            int number = Integer.parseInt(data.get(i).split(" ")[0]);
            String word = data.get(i).split(" ")[1];
            dataItems[i] = new DataItem(number, word);
        }

//        for (DataItem item : dataItems) {
//            System.out.println(HashContainer.hashString(item.getWord()));
//        }
    }
}
