package bo.vulcan.utils.handler;

import bo.vulcan.utils.exception.BadRequestException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    public record BadRequestMessage(Integer code, String message) {}

    @Override
    public Response toResponse(BadRequestException e) {
        var error = new BadRequestMessage(Response.Status.BAD_REQUEST.getStatusCode(), e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
