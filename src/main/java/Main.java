import jaxb.JaxbParser;
import wagu.Block;
import wagu.Board;
import wagu.Table;

import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        String incomeFile = "resources/source-data.tsv";
        String outputFile = "resources/dataout.txt";
        String settings = "resources/outTableSettings.xml";

        TsvParser tsvParser = new TsvParser(incomeFile);
        tsvParser.parse();
        JaxbParser jp = new JaxbParser(settings);

        List<String> headersList = new ArrayList<>(jp.getHeaders());
        List<List<String>> rowsList = new ArrayList<>(tsvParser.getList());

        Board board = new Board(100);
        Table table = new Table(board, 100, headersList, rowsList);
        List<Integer> colWidthsListEdited = Arrays.asList(12, 20, 30);
        table.setGridMode(Table.GRID_FULL).setColWidthsList(colWidthsListEdited);
        List<Integer> colAlignList = Arrays.asList(Block.DATA_MIDDLE_LEFT,Block.DATA_MIDDLE_LEFT,Block.DATA_MIDDLE_LEFT);
        table.setColAlignsList(colAlignList);

        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();

        FileWriter fw = new FileWriter(outputFile);
        fw.write(tableString);
        fw.close();


    }
}
