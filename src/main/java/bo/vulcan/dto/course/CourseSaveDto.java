package bo.vulcan.dto.course;

import lombok.Data;

@Data
public class CourseSaveDto {
    private String name;
    private Integer maximumQuota;
}
