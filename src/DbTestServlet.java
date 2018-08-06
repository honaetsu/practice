
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DbTest")
/**
 * Servlet implementation class DbTestServlet
 */
public class DbTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DbTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=JST", "root", "password");

			// ステートメント生成
			Statement stmt = con.createStatement();

			// SQLを実行
			String sqlStr = "SELECT * FROM test";
			ResultSet rs = stmt.executeQuery(sqlStr);

			// 結果行をループ
			while (rs.next()) {
				// レコードの値
				int id = rs.getInt("ID");
				String name = rs.getString("name");
				int a_code = rs.getInt("a-code");
				int b_code = rs.getInt("b-code");

				// 表示
				System.out.println("ID：" + id);
				System.out.println("name：" + name);
				System.out.println("a-code：" + a_code);
				System.out.println("b-code：" + b_code);
				System.out.println();

			}

			// 接続を閉じる
			rs.close();
			stmt.close();
			con.close();

			// } catch (ClassNotFoundException e) {
			// System.out.println("ドライバを読み込めませんでした " + e);
		} catch (SQLException e) {
			System.out.println("データベース接続エラー" + e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
