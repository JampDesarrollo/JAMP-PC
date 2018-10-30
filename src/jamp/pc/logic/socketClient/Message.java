package jamp.pc.logic.socketClient;


import java.io.Serializable;


public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        /**
         * 
         */
	private static final int USER_SIGNUP = 1;
        /**
         * 
         */
        private static final int USER_SIGNUP_LOGIN_EXISTS = 11;
        /**
         * 
         */
        private static final int USER_SIGNUP_ERROR = -1;
        /**
         * 
         */
	private static final int USER_LOGIN = 2;
        /**
         * 
         */
        private static final int USER_LOGIN_PASSW_NOT_OK = 21;
        /**
         * 
         */
        private static final int USER_LOGIN_LOGIN_NOT_OK = 22;
        /**
         * 
         */
        private static final int USER_LOGIN_ERROR = -2;
	/**
         * 
         */
	private int code;
        /**
         * 
         */
	private Object user;
	/**
         * 
         * @param code
         * @param user 
         */
	public Message(int code, Object user) {
		super();
		this.code = code;
		this.user = user;
	}
        /**
         * 
         * @return 
         */
	public int getCode() {
		return code;
	}
        /**
         * 
         * @param code 
         */
	public void setCode(int code) {
		this.code = code;
	}
        /**
         * 
         * @return 
         */
	public Object getUser() {
		return user;
	}
        /**
         * 
         * @param user 
         */
	public void setUser(Object user) {
		this.user = user;
	}

}
