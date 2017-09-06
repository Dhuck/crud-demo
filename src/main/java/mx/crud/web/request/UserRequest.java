package mx.crud.web.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRequest {

    @NotNull
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" +
	            this.id + 
	            ", name=" + this.name + 
	            ", email=" + this.email
				+ "]";
	}
}
