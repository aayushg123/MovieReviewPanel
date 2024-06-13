package com.moviereview;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Movie;
import com.model.Status;
import com.model.Users;

import dao.MovieDAOImpl;
import dao.UsersDAOImpl;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("moviereview")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    /** <------ Users DAO implementation --------> **/
    
    UsersDAOImpl userImpl = new UsersDAOImpl();
    
    @Path("users/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getAllUsers() throws SQLException {
		return userImpl.getAllUsers();
	}
    
    @Path("users/signUp")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status signUp(Users user) throws SQLException {
		return userImpl.signUp(user);
	}
    
    @Path("users/signIn")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int signIn(Users user) throws SQLException {
		return userImpl.signIn(user.getUserEmail(), user.getUserPassword());
	}
    
    @Path("users/viewProfile")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Users viewProfile(Users user) throws SQLException {
		return userImpl.viewProfile(user.getUserEmail());
	}
    
    @Path("users/updateProfile")
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int updateProfile(Users user) throws SQLException {
		return userImpl.updateProfile(user);
	}
    
    @Path("users/deleteProfile/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteTweet(@PathParam("id") int id) throws SQLException {
		return userImpl.deleteUsers(id);
	}
    
    /** <----- Users DAO implementation End ----> **/
    
    /** <------ Movies DAO implementation --------> **/
    
    MovieDAOImpl movieImpl = new MovieDAOImpl();

	@Path("movies/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies() throws SQLException {
		return movieImpl.getMovies();
	}

	@Path("movies/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status addMovie(Movie movie) throws SQLException {
		return movieImpl.addMovie(movie);
	}

	@Path("movies/update/{movieId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateMovie(@PathParam("movieId") int movieId, Movie movie) throws SQLException {
		movie.setMovieId(movieId);
		return movieImpl.updateMovie(movie);
	}

	@Path("movies/delete/{movieId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteMovie(@PathParam("movieId") int movieId) throws SQLException {

		return movieImpl.deleteMovie(movieId);
	}

	@Path("movies/get/{movieId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieById(@PathParam("movieId") int movieId) throws SQLException {

		return movieImpl.getMovieById(movieId);
	}
	
}
