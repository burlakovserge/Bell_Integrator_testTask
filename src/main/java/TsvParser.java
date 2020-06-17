import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TsvParser {
    private FileReader fr;
    private Scanner scanner;
    private List<List<String>> list = new ArrayList<>();

    public TsvParser(String fileName) throws IOException {
        this.fr = new FileReader(fileName, StandardCharsets.UTF_16);
        this.scanner = new Scanner(fr);
    }

    public void parse() throws IOException {
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\t");
            list.add(Arrays.asList(arr[0], arr[1], arr[2]));
        }
        fr.close();
    }

    public List<List<String>> getList() {
        return list;
    }
}
