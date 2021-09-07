package kitchenpos.products.tobe.application;

import org.springframework.stereotype.Service;

import kitchenpos.products.tobe.domain.DisplayedName;
import kitchenpos.products.tobe.domain.Profanities;

@Service
public class ProductService {
	private final Profanities profanities;

	public ProductService(Profanities profanities) {
		this.profanities = profanities;
	}

	public void create(final String name) {
		new DisplayedName(name, profanities);
	}
}

