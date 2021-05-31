package ecx.io.demo;

import ecx.io.demo.utility.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws XMLStreamException, IOException {
		SpringApplication.run(DemoApplication.class, args);
		Database.load();
	}

}
