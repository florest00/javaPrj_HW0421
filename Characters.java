package main;

public class Characters {
	
//	member var
	
	String name;
	int hp; //체력 변수 선언
	int atk; // 공격력 변수 선언
	int mp; // 마력 변수 선언
	int progress = 0; // 이동 거리 변수 선언과 값 할당
	
//	member method
	
	// 캐릭터 생성
	public Characters(String name, int hp, int atk, int mp) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.mp = mp;
	}
	
	// 스탯 출력
	public void userInfo() {
		System.out.println("[" + name + "] HP: " + hp + ", ATK: " + atk + ", MP: " + mp);
	}
	
	//info

	
	// 캐릭터 생존 여부
	public boolean isAlive() {
		return hp > 0;
	}
	
	// 스탯 랜덤 변화 이벤트 (1~10 증감)
	public void adjustStat() {
		int value = (int)(Math.random() * 10) + 1;
		int statType = (int)(Math.random() * 3);
		boolean increase = Math.random() < 0.5;
		
		if (!increase) value *= -1;
		
		switch (statType) {
		case 0:
			hp += value;
			System.out.println("HP가 " + value + "만큼 " + (increase ? "증가" : "감소") + "했습니다.");
			break;
		case 1:
			atk += value;
			System.out.println("ATK가 " + value + "만큼 " + (increase ? "증가" : "감소") + "했습니다.");
			break;
		case 2:
			mp += value;
			System.out.println("MP가 " + value + "만큼 " + (increase ? "증가" : "감소") + "했습니다.");
			break;
		}
		
		// 음수 방지
		if (hp < 0) hp = 0;
		if (atk < 0) atk = 0;
		if (mp < 0) mp = 0;
	}
	

}//class
