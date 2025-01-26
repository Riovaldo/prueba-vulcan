package bo.vulcan.repository;

import bo.vulcan.dto.courseDetail.CourseCapacityPercentage;
import bo.vulcan.dto.courseDetail.TotalStudentByCourse;
import bo.vulcan.entity.Course;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named("courseRepository")
public class CourseRepository implements Repository<Course> {

    public List<TotalStudentByCourse> listCoursesWithTotalStudents() {
        return this.find("select c.id, c.name, c.maximumQuota, COUNT(s.id) " +
                        "from Course c " +
                        "left join Student s on(c.id = s.course.id) group by c.id")
                .project(TotalStudentByCourse.class).list();
    }

    public List<CourseCapacityPercentage> listCoursesWithCapacityPercentage() {
        return this.find("select c.id, c.name, c.maximumQuota, " +
                        "CASE WHEN COUNT(s.id) > 0 THEN COUNT(s.id) * 100 / c.maximumQuota ELSE 0 END " +
                        "from Course c " +
                        "left join Student s on(c.id = s.course.id) group by c.id")
                .project(CourseCapacityPercentage.class).list();
    }
}
