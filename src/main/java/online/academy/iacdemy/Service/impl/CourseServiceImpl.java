package online.academy.iacdemy.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import online.academy.iacdemy.Entites.courses.Courses;
import online.academy.iacdemy.Entites.courses.dto.AddCoursesDto;
import online.academy.iacdemy.Entites.courses.dto.CoursesDto;
import online.academy.iacdemy.Errors.CourseNotFound;
import online.academy.iacdemy.Repository.courses.CoursesRepository;
import online.academy.iacdemy.Service.CourseService;
import online.academy.iacdemy.mappers.CourseMapper;
import online.academy.iacdemy.mappers.CourseMapperImpl;


@Service
public class CourseServiceImpl  implements CourseService{

	private  final  CoursesRepository coursesRepository ;
	private final CourseMapper courseMapper = new CourseMapperImpl();
	
	@Autowired
	public CourseServiceImpl(CoursesRepository coursesRepository ) {
		this.coursesRepository=coursesRepository;
	}
	
	
	
	@Override
	public ResponseEntity<List<CoursesDto>> findAll() {
		List<Courses> courses= this.coursesRepository.findAll();
		List<CoursesDto> courseDtoList = courses.stream().map(courseMapper::CoursToCourseDto).collect(Collectors.toList());
		return  new ResponseEntity <>(courseDtoList,HttpStatus.OK);
		
		
	}

	@Override
	public ResponseEntity<CoursesDto> findById(long id) {
		Optional<Courses> course = this.coursesRepository.findById(id);
		if(course.isEmpty()) {
			
			throw new CourseNotFound("the cours with id:"+id+"not found");
		}
		
		CoursesDto coursesDto = courseMapper.CoursToCourseDto(course.get());
		return  new ResponseEntity <>(coursesDto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CoursesDto> create(AddCoursesDto addCoursesDto) {
		
	final	Courses courses = courseMapper.addCourseDtoToCours(addCoursesDto);
	final Courses createdCours =coursesRepository.save(courses);
	 CoursesDto coursesDto = courseMapper.CoursToCourseDto(createdCours);
	return new ResponseEntity<>(coursesDto,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<CoursesDto> update(long id, AddCoursesDto addCoursesDto) {
		
	  Optional<Courses> cours= 	this.coursesRepository.findById(id);
	  
	  if(cours.isEmpty()) {
		  throw new CourseNotFound("the cours with id:"+id+"not found");		  
	  }
	  Courses existingCours = cours.get();
	  existingCours.setTitle(addCoursesDto.getTitle());
	  existingCours.setDescription(addCoursesDto.getDescription());
	  existingCours.setPrice(addCoursesDto.getPrice());
	  Courses courseupdated=  this.coursesRepository.save(existingCours);
	  CoursesDto coursesDto = courseMapper.CoursToCourseDto(courseupdated);
	 return new ResponseEntity<>(coursesDto ,HttpStatus.OK);
	  
	 
	}

	@Override
	public ResponseEntity<String> delete(long id) {
	 boolean exsits= 	this.coursesRepository.existsById(id);
	 
	 if(!exsits) {
		  throw new CourseNotFound("the cours with id:"+id+"not found");		  
	 }
	   this.coursesRepository.deleteById(id);
	   return new ResponseEntity<>("removed is sucsse",HttpStatus.NO_CONTENT);
		
		
	}

}
