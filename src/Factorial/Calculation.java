package Factorial;

import java.util.Scanner;

// 팩토리얼 클래스 선언
public class Calculation {

	// 팩토리얼 계산값을 리턴해주는 static factorial() 선언
	static int factorial(int n) {

		// n이 1이면 n을 리턴한다
		if (n == 1) {
			return n;
		}
		// n이 1이 될 때 까지 n * factorial(n-1)을 한다
		else {
			return n * factorial(n - 1);
		}

	}

	// 1 부터 n 까지의 수를 차례대로 출력하는 static show() 메소드 선언
	static void show(int n) {

		// n이 1이면 n을 출력한다
		if (n == 1) {
			System.out.print(n + " ");
		} else {
			// 1부터 출력되기 위해서 show(n-1)을 실행한 뒤 출력문을 실행한다
			show(n - 1);
			System.out.print(n + " ");

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n; // 팩토리얼값을 구할 숫자의 크기

		System.out.println("hw0_2:양재용");

		// 양의 정수가 입력될 때 까지 실행시킨다
		while (true) {
			System.out.print("양의 정수 n 입력: ");
			n = sc.nextInt();

			// 양의 정수를 입력받으면 while문을 벗어난다
			if (n >= 1)
				break;
			// 양의 정수가 아닐 시 출력한다
			else {
				System.out.println("양의 정수를 입력해주시오");
				System.out.println();
			}
		}
		System.out.println();

		// 팩토리얼 값 출력
		System.out.println("factorial(" + n + ") = " + Calculation.factorial(n));

		// show() 실행
		System.out.print("show(" + n + ") = ");
		Calculation.show(n);

		sc.close();

	}

}
