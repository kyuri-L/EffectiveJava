package ConstructAndDestroy.Item2_BuilderPattern;

public class NutritionFactsApplication {
	public static void main(String[] args) {
		// 점층적 생성자 패턴 -> 클라이언트 코드를 작성하거나 읽기 어려움. 각 매개변수가 무엇을 의미하는지 헷갈릴 수 있음.
		NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
		NutritionFacts nutritionFacts = new NutritionFacts(999, 999);

		// 자바빈즈 패턴 -> 객체 하나 만들려면 메서드 여러 개 호출해야 함. 객체 완성 전까지 일관성이 무너진 상태임.
		NutritionFacts sprite = new NutritionFacts();
		sprite.setServingSize1(250);
		sprite.setServings1(10);
		sprite.setCalories1(120);
		sprite.setFat1(10);
		sprite.setSodium1(30);
		sprite.setCarbohydrate1(30);

		// 빌더 패턴 -> 연쇄적 호출 가능 == fluent API or method chaining(메서드 연쇄)
		// 명명된 선택적 매개변수를 흉내 낸 것
		NutritionFacts fanta = new NutritionFacts.Builder(260, 9)
			.calories(140).fat(15).sodium(33).carbonhydrate(29).build();

		System.out.println("-just example of NutritionFacts: "+nutritionFacts+"-");
		System.out.println();
		System.out.println("cocaCola's nutrition factors: "+cocaCola);
		System.out.println("sprite's nutrition factors: "+sprite.toString1());
		System.out.println("fants's nutrition factors: "+fanta.toString());
	}
}
