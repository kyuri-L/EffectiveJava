package ConstructAndDestroy.Item2_BuilderPattern;

public class PizzaApplication {
	public static void main(String[] args) {
		NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM) // 필수적인 파라미터
			.addTopping(Pizza.Topping.HAM) // 부가적인 파라미터
			.addTopping(Pizza.Topping.MUSHROOM) // 부가적인 파라미터
			.addTopping(Pizza.Topping.ONION) // 부가적인 파라미터
			.build();

		Calzone calzone = new Calzone.Builder()
			.addTopping(Pizza.Topping.PEPPER)
			.addTopping(Pizza.Topping.SAUSAGE)
			.sauceInside()
			.build();

		// 내가 만들어보는 인스턴스
		NyPizza ex1 = new NyPizza.Builder(NyPizza.Size.SMALL)
			.addTopping(Pizza.Topping.SAUSAGE)
			.addTopping(Pizza.Topping.ONION)
			.build();

		NyPizza ex2 = new NyPizza.Builder(NyPizza.Size.LARGE)
			.addTopping(Pizza.Topping.MUSHROOM)
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.ONION)
			.addTopping(Pizza.Topping.PEPPER)
			.build();

		System.out.println("New York Pizza: "+nyPizza.toString());
		System.out.println("Calzone: "+calzone.toString());
		System.out.println();
		System.out.println("Example1: "+ex1);
		System.out.println("Example2: "+ex2);
	}
}
