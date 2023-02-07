package com.techpalle;

import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args) {
		/*Student.creating();
		Student.inserting("Rohit", "Java", "rohit@gmail.com");
		Student.inserting("Mohit", "Python", "mohit@gmail.com");
		Student.inserting("Sohit", ".Net", "sohit@gmail.com");
		Student.inserting("Lohit", "C++", "lohit@gmail.com");
		Student.update(3, "ballu@gmail.com", "C#");
		Student.delete(4);
		Student.read();
		 */
		ArrayList<Student> al = Student.reading();
		for (Student item : al) {
			System.out.println(item.getSno());
			System.out.println(item.getSname());
			System.out.println(item.getSub());
			System.out.println(item.getEmail());
			System.out.println("*************");
		}
	}

}
