package online.academy.iacdemy.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import online.academy.iacdemy.Entites.courses.dto.AddCoursesDto;
import online.academy.iacdemy.Entites.courses.dto.CoursesDto;

public interface CourseService {
	
	
	ResponseEntity<List<CoursesDto>> findAll();
	ResponseEntity<CoursesDto> findById(long id);
	ResponseEntity<CoursesDto> create(AddCoursesDto addCoursesDto);
	ResponseEntity<CoursesDto> update(long id, AddCoursesDto addCoursesDto);
	ResponseEntity<String> delete(long id);

}