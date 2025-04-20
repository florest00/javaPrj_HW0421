package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		 사용자가 정수 1에서 10까지 모험하는 게임
		
		Scanner sc = new Scanner(System.in);
		String playAgain;
		
		do {
			System.out.println(" ==== Adventure In Numbers World ====");
//			사용자의 이름을 입력받는다.
			System.out.print("이름을 입력하세요 : ");
			String name = sc.nextLine();
//			환영 문구를 출력한다.
			System.out.println("환영합니다, " + name + " 님,");
			System.out.println("모험을 시작해볼까요? :)");
			
			// 캐릭터와 스탯 목록을 관리하는 배열
			Characters[] characters = {
					new Characters("검사", 100, 10, 0),
					new Characters("마법사", 80, 10, 50),
					new Characters("궁수", 50, 80, 10)
			};
			
			
			//사용자의 현 정보를 출력한다.
			for (int i = 0; i < characters.length; i++) {
				System.out.println((i + 1) + ". ");
				characters[i].userInfo();
			}
			
			// 캐릭터 선택 받기
			System.out.print("원하시는 캐릭터를 선택해 주세요 : ");
			int choice = sc.nextInt();
			sc.nextLine(); // enter 키를 눌러야만 게임이 시작되게
			
			//유저 캐릭터 선택
			Characters user = null;
				if (choice >= 1 && choice <= characters.length) {
					user = characters[choice - 1];
					System.out.println("\n[" + user.name + "] 캐릭터를 선택하셨습니다!");
					user.userInfo();
				} else {
					System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
					return;
				}
				
				//다음 스탭 예고
				System.out.println("\n이제 주사위를 굴려서 이동을 시작해볼까요?");
			
				//게임 진행
				int totalDistance = 0; //누적 이동 거리
				while (true) {
					System.out.println("\n주사위를 굴리려면 Enter를 누르세요!");
					sc.nextLine(); // 엔터 대기용
					
					int dice = (int)(Math.random() * 6) +1;
					System.out.println("주사위 결과: " + dice);
					
					totalDistance += dice;
					System.out.println("현재 이동 거리: " + totalDistance + " / 10");
					
					//10 이상 도달 시 게임 클리어
					if (totalDistance >= 10) {
						System.out.println("축하합니다! 목적지에 도달하셨습니다!");
						break;
					}
					
					// (몬스터 || 스탯 이벤트)
					// 50% 확률로 몬스터와 조우하거나, 스탯 변화 이벤트 발생
					if (Math.random() < 0.5) { // 몬스터와 만날 확률 50%
						System.out.println("몬스터를 만났습니다!");
						
						// 몬스터의 스탯을 랜덤하게 생성 (예: HP, ATK)
						int monsterHp = (int)(Math.random() * 50) + 1; // 1~50 사이의 랜덤 값
						int monsterAtk = (int)(Math.random() * 20) + 1; // 1~20 사이의 랜덤 값
						System.out.println("몬스터의 스탯 - HP: " + monsterHp + ", ATKL " + monsterAtk);
						
						//전투 로직 (간단히 몬스터의 HP가 0 이하가 되면 승리, 사용자가 패배하면 종료)
						if (user.atk > monsterHp) {
							System.out.println("몬스터를 처치했습니다!");
							user.adjustStat(); //승리 후 스탯 변화
						} else {
							System.out.println("몬스터에게 패배했습니다...");
							System.out.println("게임 오버!");
							break; //게임 종료
						}
					} else { // 50% 확률로 스탯 변화 이벤트 발생
						System.out.println("스탯 변화 이벤트가 발생했습니다!");
						user.adjustStat(); //랜덤으로 스탯이 변함
					}
				}
				
				//게임 종료 후 결과 기록 (보류)
				
				
				//게임 종료 후 재시작 여부 확인
				System.out.print("\n 게임이 끝났습니다. 다시 시작하시겠습니까? (Y/N)");
				playAgain = sc.nextLine().toUpperCase(); // Y 또는 N 입력 받기
			
		} while (playAgain.equals("Y"));
		
		System.out.println("게임을 종료합니다. 감사합니다.");
		sc.close();
		
		
		
	}//main
	

}//class
