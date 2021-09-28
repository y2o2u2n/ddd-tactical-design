package kitchenpos.users.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import kitchenpos.users.domain.ChangedPasswordEvent;
import kitchenpos.users.domain.SignedUpEvent;
import kitchenpos.users.domain.User;
import kitchenpos.users.domain.UserRepository;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;
	@Autowired
	private FakeSender fakeSender; // ApplicationEventPublisher 를 모킹하면서 단위 테스트를 작성할 수도 있다.
	@Autowired
	private UserRepository userRepository;


	@Test
	void join() {
		assertThat(fakeSender.getCount()).isEqualTo(0);
		userService.join("윤준석", true);
		assertThat(fakeSender.getCount()).isEqualTo(1);
	}

	@Test
	void changePassword() {
		User user = userRepository.save(new User("윤준석", true));
		assertThat(fakeSender.getCount()).isEqualTo(0);
		userService.changePassword(user.getName());
		assertThat(fakeSender.getCount()).isEqualTo(1);
	}

}

@Component
class FakeSender implements MessageSender {
	private int count = 0;

	@EventListener
	@Override
	public void send(SignedUpEvent event) {
		count++;
	}

	@EventListener(condition = "#event.subscribed")
	// @TransactionalEventListener 를 사용하면 트랜잭션 외의 범위에서 사용할 수 있다.
	public void send(ChangedPasswordEvent event) {
		System.out.println(event);
		count++;
	}

	public int getCount() {
		return count;
	}
}
