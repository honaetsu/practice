import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountDAO {
	private Connection con;
	private String server;
	private String user;
	private String password;

	// コンストラクタ
	public AccountDAO(String server, String user, String password) {
		this.server = server;
		this.user = user;
		this.password = password;
	}

	// 接続
	public void connect() throws SQLException {
		String url = "jdbc:mysql://" + server + "3306/test?characterEncoding=UTF-8&serverTimezone=JST";
		con=DriverManager.getConnection(url,user,password);
	}
	// 接続のクローズ
	public void close() throws SQLException{
		if(con !=null ){
			con.close();
		}
	}
	//ログイン確認
//	SELECT * FROM `account` WHERE `PASS`=(
//			SELECT `PASS` FROM `account` WHERE `USER_ID`='0001');
}
