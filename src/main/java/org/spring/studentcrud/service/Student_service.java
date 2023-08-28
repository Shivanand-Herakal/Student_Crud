package org.spring.studentcrud.service;

import java.util.List;

import org.spring.studentcrud.dao.Student_dao;
import org.spring.studentcrud.dto.StudentDto;
import org.spring.studentcrud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Student_service {

	@Autowired
	Student_dao dao;

	public ResponseStructure<StudentDto> save(StudentDto dto) {
		double percentage = (dto.getEnglish_marks() + dto.getMath_marks() + dto.getScience_marks()) / 3.0;
		dto.setPercentage(percentage);
		if (percentage > 85) {
			dto.setResult("Distinction");
		} else {
			if (percentage > 60) {
				dto.setResult("first class");
			} else {
				dto.setResult("fail");
			}
		}
		ResponseStructure<StudentDto> structure=new ResponseStructure<>();
		structure.setMessage("Data saved succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.save(dto));		
		return structure ;
	}

	public ResponseStructure<List<StudentDto>> saveall(List<StudentDto> dtos) {
		for(StudentDto dto:dtos) {
			double percentage = (dto.getEnglish_marks() + dto.getMath_marks() + dto.getScience_marks()) / 3.0;
			dto.setPercentage(percentage);
			if (percentage > 85) {
				dto.setResult("Distinction");
			} else {
				if (percentage > 60) {
					dto.setResult("first class");
				} else {
					dto.setResult("fail");
				}
			}
		}
		ResponseStructure <List<StudentDto>> structure=new ResponseStructure<>();
		structure.setMessage("Data saved succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveall(dtos));
		return structure;
	}

	   public ResponseStructure<StudentDto> featchById(int id) {
		   ResponseStructure<StudentDto> structure=new ResponseStructure<>();
          StudentDto dto=dao.featchById(id);
          if(dto==null) {
        	  structure.setMessage("data Not Found");
        	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        	  structure.setData(dto);
          }
          else {
        	  structure.setMessage("data Found");
        	  structure.setStatusCode(HttpStatus.FOUND.value());
        	  structure.setData(dto);
          }
		return structure;   
	}  
	   public ResponseStructure<List<StudentDto>> featchByMobile(long mob){
		   ResponseStructure<List<StudentDto>> structure=new ResponseStructure<>();
		   List<StudentDto> list=dao.featchByMobile(mob);
		   if(list.isEmpty()) {
	        	  structure.setMessage("data Not Found");
	        	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        	  structure.setData(null);
	          }
	          else {
	        	  structure.setMessage("data Found");
	        	  structure.setStatusCode(HttpStatus.FOUND.value());
	        	  structure.setData(list);
	          }
			return structure; 
		  
	   }
	   public ResponseStructure<List<StudentDto>> featchByResult(String res){
		   ResponseStructure<List<StudentDto>> structure=new ResponseStructure<>();
		   List<StudentDto> list=dao.featchByResult(res);
		   if(list.isEmpty()) {
	        	  structure.setMessage("data Not Found");
	        	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        	  structure.setData(null);
	          }
	          else {
	        	  structure.setMessage("data Found");
	        	  structure.setStatusCode(HttpStatus.FOUND.value());
	        	  structure.setData(list);
	          }
			return structure; 
		  
	   }

	public ResponseStructure<List<StudentDto>> featch(String name, double percentage) {
		   ResponseStructure<List<StudentDto>> structure=new ResponseStructure<>();
		   List<StudentDto> list=dao.featch(name,percentage);
		   if(list.isEmpty()) {
	        	  structure.setMessage("data Not Found");
	        	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        	  structure.setData(null);
	          }
	          else {
	        	  structure.setMessage("data Found");
	        	  structure.setStatusCode(HttpStatus.FOUND.value());
	        	  structure.setData(list);
	          }
			return structure; 
	}

	public ResponseStructure<List<StudentDto>> featchAll() {
		 ResponseStructure<List<StudentDto>> structure=new ResponseStructure<>();
		   List<StudentDto> list=dao.featchAll();
		   if(list.isEmpty()) {
	        	  structure.setMessage("data Not Found");
	        	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	        	  structure.setData(null);
	          }
	          else {
	        	  structure.setMessage("data Found");
	        	  structure.setStatusCode(HttpStatus.FOUND.value());
	        	  structure.setData(list);
	          }
			return structure;
	}
	public ResponseStructure<StudentDto> delete(int id) {
		dao.delete(id);
		   ResponseStructure<StudentDto> structure=new ResponseStructure<>();
		   structure.setMessage("data deleted");
     	  structure.setStatusCode(HttpStatus.FOUND.value());
     	  structure.setData(null);
     	  return structure;
	}
}