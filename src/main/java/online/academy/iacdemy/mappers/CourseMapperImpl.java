package online.academy.iacdemy.mappers;

import online.academy.iacdemy.Entites.courses.Courses;
import online.academy.iacdemy.Entites.courses.dto.AddCoursesDto;
import online.academy.iacdemy.Entites.courses.dto.CoursesDto;

public class CourseMapperImpl implements CourseMapper {

	@Override
	public Courses addCourseDtoToCours(AddCoursesDto addCoursesDto) {
	   
		Courses courses = new Courses(null, null, null);
		courses.setTitle(addCoursesDto.getTitle());
		courses.setDescription(addCoursesDto.getDescription());
		courses.setPrice(addCoursesDto.getPrice());
		return courses;
	}

	@Override
	public CoursesDto CoursToCourseDto(Courses courses) {
		return new CoursesDto(courses);
	}

}
