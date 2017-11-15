package de.predic8.workshop.checkout.dto;

public class BasketIdentifier {
	String basket;

	@java.beans.ConstructorProperties({"basket"})
	public BasketIdentifier(String basket) {
		this.basket = basket;
	}

	public String getBasket() {
		return this.basket;
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof BasketIdentifier)) return false;
		final BasketIdentifier other = (BasketIdentifier) o;
		final Object this$basket = this.getBasket();
		final Object other$basket = other.getBasket();
		if (this$basket == null ? other$basket != null : !this$basket.equals(other$basket)) return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $basket = this.getBasket();
		result = result * PRIME + ($basket == null ? 43 : $basket.hashCode());
		return result;
	}

	public String toString() {
		return "BasketIdentifier(basket=" + this.getBasket() + ")";
	}
}
