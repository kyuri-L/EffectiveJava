package ConstructAndDestroy.Item2_BuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
	final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> { // 자기 자신의 하위 타입을 매개변수로 받는 빌더(재귀적인 타입 빌더)
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class); // 비어있는 enum set

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		abstract Pizza build(); // Pizza의 하위 타입에서 인스턴스를 만들기 위한 준 작업

		protected abstract T self();
	}

	Pizza(Builder<?> builder) { // 생성자
		toppings = builder.toppings.clone();
	}
}
