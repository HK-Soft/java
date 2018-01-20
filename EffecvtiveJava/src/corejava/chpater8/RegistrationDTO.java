package corejava.chpater8;

import corejava.chpater8.annotations.IsUnique;
import corejava.chpater8.annotations.Password;

//
public class RegistrationDTO {

	@IsUnique(columnName = "username", tableName = "tb_users")
	public String username;

	@Password(minSize = 4, maxSize = 12, mustHaveNubmers = true, mustHaveUppercase = true)
	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
