import java.sql.Connection;
import java.sql.SQLException;

public class AccoundDao {
	private Connection con;
	private String server;
	private String user;
	private String password;

	public AccoundDao(String server, String user, String password) {
		this.server = server;
		this.user = user;
		this.password = password;
	}

	public void connect() throws SQLException{
		String url="jdbc:mysql://"+server+"3306/";
	}



}
