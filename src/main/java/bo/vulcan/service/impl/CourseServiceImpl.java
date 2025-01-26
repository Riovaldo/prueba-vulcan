package bo.vulcan.service.impl;

import bo.vulcan.dto.courseDetail.CourseDetailDto;
import bo.vulcan.dto.courseDetail.TotalStudentByGenderAndCourse;
import bo.vulcan.entity.Course;
import bo.vulcan.mapper.ICourseMapper;
import bo.vulcan.repository.CourseRepository;
import bo.vulcan.service.ICourseService;
import bo.vulcan.service.IStudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named("ICourseService")
public class CourseServiceImpl extends ServiceCRUD<Course> implements ICourseService {

    @Inject
    @Named("courseRepository")
    CourseRepository courseRepository;

    @Inject
    IStudentService studentService;

    @Inject
    ICourseMapper courseMapper;

    @Override
    public CourseDetailDto getCourseListWithDetails() {
        CourseDetailDto courseDetailDto = new CourseDetailDto();
        courseDetailDto.setCourseList(this.courseRepository.listCoursesWithTotalStudents());
        courseDetailDto.setGenderList(this.studentService.getTotalStudentGroupByGender());
        courseDetailDto.setCourseAndGenderList(this.getTotalStudentGroupByGenderAndCourse());
        courseDetailDto.setCourseCapacityPercentageList(this.courseRepository.listCoursesWithCapacityPercentage());
        return courseDetailDto;
    }

    private List<TotalStudentByGenderAndCourse> getTotalStudentGroupByGenderAndCourse() {
        List<TotalStudentByGenderAndCourse> courseList = this.courseMapper
                .toDtoTotalStudentByGenderAndCourse(this.findAll());
        for (TotalStudentByGenderAndCourse course : courseList) {
            course.setGenderList(this.studentService.getTotalStudentByCourseGroupByGender(course.getId()));
        }
        return courseList;
    }
}
