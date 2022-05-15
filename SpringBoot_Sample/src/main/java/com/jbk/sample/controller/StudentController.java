package com.jbk.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.sample.entity.Student;

@RestController
public class StudentController {

	List<Student> list = new ArrayList<>();

	@PostMapping(value = "/saveStudent")
	public List<Student> saveStudent(@RequestBody Student student) {
		list.add(student);
		return list;
	}

	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {
		return list;
	}

	@GetMapping(value = "/getStudent/{id}")
	public Student geStudentById (@PathVariable int id) {
		
		Student student =null;
		for(Student std: list) {
			if(std.getStudentId()==id) {
				student=std;
				break;
			}
		}
		return student;
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student){

		String msg="student does not exist";
		for(Student s: list) {
			if(s.getStudentId()==student.getStudentId()) {
				list.remove(s);
				list.add(student);
				msg="updated";
				break;
			}
			
		}
//		we can use string as return type
		
		return  msg;
	}
		
	
	@DeleteMapping(value="/deleteStudent/{id}")
    public String deleteStudentById (@PathVariable int id) {
		String msg="student does not exist";
		 for( Student std: list) {
			 if(std.getStudentId()==id) {
				list.remove(std) ;
				msg="deleted";
				break;
			 }
		 }
		return msg;
    }
	
	
	
	
	
//	@RequestMapping("load")
//	public List<Student> getStudent(){
//		return list;
//	}
//	
//	@PostMapping("load/{id}")
//	public List<Student> updateStudent(@PathVariable int id){
//		for(int i=0;i<list.size(); i++) {
//			ArrayList <Student> al=new ArrayList<>();
//			if(id==(list.get(i).getStudentId())) {
//				al.add(list.get(i));
//				System.out.println(al);
//				return(List<Student>) al;
//			}
//		}
//		return null;
//	}
	

}
