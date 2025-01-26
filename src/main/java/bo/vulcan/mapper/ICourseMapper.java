package bo.vulcan.mapper;

import bo.vulcan.dto.course.CourseDto;
import bo.vulcan.dto.course.CourseSaveDto;
import bo.vulcan.dto.courseDetail.TotalStudentByGenderAndCourse;
import bo.vulcan.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ICourseMapper {

    CourseDto toDto(Course course);
    List<CourseDto> toDto(List<Course> courseList);

    @Mapping(target = "id", ignore = true)
    Course toEntity(CourseSaveDto courseSaveDto);

    @Mapping(target = "genderList", ignore = true)
    TotalStudentByGenderAndCourse toDtoTotalStudentByGenderAndCourse(Course course);
    List<TotalStudentByGenderAndCourse> toDtoTotalStudentByGenderAndCourse(List<Course> courseList);
}
