package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser {
    private Settings settingsFromXML;

    public JaxbParser(String settings) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        Unmarshaller um = context.createUnmarshaller();
        settingsFromXML = (Settings) um.unmarshal(new File(settings));
    }

    public List<String> getHeaders(){
        List <String> headers= new ArrayList<>();
        for (Column column : settingsFromXML.getColumns()){
            headers.add(column.getTitle());
        }
        return headers;
    }

    public List<Integer> getColumnWidth(){
        List <Integer> columnWidth= new ArrayList<>();
        for (Column column : settingsFromXML.getColumns()){
            columnWidth.add(Integer.parseInt(column.getWidth())); // +2
        }
        return columnWidth;
    }

    public int getPageWidth (){
        return Integer.parseInt(settingsFromXML.getPage().getWidth());
    }

    public int getPageHeight (){
        return Integer.parseInt(settingsFromXML.getPage().getHeight());
    }


}
