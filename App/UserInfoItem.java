package hacs;

public class UserInfoItem {

	public enum UserType {
		STUDENT, INSTRUCTOR
	}

	String strUserName;
	UserType userType; // 0 : Student, 1: Instructor
	
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}