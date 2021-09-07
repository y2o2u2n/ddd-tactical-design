package kitchenpos.products.tobe.domain;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import kitchenpos.common.Value;

@Embeddable
public class Price extends Value<Price> {
	private BigDecimal value;

	protected Price() {

	}

	public Price(BigDecimal value) {
		if (value.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException(); // 필요에 따라 커스텀 런타임 예외를 던져도 된다.
		}
		this.value = value;
	}
}


