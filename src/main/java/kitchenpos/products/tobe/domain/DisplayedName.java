package kitchenpos.products.tobe.domain;

import javax.persistence.Embeddable;

import kitchenpos.common.Value;

/**
 * - 상품의 이름에는 비속어가 포함될 수 없다.
 */
@Embeddable
public class DisplayedName extends Value<DisplayedName> {
	private String name;

	protected DisplayedName() {

	}

	public DisplayedName(final String name, final Profanities profanities) {
		if (profanities.contains(name)) {
			throw new IllegalArgumentException("이름에는 욕설이 포함될 수 없습니다.");
		}
		this.name = name;
	}
}
