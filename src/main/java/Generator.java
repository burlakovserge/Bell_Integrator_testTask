import jaxb.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) throws IOException, JAXBException {
        //java Generator.class settings.xml source-data.tsv example-report.txt
        String settings = "src/main/resources/settings.xml";
        String incomeFile = "src/main/resources/source-data.tsv";
        String outputFile = "src/main/resources/dataout.txt";


        //Parse data from tsv file
        TsvParser tsvParser = new TsvParser(incomeFile);
        tsvParser.parse();
        //Parse settings from xml file
        JaxbParser jp = new JaxbParser(settings);

        //Transfer settings and data for build result table
        ResultTable resultTable = new ResultTable(jp.getHeaders(),tsvParser.getList(),
                jp.getPageWidth(), jp.getPageHeight(),jp.getColumnWidth());

        //Write result table to file
        FileWriter fw = new FileWriter(outputFile);
        fw.write(resultTable.getTable());
        fw.close();
    }
}
