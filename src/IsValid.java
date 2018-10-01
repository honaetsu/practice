public class IsValid {



	// コンストラクタ
	public IsValid() {

	}

	// ログイン可能かどうか評価するメソッド
	public boolean isValidTest(AccountBean aBean) {
		if(aBean==null){
			return false;
		}
		return true;
	}
}
