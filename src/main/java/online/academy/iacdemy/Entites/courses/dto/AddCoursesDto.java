package online.academy.iacdemy.Entites.courses.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class AddCoursesDto {
	
	private String title;
	private String description;
	private BigDecimal price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AddCoursesDto [title=" + title + ", description=" + description + ", price=" + price + "]";
	}
	
	public AddCoursesDto(String title, String description, BigDecimal price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}

	
}
