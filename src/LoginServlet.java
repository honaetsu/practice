
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
		String page = "error.jsp";
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
			AccountBean aBean = dao.getAccount(pId,pPass);
			// ログイン可能か判断する
			IsValid isv = new IsValid();
			Boolean test = isv.isValidTest(aBean);
			if (test) {
				// trueのとき、ページ設定およびAccountオブジェクトをreqにセット
				page = "loginOk.jsp";
				req.setAttribute("accountB", aBean);
			} else {
				// falseのとき
				// リクエストオブジェクトにエラーメッセージを設定
				page="login.jsp";
				req.setAttribute("error", "ユーザーIDまたはパスワードが正しくありません");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		// フォワード処理
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);

	}

}
