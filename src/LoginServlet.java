
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());

		// 遷移ページの指定
		String page = "loginOk.jsp";
		// Form情報の取り出し
		// エンコーディング方式の設定
		req.setCharacterEncoding("utf-8");
		// Idの取得
		String pId = req.getParameter("pId");
		// パスワードの取得
		String pPass = req.getParameter("pPass");
		// DAOの生成
		AccountDAO dao = new AccountDAO("localhost", "loot", "password");
		try {
			// DB接続
			dao.connect();
			// ログイン可能か確認する
			// IsValidクラスのnew
			IsValid ivd = new IsValid(pId, pPass);
			boolean test = ivd.isValidTest(dao);
			if (test) {
				// ログイン成功時の画面遷移先ページの指定
				page = "loginOk.jsp";
				// リクエストオブジェクトに

			} else {

			}
		} catch (SQLException e) {

		}

		// フォワード処理
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);

	}

}
