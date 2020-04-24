package com.example.expertisetestoutline;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.expertisetestoutline.model.BookStore;

@SpringBootApplication
public class ExpertiseTestOutlineApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExpertiseTestOutlineApplication.class, args);

		//Use Marshalling and UnMarshalling concept to read the xml file and determine model
		InputStream xmlFile = ExpertiseTestOutlineApplication.class.getResourceAsStream("bookstore.xml");

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(BookStore.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			BookStore bookstore = (BookStore) jaxbUnmarshaller.unmarshal(xmlFile);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
