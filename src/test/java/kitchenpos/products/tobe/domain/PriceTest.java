package kitchenpos.products.tobe.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PriceTest {
	@Test
	void 동등성() {
		final Price price1 = new Price(BigDecimal.valueOf(1000L));
		final Price price2 = new Price(BigDecimal.valueOf(1000L));
		assertThat(price1).isEqualTo(price2);
	}
}
