import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String url = "jdbc:mysql://" + server + "3306/practice?characterEncoding=UTF-8&serverTimezone=JST";
		con = DriverManager.getConnection(url, user, password);
	}

	// 接続のクローズ
	public void close() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	// ログイン確認
	public AccountBean getAccount(String pId) throws SQLException {
		Statement stmt = null;
		ResultSet res = null;
		AccountBean aBean = null;
		// テーブルからID検索し、結果からPASSを検索する
		String sql = "SELECT * FROM account WHERE PASS=(SELECT PASS FROM account WHERE USER_ID =" + pId + ")";
		aBean = new AccountBean();
		try {
			// ステートメントの作成
			stmt = con.createStatement();
			// SQL実行,結果をresに
			res = stmt.executeQuery(sql);
			// 結果をアカウントオブジェクトにセットする
			if(res.next()){
				aBean.setUserId(res.getInt("USER_ID"));
				aBean.setPass(res.getString("PASS"));
				aBean.setMail(res.getString("MAIL"));
				aBean.setName(res.getString("NAME"));
				aBean.setAge(res.getInt("AGE"));

			}
			// ログイン可能か判断する
			IsValid isv=new IsValid();
			Boolean test=isv.isValidTest(aBean);
//＞ココマデIsValidクラスを先に完成させること
			// カーソルをResultSet オブジェクト内の最終行に移動
			res.last();
			// 現在の行の番号を取得
			int count = res.getRow();
			// sentou ni

		} catch (SQLException e) {

		}
		return aBean;
	}
	//
}
