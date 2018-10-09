import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


	public void connect() throws SQLException {
		String url = "jdbc:mysql://" + server + ":3306/practice?characterEncoding=UTF-8&serverTimezone=JST";
		con = DriverManager.getConnection(url, user, password);
	}

	// 接続のクローズ
	public void close() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	// ログイン確認
	public AccountBean getAccount(String pId,String pPass) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet res = null;
		AccountBean aBean = null;
		// テーブルからID検索し、結果からPASSを検索する★★★
		String sql = "SELECT * FROM account WHERE USER_ID =? AND PASS=? ";

		try {
			// ステートメントの作成
			stmt = con.prepareStatement(sql);
			// SQL実行,結果をresに
			stmt.setString(1,pId);
			stmt.setString(2,pPass);
			res = stmt.executeQuery();
			// 結果をアカウントオブジェクトにセットする
			if(res.next()){
				aBean = new AccountBean();
				aBean.setUserId(res.getInt("USER_ID"));
				aBean.setPass(res.getString("PASS"));
				aBean.setMail(res.getString("MAIL"));
				aBean.setName(res.getString("NAME"));
				aBean.setAge(res.getInt("AGE"));
				System.out.println(aBean.getName());
			}

		}finally{
			if(res != null){
				res.close();
			}
			if(stmt !=null){
				stmt.close();
			}
		}

		return aBean;
	}
	//
}
