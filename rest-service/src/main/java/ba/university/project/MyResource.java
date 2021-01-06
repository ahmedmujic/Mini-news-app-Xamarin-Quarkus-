package ba.university.project;

import ba.university.project.services.BlogService;
import ba.university.project.services.model.BlogsDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/hello")
public class MyResource {

    @Inject
    BlogService blogService;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Path("/blog")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createGame(BlogsDto news, @Context UriInfo uriInfo){

        BlogsDto blogsDto = blogService.addNews(news);
        if(blogsDto!=null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(blogsDto.getId()));
            return Response.created(uriBuilder.build()).entity(blogsDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/blog")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGifts()
    {
        List<BlogsDto> blogsDtos = blogService.allNews();
        if(blogsDtos == null ) {
            return Response.noContent().build();
        }
        return Response.ok(blogsDtos).build();
    }
}