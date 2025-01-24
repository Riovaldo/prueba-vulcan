package bo.vulcan.mapper;

import bo.vulcan.dto.course.CourseDto;
import bo.vulcan.dto.course.CourseSaveDto;
import bo.vulcan.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ICourseMapper {
    CourseDto toDto(Course course);
    List<CourseDto> toDto(List<Course> courseList);
    Course toEntity(CourseSaveDto courseSaveDto);
}
