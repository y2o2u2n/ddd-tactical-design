package kitchenpos.products.tobe.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisplayedNameTest {
	@Test
	void 비속어() {
		assertThatThrownBy(
			() -> new DisplayedName("욕설", new FakePurgomalumClient())
		).isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	void 생성() {
		Assertions.assertDoesNotThrow(
			() -> new DisplayedName("치킨", new FakePurgomalumClient())
		);
	}

	@Test
	void 동등성() {
		DisplayedName name1 = new DisplayedName("치킨", new FakePurgomalumClient());
		DisplayedName name2 = new DisplayedName("치킨", new FakePurgomalumClient());
		assertThat(name1).isEqualTo(name2);
	}
}

class FakePurgomalumClient implements Profanities {
	private static final List<String> profanities;

	static {
		profanities = Arrays.asList("비속어", "욕설");
	}

	@Override
	public boolean contains(final String text) {
		return profanities.stream()
			.anyMatch(profanity -> text.contains(profanity));
	}
}
