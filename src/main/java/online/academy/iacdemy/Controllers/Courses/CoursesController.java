package online.academy.iacdemy.Controllers.Courses;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.academy.iacdemy.Entites.courses.dto.AddCoursesDto;
import online.academy.iacdemy.Entites.courses.dto.CoursesDto;
import online.academy.iacdemy.Service.CourseService;

@RestController
@RequestMapping(path = "/api/courses")
public class CoursesController {

	private CourseService courseService;
	public CoursesController(CourseService courseService) {
		this.courseService=courseService;
	}
	
	
	@GetMapping(path = "all")
	public ResponseEntity<List<CoursesDto>> getCourses(){
		return  this.courseService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CoursesDto> getCourse(@PathVariable long id){
		return this.courseService.findById(id);
	}
	
	@PostMapping(path = "save")
	public ResponseEntity<CoursesDto> createCours(@RequestBody AddCoursesDto addCoursesDto){
		return this.courseService.create(addCoursesDto);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<CoursesDto> updatedCours( @PathVariable long id , @RequestBody AddCoursesDto addCoursesDto){
		
		return this.courseService.update(id, addCoursesDto);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> removeCourse(@PathVariable long id){
		return this.courseService.delete(id);
	}
	

}
