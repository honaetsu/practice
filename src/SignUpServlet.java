
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 遷移ページの指定
		String page = "signup2.jsp";
		// Form情報の取り出し
		// エンコーディング方式の設定
		req.setCharacterEncoding("UTF-8");
		// Idの取得
		String pId = req.getParameter("pId");
		// DAOの生成
		AccountDAO dao = new AccountDAO("localhost", "root", "password");
		// 新規作成可能か確認する
		try {
			// DB接続
			dao.connect();
			// pIdが使えるか確認する。falseならsinupページに戻る
			if (!(dao.chUserId(pId))) {
				page = "signup.jsp";
				// エラーメッセージ
				req.setAttribute("emsg", "はすでに利用されています");
			}
		} catch (SQLException e) {
			System.out.println("以下printStackTrace()");
			e.printStackTrace();
			req.setAttribute("error", "システムエラーです");
			page = "systemerror.jsp";
		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// pIdをreqにセット
		req.setAttribute("pId", pId);
		// フォワード処理
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);

	}

}
