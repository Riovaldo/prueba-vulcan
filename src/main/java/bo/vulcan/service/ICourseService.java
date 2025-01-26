package bo.vulcan.service;

import bo.vulcan.dto.courseDetail.CourseDetailDto;
import bo.vulcan.entity.Course;

public interface ICourseService extends IServiceCRUD<Course> {
    CourseDetailDto getCourseListWithDetails();
}
