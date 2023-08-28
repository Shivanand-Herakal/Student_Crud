package org.spring.studentcrud.repository;

import java.util.List;

import org.spring.studentcrud.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Student_repository extends JpaRepository<StudentDto, Integer>{

	List<StudentDto> findByMobile(long mob);
	List<StudentDto> findByResult(String res);
	@Query("select x from StudentDto x where name=?1 and percentage>=?2")
	List<StudentDto> findByNameandPercentageGreater(String name, double percentage);
	
}
