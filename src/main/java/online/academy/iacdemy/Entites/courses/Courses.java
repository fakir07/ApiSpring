package online.academy.iacdemy.Entites.courses;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.academy.iacdemy.Entites.BaseEntity;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Courses extends BaseEntity implements Serializable {

   

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @NotBlank(message = "title  may not be blank")
    @Column(name = "title", length = 100)
    @Size(max = 100, message = "title 100 letter")
    private String title;

    @NotNull
    @NotBlank(message = "description  may not be blank")
    @Column(name = "description", length = 1000)
    @Size(max = 1000, message = "description 100 letter")
    private String description;

    @NotNull(message = "price is not null")
    @DecimalMin("1.00")
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
		return "Courses [title=" + title + ", description=" + description + ", price=" + price + "]";
	}

	
	public Courses(String title, String description, BigDecimal price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}
	
	public Courses() {
	    // Default constructor
	}
	

    
	

}
