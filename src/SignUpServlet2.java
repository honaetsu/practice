
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
@WebServlet("/SignUp2")
public class SignUpServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet2() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 遷移ページの指定
		String page = "loginOk.jsp";
		// Form情報の取り出し
		// エンコーディング方式の設定
		req.setCharacterEncoding("UTF-8");
		// Idの取得
		String pId = req.getParameter("pId");
		String pass = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));

		// DAOの生成
		AccountDAO dao = new AccountDAO("localhost", "root", "password");
		// DBにUPDATEする
		try {
			// DB接続
			dao.connect();
			// 登録してメソッドの呼び出し
			AccountBean ado=dao.acountUpdate(pId,pass,mail,name,age);


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
