package jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings {

    private Page page;

    @XmlElementWrapper(name = "columns", nillable = true)
    @XmlElement(name = "column")
    private List<Column> columns;

    public Page getPage() {
        return page;
    }
    public List<Column> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "TableSettings{" +
                "page=" + page +
                ", columns=" + columns +
                '}';
    }
}
