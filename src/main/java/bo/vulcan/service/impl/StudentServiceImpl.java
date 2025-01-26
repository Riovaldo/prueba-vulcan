package bo.vulcan.service.impl;

import bo.vulcan.dto.courseDetail.TotalStudentByGender;
import bo.vulcan.entity.Student;
import bo.vulcan.repository.StudentRepository;
import bo.vulcan.service.IStudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named("IStudentService")
public class StudentServiceImpl extends ServiceCRUD<Student> implements IStudentService {

    @Inject
    @Named("studentRepository")
    StudentRepository studentRepository;

    @Override
    public List<TotalStudentByGender> getTotalStudentGroupByGender() {
        return this.studentRepository.listStudentsGroupByGender();
    }

    @Override
    public List<TotalStudentByGender> getTotalStudentByCourseGroupByGender(Long courseId) {
        return this.studentRepository.listStudentsByCourseGroupByGender(courseId);
    }
}
