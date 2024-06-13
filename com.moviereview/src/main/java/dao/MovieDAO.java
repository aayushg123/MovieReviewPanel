package dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Movie;
import com.model.Status;



public interface MovieDAO {
	List<Movie> getMovies();

	Status addMovie(Movie movie) throws SQLException;

	Status updateMovie(Movie movie);

	Status deleteMovie(int movieId);
	Movie getMovieById(int movieId);
	
}
