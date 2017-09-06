package mx.crud.web.response;

import mx.crud.web.resource.UserResource;

public class UserResponse {

	private UserResource user;

	public UserResource getUser() {
		return user;
	}

	public void setUser(final UserResource user) {
		this.user = user;
	}
}
