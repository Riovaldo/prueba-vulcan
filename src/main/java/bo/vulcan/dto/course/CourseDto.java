package bo.vulcan.dto.course;

import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String name;
    private Integer maximumQuota;

}
