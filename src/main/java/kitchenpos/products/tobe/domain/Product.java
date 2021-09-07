package kitchenpos.products.tobe.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * - 상품을 등록할 수 있다.
 * - 상품의 가격이 올바르지 않으면 등록할 수 없다.
 * - 상품의 가격은 0원 이상이어야 한다.
 * - 상품의 이름이 올바르지 않으면 등록할 수 없다.
 * - 상품의 이름에는 비속어가 포함될 수 없다.
 * - 상품의 가격을 변경할 수 있다.
 * - 상품의 가격이 올바르지 않으면 변경할 수 없다.
 * - 상품의 가격은 0원 이상이어야 한다.
 * - 상품의 가격이 변경될 때 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨진다.
 * - 상품의 목록을 조회할 수 있다.
 */
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@Embedded
	private DisplayedName name;
	@Embedded
	private Price price;

	protected Product() {

	}

	public Product(final UUID id, final DisplayedName name, final Price price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public void changePrice(final Price price) {
		this.price = price;
		// 메뉴 컨텍스트랑 협력을 해야 함. 이벤트로 구현하면 좋을 것 같은데? 다음 수업 내용
	}

	// TC 를 위해서 또는 편의를 위해서 오버로딩할 수도 있다.
	public void changePrice(final BigDecimal price) {
		this.price = new Price(price);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Product product = (Product)o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
