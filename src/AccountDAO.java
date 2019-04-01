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
	public AccountBean getAccount(String pId, String pPass) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet res = null;
		AccountBean aBean = null;
		// テーブルからID検索し、結果からPASSを検索する★★★
		String sql = "SELECT * FROM account WHERE USER_ID =? AND PASS=? ";

		try {
			// ステートメントの作成
			stmt = con.prepareStatement(sql);
			// SQL実行,結果をresに
			stmt.setString(1, pId);
			stmt.setString(2, pPass);
			res = stmt.executeQuery();
			// 結果をアカウントオブジェクトにセットする
			if (res.next()) {
				aBean = new AccountBean();
				aBean.setUserId(res.getInt("USER_ID"));
				aBean.setPass(res.getString("PASS"));
				aBean.setMail(res.getString("MAIL"));
				aBean.setName(res.getString("NAME"));
				aBean.setAge(res.getInt("AGE"));
				System.out.println(aBean.getName());
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return aBean;
	}

	// ユーザーID確認。resにオブジェクトが入ってなければtrueを返す
	public boolean chUserId(String pId) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet res = null;
		boolean ans = true;
		String sql = "SELECT * FROM account WHERE USER_ID =?";
		// テーブルからID検索。
		try {
			// ステートメントの作成
			stmt = con.prepareStatement(sql);
			// SQL実行,結果をresに
			stmt.setString(1, pId);
			res = stmt.executeQuery();
			if (res.next()) {
				ans = false;
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return ans;
	}

	// DBをアップデートする
	public AccountBean acountUpdate(String pId, String pass, String mail, String name, int age) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet res = null;
		String sql = "INSERT INTO account VALUES(?,?,?,?)";
		AccountBean aBean = null;
		String sql2 = "SELECT * FROM account WHERE USER_ID =?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pId);
			stmt.setString(2, pass);
			stmt.setString(3, mail);
			stmt.setString(4, name);
			stmt.setInt(5, age);
			stmt.executeQuery();
			stmt.close();

			stmt = con.prepareStatement(sql2);
			// SQL実行,結果をresに
			stmt.setString(1, pId);
			res = stmt.executeQuery();
			// 結果をアカウントオブジェクトにセットする
			if (res.next()) {
				aBean = new AccountBean();
				aBean.setUserId(res.getInt("USER_ID"));
				aBean.setPass(res.getString("PASS"));
				aBean.setMail(res.getString("MAIL"));
				aBean.setName(res.getString("NAME"));
				aBean.setAge(res.getInt("AGE"));
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return aBean;
	}
}
