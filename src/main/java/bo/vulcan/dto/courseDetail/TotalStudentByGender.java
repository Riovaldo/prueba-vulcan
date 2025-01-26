package bo.vulcan.dto.courseDetail;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RegisterForReflection
public class TotalStudentByGender {
    private String gender;
    private Long totalStudents;
}
