package bo.vulcan.mapper;

import bo.vulcan.dto.student.StudentDto;
import bo.vulcan.dto.student.StudentSaveDto;
import bo.vulcan.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IStudentMapper {
    StudentDto toDto(Student student);
    List<StudentDto> toDto(List<Student> studentList);
    Student toEntity(StudentSaveDto studentSaveDto);
}
