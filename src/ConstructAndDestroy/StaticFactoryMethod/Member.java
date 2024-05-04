package ConstructAndDestroy.StaticFactoryMethod;

public class Member {
	private String name;
	private String id;
	private int password;

	// 클래스의 인스턴스를 얻는 전통적인 방법: public 생성자
	public Member() {}
	public Member(String name, String id, int password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "{name='" + name + '\'' +
				", id='" + id + '\'' +
				", password=" + password +
				'}';
	}
	/* 대표적인 정적 팩토리 메소드
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	*/

	// 장점1. 이름을 가질 수 있다 -> 객체의 특성을 이해하기 좋다
	// '새로운' 회원
	public static Member newMember(String name, String id, int password) {
		return new Member(name, id, password);
	}
	// '탈퇴하는' 회원
	public static Member cancelMember(String name, String id, int password) {
		return new Member(name, id, password);
	}

	// 장점2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다. 플라이웨이트 패턴(Flyweight pattern)과 비슷하다
	private static final Member instance = new Member("Susan", "angel", 1004);

	public static Member getInstance() {
		return instance;
	}

	// 장점3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다
	/* 예시-java.util.Arrays 유틸클래스의 정적 팩토리 메서드인 asList()
	public static <T> List<T> asList(T... a) {
		return new ArrayList<>(); // List의 하위 타입 객체인 ArrayList로 반환
	}
	*/

	// 장점4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다
	public static Member getInstance(boolean flag) {
		return flag ? new deletedMember(): new Member("right", "wrong", 912);
	}

	static class deletedMember extends Member {}

	enum MemberStates{
		ACTIVE, DORMANT, WITHDRAWN
	}

	// 장점5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다 -> 장점3,4와 비슷한 개념이다
	public static Member getInstance2() {
		Member member = new Member();

		// 어떤 특정한 약속되어 있는 텍스트 파일에서 Member의 구현체의 *FQCN(Full Qualified Class Name) 읽어오기
		// FQCN에 해당하는 인스턴스 생성
		// member 변수를 해당 인스턴스를 가리키도록 수정
		member.password = 1230;
		
			// *FQCN? - object, 함수, 변수의 계층적 구를 모두 포함하여 표현하는 것으로,
			// 			Java의 경우 해당 클래스가 속한 패키지명을 모두 포함한 이름
			// (예시)
			// String s = new String(); -> 일반적인 사용법
			// java.lang.String s = new java.lang.String(); -> FQCN

		return member;
	}
}
