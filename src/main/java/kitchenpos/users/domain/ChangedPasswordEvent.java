package kitchenpos.users.domain;

public class ChangedPasswordEvent {
	private Long id;
	private String name;
	private boolean subscribed;

	public ChangedPasswordEvent(Long id, String name, boolean subscribed) {
		this.id = id;
		this.name = name;
		this.subscribed = subscribed;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isSubscribed() {
		return subscribed;
	}
}
