package kitchenpos.users.application;

import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kitchenpos.users.domain.SignedUpEvent;
import kitchenpos.users.domain.User;
import kitchenpos.users.domain.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final ApplicationEventPublisher publisher;

	public UserService(UserRepository userRepository, ApplicationEventPublisher publisher) {
		this.userRepository = userRepository;
		this.publisher = publisher;
	}

	// i) ApplicationEventPublisher
	@Transactional
	public void join(String name, boolean subscribed) {
		User user = new User(name, subscribed);
		userRepository.save(user);
		publisher.publishEvent(new SignedUpEvent(name));
	}

	// ii) AbstractAggregateRoot
	@Transactional
	public void changePassword(String name) {
		User user = userRepository.findByName(name);
		user.changePassword(UUID.randomUUID().toString());
		userRepository.save(user); // 명시적으로 save() 해야 이벤트가 발행된다. Spring Data Jdbc 도 가능
	}
}

