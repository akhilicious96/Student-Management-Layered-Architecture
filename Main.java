package com.cg.sms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {

	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		
		StudentServiceImpl service = new StudentServiceImpl();
		
		
		Scanner sc = new Scanner(System.in);
		
		int ch=0;
		
		String name, cname, mob;
		int age;
		do{
			
			System.out.println("1.Add Student\n2.Display Student Details\n3Updtae Details\n4.Display Student List\n5.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			switch(ch){
					
				case 1 :
					System.out.println("Enter name :");
					name = sc.next();
					
					System.out.println("Enter course name :");
					cname = sc.next();
					
					System.out.println("Enter age :");
					age = sc.nextInt();
					
					System.out.println("Enter mobile no :");
					mob = sc.next();
					Student student = new Student();
					student.setName(name);
					student.setAge(age);
					student.setCourseName(cname);
					student.setMobileNo(mob);
					
					int rn = service.addStudent(student);
					System.out.println("Student recoed added.." + rn);
					
					break;
				case 2 :
					System.out.println("Enter roll number :");
					rn = sc.nextInt();
					
					student = service.getStudent(rn);
					
					if(student == null)
						System.out.println("Record not found!");
					else{
						System.out.println("Name : "+ student.getName());
						System.out.println("Course Name : "+student.getAge());
						System.out.println("Age : "+student.getCourseName());
						System.out.println("Mobile Number : "+student.getMobileNo());
					}
					
					break;
					
				case 3:
					System.out.println("Enter roll number to update details :");
					rn = sc.nextInt();
					
					student = service.getStudent(rn);
					if(student == null)
						System.out.println("Record not found!");
					else{
																	
						System.out.println("Enter mobile no :");
						mob = sc.next();
						student.setMobileNo(mob);
						student = service.updateStudent(student);
						System.out.println("record updated");
						System.out.println(student.getName());
						System.out.println(student.getMobileNo());
					}							
					break;
					
				case 4:
					System.out.println("Enter course name to view details :");
					cname = sc.next();
					
					ArrayList<Student> list = service.getStudentList(cname);
					System.out.println(list.size());
					if(list.size() == 0)
						System.out.println("No student enrolled to this record");
					else{
						
						for(Student s : list)
							System.out.println(s.getName()+" "+s.getMobileNo());
					
					}
					
					break;
				case 5:
					System.out.println("Have a good day!");
					break;
				default : System.out.println("Invlaid choice!");
			}
		}while(ch != 5);
		sc.close();
	}
	
}
