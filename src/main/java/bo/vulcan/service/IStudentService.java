package bo.vulcan.service;

import bo.vulcan.dto.courseDetail.TotalStudentByGender;
import bo.vulcan.entity.Student;

import java.util.List;

public interface IStudentService extends IServiceCRUD<Student> {
    List<TotalStudentByGender> getTotalStudentGroupByGender();
    List<TotalStudentByGender> getTotalStudentByCourseGroupByGender(Long courseId);
}
