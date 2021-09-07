package kitchenpos.products.tobe.infra;

import org.springframework.stereotype.Component;

import kitchenpos.products.tobe.domain.Profanities;

/**
 * Created by JunSeok Youn on 2021/09/07
 */
@Component
class FakeProfanities implements Profanities {
	@Override
	public boolean contains(String name) {
		return false;
	}
}
