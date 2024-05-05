package ConstructAndDestroy.Item2_BuilderPattern;

public class NutritionFacts {
	// 점층적 생성자 패턴(telescoping constructor pattern)
	// 단점-확장의 어려움
	private int servingSize;
	private int servings;
	private int calories;
	private int fat;
	private int sodium;
	private int carbohydrate;

	@Override
	public String toString() {
		return "{" +
			"servingSize=" + servingSize +
			", servings=" + servings +
			", calories=" + calories +
			", fat=" + fat +
			", sodium=" + sodium +
			", carbohydrate=" + carbohydrate +
			'}';
	}

	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
			this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	// 자바빈즈 패턴(JavaBeans pattern)
	// 매개변수들 기본값으로 초기화(기본값 있다면).
	private int servingSize1 = -1; // 필수 매개변수. 기본값 없음.
	private int servings1 = -1; // 필수 매개변수. 기본값 없음.
	private int calories1 = 0;
	private int fat1 = 0;
	private int sodium1 = 0;
	private int carbohydrate1 = 0;

	public String toString1() {
		return "{" +
			"servingSize=" + servingSize1 +
			", servings=" + servings1 +
			", calories=" + calories1 +
			", fat=" + fat1 +
			", sodium=" + sodium1 +
			", carbohydrate=" + carbohydrate1 +
			'}';
	}

	public NutritionFacts() {}

	public void setServingSize1(int val) { servingSize1 = val; }
	public void setServings1(int val) { servings1 = val; }
	public void setCalories1(int val) { calories1 = val; }
	public void setFat1(int val) { fat1 = val; }
	public void setSodium1(int val) { sodium1 = val; }
	public void setCarbohydrate1(int val) { carbohydrate1 =  val; }

	// 빌더 패턴(Builder pattern)
	// 점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비
	public static class Builder {
		// 필수 매개변수
		private final int servingSize;
		private final int servings;

		// 선택 매개변수
		private int calarories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbonhydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calarories = val;
			return this;
		}
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		public Builder carbonhydrate(int val) {
			carbonhydrate = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calarories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbonhydrate;
	}


}
