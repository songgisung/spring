package com.sgs.app.chap02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
	private Map<String, User> userMap = HaspMap<>();

	public User findUserById(String id) {
		return userMap.get(id);
	}

	public User setUsers(List<User> users) {
		for(user u: users) {
			userMap.put(u.getId(), u);
		}
	}
}
