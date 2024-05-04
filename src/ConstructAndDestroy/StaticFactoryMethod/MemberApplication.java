package ConstructAndDestroy.StaticFactoryMethod;

import java.util.EnumSet;

public class MemberApplication {
	public static void main(String[] args) {
		Member member = new Member("Julie", "abc123", 9870); // 호출될 때마다 인스턴스 새로 생성한다
		Member member1 = Member.newMember("Amy", "def456", 6543);
		Member member1_2 = Member.cancelMember("Jason", "ghi789", 21);
		Member member2 = Member.getInstance(); // 호출될 때마다 인스턴스 새로 생성하지 않는다(장점2)
		Member member3 = Member.getInstance(true); // 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다(장점4)
		Member member4 = Member.getInstance2();

		EnumSet<Member.MemberStates> states = EnumSet.allOf(Member.MemberStates.class); // (장점4)
		EnumSet<Member.MemberStates> stored = EnumSet.of(Member.MemberStates.ACTIVE, Member.MemberStates.DORMANT); // (장점4)

		System.out.println("member= "+member);
		System.out.println("member1= "+member1);
		System.out.println("member1_2= "+member1_2);
		System.out.println("member2= "+member2.toString());
		System.out.println("member3= "+member3);
		System.out.println("member4= "+member4);

		System.out.println("states= "+states);
		System.out.println("stored= "+stored);
		System.out.println("'states' has 'withdrawn'? "+states.contains(Member.MemberStates.WITHDRAWN));
	}
}
