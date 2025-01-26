package bo.vulcan.dto.courseDetail;

import lombok.Data;

import java.util.List;

@Data
public class TotalStudentByGenderAndCourse {
    private Long id;
    private String name;
    private Integer maximumQuota;
    private List<TotalStudentByGender> genderList;
}
