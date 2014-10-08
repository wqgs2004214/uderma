package u.derma.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean {
	@NotEmpty(message="登录用户不能为空")
	private String name;
	
	@NotEmpty(message="登录密码不能为空")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
