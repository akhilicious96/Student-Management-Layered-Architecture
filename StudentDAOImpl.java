package com.cg.sms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.cg.sms.dto.Student;

public class StudentDAOImpl implements StudentDAO {

	Map<Integer, Student> studentMap;
	ArrayList<Integer> checkRoll = new ArrayList<Integer>();
	boolean flag = true;
	public StudentDAOImpl(){
		studentMap = DataStore.createCollection();
	}
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		int rollno = (int)(1000*Math.random());
		while(flag){
			if(!checkRoll.contains(rollno)){
				checkRoll.add(rollno);
				flag = true;
				break;
			}
			else{
				rollno = (int)(1000*Math.random());
				flag = false;
			}
		
		}
		student.setRollno(rollno);
		studentMap.put(rollno,student);
		
		return rollno;
	}
	@Override
	public Student getStudent(int rn) {
		// TODO Auto-generated method stub
		
		return studentMap.get(rn);
	}
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMap.put(student.getRollno(), student);
		return student;
	}
	@Override
	public ArrayList<Student> getStudentList(String course) {
		// TODO Auto-generated method stub
		Collection<Student> studentList = studentMap.values();
		ArrayList<Student>studentCourseList = new ArrayList<>();
		Iterator<Student> itr = studentList.iterator();
		while(itr.hasNext()){
			Student s = itr.next();
			if(s.getCourseName().equals(course)){
				studentCourseList.add(s);
			}
				
		}
//		for(Student s : studentList)
//			if(s.getCourseName().equals(course))
//				studentCourseList.add(s);
//		
		return studentCourseList;
	}

}
