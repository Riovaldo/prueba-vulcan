package bo.vulcan.resource;

import bo.vulcan.dto.course.CourseDto;
import bo.vulcan.dto.course.CourseSaveDto;
import bo.vulcan.entity.Course;
import bo.vulcan.mapper.ICourseMapper;
import bo.vulcan.service.ICourseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/api/course")
@RolesAllowed("admin")
public class CourseResource {

    @Inject
    ICourseService courseService;

    @Inject
    ICourseMapper courseMapper;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        CourseDto courseDto = this.courseMapper.toDto(this.courseService.findById(id));
        return Response.ok(courseDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CourseDto> courseDtoList = this.courseMapper.toDto(this.courseService.findAll());
        return Response.ok(courseDtoList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(CourseSaveDto courseSaveDto) {
        Course course = this.courseMapper.toEntity(courseSaveDto);
        CourseDto courseDto = this.courseMapper.toDto(this.courseService.save(course));
        return Response
                .created(URI.create("/course/" + courseDto.getId()))
                .entity(courseDto).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, CourseSaveDto courseSaveDto) {
        Course course = this.courseService.findById(id);
        course.setName(courseSaveDto.getName());
        course.setMaximumQuota(courseSaveDto.getMaximumQuota());
        this.courseService.update(course);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) {
        this.courseService.deleteById(id);
        return Response.ok().build();
    }

    @GET
    @Path("/more-details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWithDetails() {
        return Response.ok(this.courseService.getCourseListWithDetails()).build();
    }
}
