package dao.interfaces;
import java.sql.SQLException;
import utility.classes.*;
public interface UserDao extends Dao<User>{
	int checkCredentials(User user) throws SQLException;
	User getUsername(String uname) throws SQLException;
}
