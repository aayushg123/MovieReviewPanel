package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Status;
import com.model.Users;

public class UsersDAOImpl implements UsersDAO {
	private Connection connection;

    public UsersDAOImpl() {
        this.connection = DBUtil.getConnection();
    }

	@Override
	public Status signUp(Users user) throws SQLException {
		// TODO Implemented Signup functionality.
		
		Status s = new Status();
		int res = -1;
    	String query = "INSERT INTO USERS (user_name, user_email, user_password) VALUES (?, ?, ?)";


        try (PreparedStatement pst = connection.prepareStatement(query)) {
        	
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserEmail());
            pst.setString(3, user.getUserPassword());
           
            res = pst.executeUpdate();
            System.out.println("User registration successful!");
            s.setQueryStatus((res == 1) ? true : false);
            return s;
            
        }
	}

	@Override
	public int signIn(String userEmail, String userPassword) throws SQLException {
		// TODO signIn functionality
		String query = "SELECT * FROM USERS WHERE user_email = ? AND user_password = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, userEmail);
            pst.setString(2, userPassword);

            try (ResultSet rs = pst.executeQuery()) {
            	if (rs.next()) {
                    return rs.getInt("user_id");
                } else {
                    return -1; 
                }
            }
        }
	}

	@Override
	public Users viewProfile(String userEmail) throws SQLException {
		// TODO Viewing user Profile is possible.
		String query = "SELECT * FROM USERS WHERE user_email = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, userEmail);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Users user = new Users(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("user_email"),rs.getString("user_password"));
        
                    return user;
                }
                return null;
            }
        }
	}

	@Override
	public int updateProfile(Users user) throws SQLException {
		// TODO Update Profile Functionality
		String query = "UPDATE USERS SET user_name=?, user_email=?, user_password=? WHERE user_id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserEmail());
            pst.setString(3, user.getUserPassword());
            pst.setInt(4, user.getUserId());

            int res = pst.executeUpdate();
           
            return res;
        }
	}

	@Override
	public Status deleteUsers(int userId) throws SQLException {
		// TODO Deleting inactive or voluntary deletion of profile in users
		String sql = "delete from users where user_id=?";
		PreparedStatement pst = connection.prepareStatement(sql);
			
		pst.setInt(1,userId );
		int res = pst.executeUpdate();
		
		Status s=new Status();
		if(res!=0)
		{
			s.setQueryStatus(true);
			return s;
		}
		s.setQueryStatus(false);
		return s;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> users = new ArrayList<>();
		String sql = "SELECT * FROM users";

		try (PreparedStatement pst = connection.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPassword = rs.getString("user_password");
				users.add(new Users(userId,userName,userEmail,userPassword));
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}

		return users;
		
	}
}
