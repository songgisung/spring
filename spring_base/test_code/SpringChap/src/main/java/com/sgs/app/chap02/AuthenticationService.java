package com.sgs.app.chap02;

public class AuthenticationService {

	private UserRepository userRepository;
	private AuthFailLogger failLogger;

	public AuthInfo authenticate (String id, String password) {
		User user = userRepository.findUserById(id);

		if(user == null) {
			throw new UserNotFoundException();
		}

		if(!user.matchPassword(password)) {
			failLogger.insertBadPw(id, password);
			throw new AuthException();
		}

		return new AuthInfo(user.getId());
	}


	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setFailLogger(AuthFailLogger authFailLogger) {
		this.failLogger = authFailLogger;
	}
}


//AuthInfo, AuthException, UserNotFoundException 추가 필