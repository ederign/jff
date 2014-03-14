package me.ederign.xml.jaxb;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class XmlToJavaObjectTest {

	@Test
	public void testCreateAndRetrieveObject() throws JAXBException {
		String filePathSource = "xml/student.xml";
		
		XmlToJavaObject<Student> xmlToJava = new XmlToJavaObject<Student>();
        JavaToXmlObject<Student> javaToXmlObject = new JavaToXmlObject<Student>();
		Student expected = new Student("Eder", "Ignatowicz", "me@ederign.me",
				"696969");
		javaToXmlObject.marshalling(expected, filePathSource, Student.class);
		assertEquals(expected,
				xmlToJava.getObject(filePathSource, Student.class));
	}
	
	@Test
	public void testCreateAndRetrieveObjects() throws JAXBException {
		String filePathSource = "xml/students.xml";
		
		XmlToJavaObject<Students> xmlToJava = new XmlToJavaObject<Students>();
        JavaToXmlObject<Students> javaToXmlObject = new JavaToXmlObject<Students>();
        
		Student student1 = new Student("Eder", "Ignatowicz", "me@ederign.me",
				"696969");
		Student student2 = new Student("Eder2", "Ignatowicz2", "me@ederign.me",
				"696969");
		Students students = new Students();
		students.add(student1);
		students.add(student2);
		
		javaToXmlObject.marshalling(students, filePathSource, Students.class);
		assertEquals(students.getStudents().size(),
				xmlToJava.getObject(filePathSource, Students.class).getStudents().size());
	}

 
}
