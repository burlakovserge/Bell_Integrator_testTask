package parsers.jaxbParser;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "column")
@XmlAccessorType(XmlAccessType.FIELD)
public class Column {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "width")
    private String width;

    public Column() {
    }

    public String getTitle() {
        return title;
    }

    public String getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Column{" +
                "title='" + title + '\'' +
                ", width='" + width + '\'' +
                '}';
    }
}
