package bo.vulcan.repository;

import bo.vulcan.entity.Course;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("courseRepository")
public class CourseRepository implements Repository<Course> {
}
