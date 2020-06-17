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


//    public String findValueByField(String field) {
//        //String res= "";
//        for (Column column : settingsFromXML.getColumns()) {
//            if (column.getTitle().equals(field)) {
//                return column.getWidth();
//            }
//        } else throw NullPointerException;
//        return res;
//    }
}
