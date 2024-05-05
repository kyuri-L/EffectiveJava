package ConstructAndDestroy.Item2_BuilderPattern;

import java.util.Objects;

public class NyPizza extends Pizza{
	public enum Size { SMALL, MEDIUM, LARGE }
	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size); // 매개변수가 null인지 아닌지 확인하고 넣어줌.
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder); // Pizza 클래스에서 topping 세팅
		size = builder.size; // 여기서 size 세팅
	}

	@Override
	public String toString() {
		return "{" +
			"size=" + size +
			", toppings=" + toppings +
			'}';
	}
}
