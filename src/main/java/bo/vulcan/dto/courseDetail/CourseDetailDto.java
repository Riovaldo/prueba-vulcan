package bo.vulcan.dto.courseDetail;

import lombok.Data;

import java.util.List;

@Data
public class CourseDetailDto {
    private List<TotalStudentByCourse> courseList;
    private List<TotalStudentByGender> genderList;
    private List<TotalStudentByGenderAndCourse> courseAndGenderList;
    private List<CourseCapacityPercentage> courseCapacityPercentageList;
}
