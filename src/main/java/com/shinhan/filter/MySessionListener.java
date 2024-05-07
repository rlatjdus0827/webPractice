package com.shinhan.filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.Getter;
import lombok.Setter;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@Getter@Setter
@WebListener
public class MySessionListener implements HttpSessionListener {
	String user_id;
	String user_pw;
	public static int total_user = 0;
	/**
	 * Default constructor.
	 */
	public MySessionListener() {

	}

	public MySessionListener(String user_id,String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		total_user++;
		System.out.println("생성 => " + total_user);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		total_user--;
		System.out.println("소멸 => " + total_user);
	}

}
