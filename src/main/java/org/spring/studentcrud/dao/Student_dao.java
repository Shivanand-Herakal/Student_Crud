package org.spring.studentcrud.dao;

import java.util.List;
import java.util.Optional;

import org.spring.studentcrud.dto.StudentDto;
import org.spring.studentcrud.repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Student_dao {
	@Autowired
	Student_repository repository;
	public StudentDto save(StudentDto dto) {
		return repository.save(dto);
	}
	public List<StudentDto> saveall(List<StudentDto> dto){
		return repository.saveAll(dto);
	}
	public StudentDto featchById(int id) {
	 Optional<StudentDto> op =repository.findById(id);
	 if(op.isEmpty())
	 {
		 return null;
	 }
	 else {
		 return op.get();
	 }
	}
	public List<StudentDto> featchByMobile(long mob){
		return repository.findByMobile(mob);
	}
	
	public List<StudentDto> featchByResult(String res){
		return repository.findByResult(res);
	}
	public List<StudentDto> featch(String name, double percentage) {
	
		return repository.findByNameandPercentageGreater(name,percentage);
	}
	public List<StudentDto> featchAll() {
		return repository.findAll();
	}
	public void delete(int id) {
		repository.deleteById(id);
	}
	
}
