package greedy;

import java.util.Scanner;

public class Greedy {

	// 회의명, 시작시간, 종료시간, 예약 필드를 생성한다
	public String name;
	public int startTime;
	public int endTime;
	public boolean check;

	// Greedy 생성자
	public Greedy(String name, int startTime, int endTime) {

		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.check = false;

	}
	// 종료 시간이 가장 이른 회의 순으로 정렬
	public static void sort(Greedy[] meeting) {

		// 버블 정렬 이용
		 for(int i = 0; i < meeting.length; i++) {
		        for(int j = 0 ; j < meeting.length - i - 1 ; j++) {
		            if(meeting[j].endTime > meeting[j+1].endTime) {
		                Greedy temp = meeting[j+1];
		                meeting[j+1] = meeting[j];
		                meeting[j] = temp;
		            }
		        }
		    }

	}

	// 회의실 배정
	public static Greedy[] meeting_Time(Greedy[] meeting) {


		int temp = 6;
		int count = 0;
		int countB = 0;

		// 객체배열에서 현 시점 가장 좋아보이는 원소의 check필드를 true로 바꾼다
		for(int i = 0; i < meeting.length; i++) {

			if(meeting[i].startTime >= temp && meeting[i].endTime < 24) {
				meeting[i].check = true;
				temp = meeting[i].endTime;
				count++;
			}

		}

		//회의실 배정
		Greedy[] meeting_Time = new Greedy[count];

		for(int i = 0; i < meeting.length; i++) {
			if(meeting[i].check == true) {
				meeting_Time[countB] = meeting[i];
				countB++;
			}
		}

		return meeting_Time;

	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 신청 회의 수를 입력받는다
		System.out.print("신청 회의 수 입력: ");
		int n = sc.nextInt();

		Greedy[] meeting = new Greedy[n];

		// 객체 배열을 생성한다
		for(int i = 0; i < n; i++) {

			String name = sc.next();
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();

			meeting[i] = new Greedy(name, startTime, endTime);

		}

		// 객체를 종료 시간이 이른 순서대로 정렬
		Greedy.sort(meeting);
		// 회의실 배정
		Greedy[] meeting_Time = Greedy.meeting_Time(meeting);

		System.out.println("선정된 회의 수 = "+meeting_Time.length);
		System.out.println("선정된 회의 스케줄 = ");

		for(int i=0; i < meeting_Time.length; i++) {

			System.out.print(meeting_Time[i].name+" ");
			System.out.print("("+meeting_Time[i].startTime+", "+meeting_Time[i].endTime+")");
			System.out.println();
		}

		sc.close();

	}



}
