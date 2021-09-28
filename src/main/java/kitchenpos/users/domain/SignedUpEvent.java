package kitchenpos.users.domain;

public class SignedUpEvent {
	private String name;

	public SignedUpEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
