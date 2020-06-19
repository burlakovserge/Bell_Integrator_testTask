package parsers.tsvParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TsvParser {
    private final BufferedReader br;
    private final Scanner scanner;
    private final List<List<String>> list = new ArrayList<>();

    public TsvParser(String fileName) throws IOException {
        this.br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_16));
        this.scanner = new Scanner(br);
    }

    public void parse() throws IOException {
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split("\t");
            List<String> innerList = new ArrayList<>(Arrays.asList(arr));
            list.add(innerList);
        }
        br.close();
    }

    public List<List<String>> getList() {
        return list;
    }
}
