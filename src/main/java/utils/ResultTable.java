package utils;

import waguLib.Block;
import waguLib.Board;
import waguLib.Table;

import java.util.ArrayList;
import java.util.List;

public class ResultTable {
    private String tableString;
    private final List<List<String>> rowsList;
    private final List<Integer> columnWidth;
    private final int pageWidth;
    private final int pageHeight;

    public ResultTable(List<String> headersList, List<List<String>> rowsList, int pageWidth,
                       int pageHeight, List<Integer> columnWidth) {
        this.rowsList = rowsList;
        this.columnWidth = columnWidth;
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;

        Board board = new Board(pageWidth);
        Table table = new Table(board, pageWidth, headersList, rowsList);
        List<Integer> colWidthsListEdited = new ArrayList<>(columnWidth);
        table.setGridMode(Table.GRID_FULL).setColWidthsList(colWidthsListEdited).setRowHeight(maxRowsPerLine());

        List<Integer> colAlignList = new ArrayList<>();
        for (int i = 0; i < headersList.size(); i++) {
            colAlignList.add(Block.DATA_MIDDLE_LEFT);
        }
        table.setColAlignsList(colAlignList);

        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        tableString = board.getPreview();
    }

    public void correctTableFromWAGUlib() {
        StringBuilder sb = new StringBuilder(tableString);
        int shift = (pageWidth + 1) * (pageHeight);
        String head = sb.substring(0, (pageWidth + 1) * 3 - 1);
        int i = 1;
        int x = 0;
        while (shift * i + x < sb.length()) {
            sb.insert(shift * i + x, "~\n" + head + "\n");
            i++;
            x += 2;
        }
        tableString = sb.toString();
    }

    public String getTable() {
        correctTableFromWAGUlib();
        return tableString;
    }

    public int maxRowsPerLine() {
        int max = -1;
        for (List<String> list : rowsList) {
            for (String elem : list) {
                if (elem.length() > max) max = elem.length();
            }
        }
        return (int) Math.ceil((double) max / columnWidth.get(2));
    }
}
