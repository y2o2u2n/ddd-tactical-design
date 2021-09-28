package kitchenpos.users.infra;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import kitchenpos.users.application.MessageSender;
import kitchenpos.users.domain.SignedUpEvent;

@Component
public class EmailSender implements MessageSender {
	@EventListener
	@Override
	public void send(SignedUpEvent event) {
		System.out.println("Send an email to " + event.getName());
	}
}
