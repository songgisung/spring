package com.sgs.app.chap02;

public class AuthFailLogger {

	private int threshold;
	private int failCounts;

	public void insertBadPw(String userID, String inputPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s]\n",userID, inputPw);
		failCounts++;
		if (threshold > 0 && failCounts > threshold) {
			notifyToManyFail();
			failCounts = 0;
		}
	}

	public void notifyToManyFail() {
		System.out.println("너무 많은 로그인 시도 실패");
	}

	public void setThresHold(int thresHold) {
		this.threshold = thresHold;
	}
}
