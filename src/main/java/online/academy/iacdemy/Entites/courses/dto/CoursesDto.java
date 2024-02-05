package online.academy.iacdemy.Entites.courses.dto;

import java.math.BigDecimal;

import online.academy.iacdemy.Entites.courses.Courses;

public class CoursesDto {
	
	private final Courses courses;
	
	
	public CoursesDto(Courses courses) {
	   this.courses=courses;
	}
	
	public String getTitle() {
	return	this.courses.getTitle();
	}
	
	public String getDescription() {
		return this.courses.getDescription();
	}
	
	public BigDecimal getPrice()
	{
		return this.courses.getPrice();
	}


	
	
	

}
