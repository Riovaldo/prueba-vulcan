package bo.vulcan.service.impl;

import bo.vulcan.entity.Course;
import bo.vulcan.repository.Repository;
import bo.vulcan.service.ICourseService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("ICourseService")
public class CourseServiceImpl extends ServiceCRUD<Course> implements ICourseService {

    @Inject
    @Named("courseRepository")
    Repository<Course> courseRepository;
}
