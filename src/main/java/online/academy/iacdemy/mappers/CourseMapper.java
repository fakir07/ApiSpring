package online.academy.iacdemy.mappers;

import online.academy.iacdemy.Entites.courses.Courses;
import online.academy.iacdemy.Entites.courses.dto.AddCoursesDto;
import online.academy.iacdemy.Entites.courses.dto.CoursesDto;

public interface CourseMapper {
	
	Courses     addCourseDtoToCours (AddCoursesDto addCoursesDto);
	CoursesDto  CoursToCourseDto (Courses courses);
}
