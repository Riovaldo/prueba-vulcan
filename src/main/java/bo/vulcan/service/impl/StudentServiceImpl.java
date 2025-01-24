package bo.vulcan.service.impl;

import bo.vulcan.entity.Student;
import bo.vulcan.repository.Repository;
import bo.vulcan.service.IStudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("IStudentService")
public class StudentServiceImpl extends ServiceCRUD<Student> implements IStudentService {

    @Inject
    @Named("studentRepository")
    Repository<Student> studentRepository;
}
