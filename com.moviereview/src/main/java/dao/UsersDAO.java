package dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Status;
import com.model.Users;

public interface UsersDAO {
	List<Users> getAllUsers();

	Status signUp(Users user) throws SQLException;

	int signIn(String userEmail, String userPassword) throws SQLException;

	Users viewProfile(String userEmail) throws SQLException;

	int updateProfile(Users user) throws SQLException;

	Status deleteUsers(int userId) throws SQLException;
}
