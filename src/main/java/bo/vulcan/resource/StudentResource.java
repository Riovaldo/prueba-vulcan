package bo.vulcan.resource;

import bo.vulcan.dto.student.StudentDto;
import bo.vulcan.dto.student.StudentSaveDto;
import bo.vulcan.entity.Student;
import bo.vulcan.mapper.IStudentMapper;
import bo.vulcan.service.IStudentService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/student")
@RolesAllowed("admin")
public class StudentResource {

    @Inject
    IStudentService studentService;

    @Inject
    IStudentMapper studentMapper;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        StudentDto studentDto = this.studentMapper.toDto(this.studentService.findById(id));
        return Response.ok(studentDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<StudentDto> studentDtoList = this.studentMapper.toDto(this.studentService.findAll());
        return Response.ok(studentDtoList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(StudentSaveDto studentSaveDto) {
        Student student = this.studentMapper.toEntity(studentSaveDto);
        StudentDto studentDto = this.studentMapper.toDto(this.studentService.save(student));
        return Response
                .created(URI.create("/student/" + studentDto.getId()))
                .entity(studentDto).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, StudentSaveDto studentSaveDto) {
        Student student = this.studentService.findById(id);
        student.setName(studentSaveDto.getName());
        student.setAge(studentSaveDto.getAge());
        student.setGender(studentSaveDto.getGender());
        this.studentService.update(student);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) {
        this.studentService.deleteById(id);
        return Response.ok().build();
    }
}
