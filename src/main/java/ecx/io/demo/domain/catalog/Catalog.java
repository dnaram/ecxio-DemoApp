package ecx.io.demo.domain.catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Book> book = new ArrayList<>();

    @Override
    public String toString() {
        return "Catalog{" +
                "book=" + book +
                '}';
    }
}
