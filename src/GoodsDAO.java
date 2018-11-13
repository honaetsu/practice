import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDAO {
	// コネクションクラスのオブジェクト
	private Connection con;
	private String server;
	private String user;
	private String password;

	// コンストラクタ
	public GoodsDAO(String server, String user, String password) {
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

	// 商品検索
	public ArrayList<GoodsBean> getGoods(String keyword) throws SQLException {

		ResultSet res = null;
		PreparedStatement stmt = null;
		ArrayList<GoodsBean> list = new ArrayList<GoodsBean>();
		String sql = "SELECT * FROM goods WHERE g_name like ?";

		// goodsテーブルへSQL実行
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+keyword+"%");
			res = stmt.executeQuery();

			// レスポンスからオブジェクトの取得
			while (res.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setgId(res.getInt("g_id"));
				goods.setgName(res.getString("g_name"));
				goods.setgPraice(res.getInt("g_price"));
				goods.setgContents(res.getString("g_cotents"));
				goods.setgFlag(res.getBoolean("g_flag"));
				list.add(goods);
			}

		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}
}