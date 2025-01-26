package bo.vulcan.mapper;

import bo.vulcan.dto.student.StudentDto;
import bo.vulcan.dto.student.StudentSaveDto;
import bo.vulcan.entity.Course;
import bo.vulcan.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IStudentMapper {
    StudentDto toDto(Student student);
    List<StudentDto> toDto(List<Student> studentList);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "courseId", target = "course", qualifiedByName = "toCourse")
    Student toEntity(StudentSaveDto studentSaveDto);

    @Named("toCourse")
    default Course toCourse(Long courseId) {
        return Course.builder().id(courseId).build();
    }
}
