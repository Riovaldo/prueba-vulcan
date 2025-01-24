package bo.vulcan.dto.student;

import lombok.Data;

@Data
public class StudentSaveDto {
    private String name;
    private Integer age;
    private String gender;
    private Long courseId;
}
