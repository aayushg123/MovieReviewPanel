package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Movie;
import com.model.Status;





public class MovieDAOImpl implements MovieDAO {
	private Connection connection;

	public MovieDAOImpl() {
		// TODO Load the DBUtil class
		connection = DBUtil.getConnection();
		System.out.println("Tweet impl's connection= " + connection.hashCode());
	}

	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT * FROM movies";

		try (PreparedStatement pst = connection.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				String movieName = rs.getString("movie_name");
				String lang = rs.getString("lang");
				int yor = rs.getInt("yor");
				String genre = rs.getString("genre");
				String trailerLink = rs.getString("trailer_link");
				int movieId = rs.getInt("movie_id");
				double rating=rs.getDouble("AGGREGATED_RATING");
				String poster=rs.getString("SMALL_POSTER");
				String desc=rs.getString("DESC");
				String actors=rs.getString("actors");
				String director=rs.getString("director");
				String production=rs.getString("production");
				String writer=rs.getString("writer");

				movies.add(new Movie(movieId, movieName, lang, yor, genre, trailerLink,poster,desc,actors,director,production,writer,rating));
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}

		return movies;
	}

	@Override
	public Status addMovie(Movie movie) {
		String sql = "INSERT INTO movies (movie_name, lang, yor, genre, trailer_link,small_poster,desc,actors,director,production,writer) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)";
		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, movie.getMovieName());
			pst.setString(2, movie.getMovieLanguage());
			pst.setInt(3, movie.getMovieYear());
			pst.setString(4, movie.getMovieGenre());
			pst.setString(5, movie.getTrailerUrl());
			pst.setString(6, movie.getSmallPoster());
			pst.setString(7, movie.getDesc());
			pst.setString(8,movie.getActors());
			pst.setString(9, movie.getDirector());
			pst.setString(10,movie.getProduction());
			pst.setString(11, movie.getWriter());

			int res = pst.executeUpdate();

			return new Status(res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return new Status(false);
		}
	}

	@Override
	public Status updateMovie(Movie movie) {
		//

		String sql = "UPDATE movies SET movie_name =?, desc=?, lang = ?, yor = ?, genre = ?, trailer_link = ?, writer= ?, director= ?,actors= ?,production=?,small_poster=? WHERE movie_id = ?";
		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, movie.getMovieName());
			pst.setString(2, movie.getDesc());
			pst.setString(3, movie.getMovieLanguage());
			pst.setInt(4, movie.getMovieYear());
			pst.setString(5, movie.getMovieGenre());
			pst.setString(6, movie.getTrailerUrl());
			pst.setString(7, movie.getWriter());
			pst.setString(8, movie.getDirector());
			pst.setString(9, movie.getActors());
			pst.setString(10, movie.getProduction());
			pst.setString(11, movie.getSmallPoster());
			pst.setInt(12, movie.getMovieId());

			int res = pst.executeUpdate();

			return new Status(res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return new Status(false);
		}
	}

	@Override
	public Status deleteMovie(int movieId) {
		String sql = "DELETE FROM movies WHERE movie_id = ?";

		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, movieId);

			int res = pst.executeUpdate();

			return new Status(res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return new Status(false);
		}
	}

	@Override
	public Movie getMovieById(int movieId) {
		String sql = "SELECT * FROM movies WHERE movie_id = ?";

		try (PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, movieId);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					String movieName = rs.getString("movie_name");
					String lang = rs.getString("lang");
					int yor = rs.getInt("yor");
					String genre = rs.getString("genre");
					String trailerLink = rs.getString("trailer_link");
					double rating=rs.getDouble("AGGREGATED_RATING");
					String poster=rs.getString("SMALL_POSTER");
					String desc=rs.getString("DESC");
					String actors=rs.getString("actors");
					String director=rs.getString("director");
					String production=rs.getString("production");
					String writer=rs.getString("writer");

					return new Movie(movieId, movieName, lang, yor, genre, trailerLink,poster,desc,actors,director,production,writer,rating);

					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}