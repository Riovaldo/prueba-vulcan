package bo.vulcan.repository;

import bo.vulcan.dto.courseDetail.TotalStudentByGender;
import bo.vulcan.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named("studentRepository")
public class StudentRepository implements Repository<Student> {

    public List<TotalStudentByGender> listStudentsGroupByGender() {
        return this.find("select s.gender, COUNT(s.gender) from Student s group by s.gender")
                .project(TotalStudentByGender.class).list();
    }

    public List<TotalStudentByGender> listStudentsByCourseGroupByGender(Long courseId) {
        return this.find("select s.gender, COUNT(s.gender) from Student s " +
                        "where s.course.id = ?1 group by s.gender", courseId)
                .project(TotalStudentByGender.class).list();
    }
}
