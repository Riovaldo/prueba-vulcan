package bo.vulcan.utils.handler;

import bo.vulcan.utils.exception.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public record NotFoundMessage(Integer code, String message) {}

    @Override
    public Response toResponse(NotFoundException e) {
        var error = new NotFoundMessage(Response.Status.NOT_FOUND.getStatusCode(), e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
