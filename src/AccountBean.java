
import java.io.Serializable;
public class AccountBean implements Serializable{

	// メンバ
	private int userId;
	private String pass;
	private String mail;
	private String name;

	public AccountBean() {
		super();
	}

	// アクセッサメソッド
	private int age;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
