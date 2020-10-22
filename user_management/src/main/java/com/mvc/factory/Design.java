package com.mvc.factory;

public class Design {

	public final static String ERROR = "<b>Please, Enter Correct data...</b>" + "	<br>" + "	<br>"
			+ "	<a href=\"login.jsp\">Login...</a>" + "	<br>" + "	<br>"
			+ "	<a href=\"home.jsp\">Create Account</a>";

	public final static String LOGIN = "<b>You are already logged in.</b>";

	public final static String ERROR_USER_ID = "UserId is only contain [0-9] and max length : 4";

	public final static String ERROR_MOBILE = "Mobile number only contain [0-9] and max length : 10";

	public final static String ERROR_EMAIL = "Please enter valid email.";

	public final static String SESSION_EXPIRED = "<b>Your Session Expired...</b>";

	public final static String ERROR_LOGIN = "<b>You are not logged in so, <a href='login.jsp'>click Here</a> to login and then Update Account</b>";

	public final static String ERROR_ACCOUNT = "<div align='center'><b>Account not found..</b><br><br><a href='home.jsp'>Create Account</a></div>";

	public final static String ACCOUNT_CREATE = "<b><a href='http://localhost:8002/login.jsp'>cleck Here</a> to login</b>";

}
