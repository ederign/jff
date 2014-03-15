package me.ederign.json;

import static org.junit.Assert.*;
import me.ederign.beans.Student;

import org.junit.Test;

import com.google.gson.Gson;

public class GsonTest {

	@Test
	public void toJson(){
		String expected="{\"firstName\":\"Eder\",\"lastName\":\"Ignatowicz\",\"email\":\"me@ederign.me\",\"phone\":\"696969\"}";
		Gson g = new Gson();
		Student student = new Student("Eder", "Ignatowicz", "me@ederign.me",
				"696969");
		assertEquals(expected,g.toJson(student));
	}
	
	@Test
	public void fromJSon(){
		String json="{\"firstName\":\"Eder\",\"lastName\":\"Ignatowicz\",\"email\":\"me@ederign.me\",\"phone\":\"696969\"}";
		Gson g = new Gson();
		Student expected = new Student("Eder", "Ignatowicz", "me@ederign.me",
				"696969");
		assertEquals(expected,g.fromJson(json, Student.class));
	}
	
}
