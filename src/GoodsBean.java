
public class GoodsBean {

	// メンバ変数
	private int gId;
	private String gName;
	private int gPraice;
	private String gContents;
	private boolean gFlag;

	// コンストラクタ
	public GoodsBean() {
		super();
	}


	// アクセッサメソッド
	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgPraice() {
		return gPraice;
	}

	public void setgPraice(int gPraice) {
		this.gPraice = gPraice;
	}

	public String getgContents() {
		return gContents;
	}

	public void setgContents(String gContents) {
		this.gContents = gContents;
	}

	public boolean isgFlag() {
		return gFlag;
	}

	public void setgFlag(boolean gFlag) {
		this.gFlag = gFlag;
	}

}
