package mx.crud.web.response;

import java.util.List;

import mx.crud.web.resource.UserResource;

public class UserResponse {

	private List<UserResource> users;

	public List<UserResource> getUsers() {
		return users;
	}

	public void setUsers(final List<UserResource> users) {
		this.users = users;
	}
}
