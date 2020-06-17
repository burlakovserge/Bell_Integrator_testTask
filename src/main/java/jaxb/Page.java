package jaxb;

import javax.xml.bind.annotation.*;

@XmlType(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page {

    @XmlElement(name = "width")
    private String width;

    @XmlElement(name = "height")
    private String height;


    public Page() {
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Page{" +
                "width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
