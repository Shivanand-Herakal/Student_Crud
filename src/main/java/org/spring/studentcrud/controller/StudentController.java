package org.spring.studentcrud.controller;

import java.util.List;

import org.spring.studentcrud.dto.StudentDto;
import org.spring.studentcrud.helper.ResponseStructure;
import org.spring.studentcrud.service.Student_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	Student_service service;

	@PostMapping("student")
	public ResponseStructure<StudentDto> save(@RequestBody StudentDto dto) {
		return service.save(dto);
	}

	@PostMapping("students/multiple")
	public ResponseStructure<List<StudentDto>> saveall(@RequestBody List<StudentDto> dtos) {
		return service.saveall(dtos);
	}

	@GetMapping("students")
	public ResponseStructure<StudentDto> featchBYId(@RequestParam int id) {
		return service.featchById(id);
	}

	@GetMapping("students/{id}")
	public ResponseStructure<StudentDto> fetchById2(@PathVariable int id) {
		return service.featchById(id);
	}

	@GetMapping("students/mobile/{mob}")
	public ResponseStructure<List<StudentDto>> featchByMobile(@PathVariable long mob) {
		return service.featchByMobile(mob);
	}

	@GetMapping("students/result/{res}")
	public ResponseStructure<List<StudentDto>> featchByResult(@PathVariable String res) {
		return service.featchByResult(res);
	}

	@GetMapping("students/{name}/{percentage}")
	public ResponseStructure<List<StudentDto>> featchByResult(@PathVariable String name,
			@PathVariable double percentage) {
		return service.featch(name, percentage);
	}

	@GetMapping("studentss")
	public ResponseStructure<List<StudentDto>> featchAll() {
		return service.featchAll();
	}

	@DeleteMapping("students/{id}")
	public ResponseStructure<StudentDto> delete(@PathVariable int id) {
		return service.delete(id);
	}
}
