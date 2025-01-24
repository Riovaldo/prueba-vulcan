package bo.vulcan.dto.student;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
}
