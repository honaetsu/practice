
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		this.doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// loginOkに入力された検索キーワードを検索して戻すサーブレット
		// 遷移ページの指定
		String page = "loginOk.jsp";
		// Form情報（キーワード）の取り出し
		// エンコーディング方式の設定
		req.setCharacterEncoding("UTF-8");
		// kyeword取得
		String kyeword = req.getParameter("kyeword");
		// kyewordに何も入力されていない場合は空白を代入する
		if (kyeword == null) {
			kyeword = "";
		}
		// DAOの生成
		GoodsDAO gdao = new GoodsDAO("localhost", "root", "password");
		try {
			gdao.connect();
			// 商品検索する
			ArrayList<GoodsBean> glist = gdao.getGoods(kyeword);
			if(glist.size()<1){
				req.setAttribute("msg","検索キーワド「"+kyeword+"」に該当する商品はありません");
			}else{
			req.setAttribute("glist", glist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("error", "システムエラーです");
			page = "systemerror.jsp";
		} finally {
			try {
				gdao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// フォワード処理
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);

	}

}
