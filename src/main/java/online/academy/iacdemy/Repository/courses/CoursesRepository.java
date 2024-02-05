package online.academy.iacdemy.Repository.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import online.academy.iacdemy.Entites.courses.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
