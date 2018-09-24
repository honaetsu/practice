import java.sql.SQLException;

public class IsValid {

	String pId;// メンバID
	String pPass;// メンバPass

	// コンストラクタ
	public IsValid(String pId, String pPass) {
		this.pId = pId;
		this.pPass = pPass;
	}

	// ログイン可能かどうか評価するメソッド
	public boolean isValidTest(AccountDAO dao) {
		try{
		dao.connect();



		}catch(SQLException e){

		}
		return false;
	}
}
