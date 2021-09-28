package kitchenpos.users.application;

import kitchenpos.users.domain.SignedUpEvent;

public interface MessageSender {
	void send(SignedUpEvent event);
}
