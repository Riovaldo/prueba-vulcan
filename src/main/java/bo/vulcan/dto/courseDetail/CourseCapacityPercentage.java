package bo.vulcan.dto.courseDetail;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RegisterForReflection
public class CourseCapacityPercentage {
    private Long id;
    private String name;
    private Integer maximumQuota;
    private Long courseCapacityPercentage;
}
