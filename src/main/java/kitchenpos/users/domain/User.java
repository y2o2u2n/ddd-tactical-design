package kitchenpos.users.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class User extends AbstractAggregateRoot<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password = UUID.randomUUID().toString();
	private boolean subscribed;

	protected User() {

	}

	public User(String name, boolean subscribed) {
		this.name = name;
		this.subscribed = subscribed;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String password) {
		this.password = password;
		registerEvent(new ChangedPasswordEvent(id, name, subscribed));
	}
}
