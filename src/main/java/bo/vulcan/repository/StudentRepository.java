package bo.vulcan.repository;

import bo.vulcan.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("studentRepository")
public class StudentRepository implements Repository<Student> {
}
