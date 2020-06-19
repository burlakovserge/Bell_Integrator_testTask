import parsers.jaxbParser.JaxbParser;
import parsers.tsvParser.TsvParser;
import utils.Log;
import utils.ResultTable;

import javax.xml.bind.JAXBException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Generator {
    public static void main(String[] args) throws IOException, JAXBException {
        try {
            String settings = args[0];
            String incomeFile = args[1];
            String outputFile = args[2];

            //Parse data from tsv file
            TsvParser tsvParser = new TsvParser(incomeFile);
            tsvParser.parse();
            //Parse settings from xml file
            JaxbParser jp = new JaxbParser(settings);

            //Transfer settings and data for build result table
            ResultTable resultTable = new ResultTable(jp.getHeaders(), tsvParser.getList(),
                    jp.getPageWidth(), jp.getPageHeight(), jp.getColumnWidth());

            //Write result table to file
            OutputStreamWriter writer =
                    new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_16);
            writer.write(resultTable.getTable());
            writer.close();
        } catch (ArrayIndexOutOfBoundsException e){
            Log.info("To launch the app you must pass 3 arguments after executable file: \n" +
                    "1 - .xml with settings for the generated table\n" +
                    "2 - .tsv with data\n" +
                    "3- name output file\n" +
                    "For example: Generator.class settings.xml source-data.tsv example-report.txt");
        }
    }
}
