package longest_common_subsequence;

import java.util.Scanner;

public class lcs {

	// LCS 길이 반환
	public static int LCS(String a, String b) { // 문자열 a, b를 매개변수로 받는다

		int m = a.length(); // a의 길이만큼의 크기를 가진 m 배열 생성
		int n = b.length(); // b의 길이만큼의 크기를 가진 m 배열 생성

		String x [] = a.split(""); // a 문자열의 문자를 잘라서 x 배열에 넣는다
		String y [] = b.split(""); // b 문자열의 문자를 잘라서 y 배열에 넣는다

		int C [][] = new int[m+1][n+1]; // LCS의 길이를 저장하는 배열

		// 가로 1행 0으로 초기화
		for(int i = 0; i <= m; i++) {
			C[i][0] = 0;
		}

		// 세로 1행 0으로 초기화
		for(int j = 0; j <= n; j++) {
			C[0][j] = 0;
		}

		// LCS 길이 배열에 저장
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				// X[i]와 Y[i]가 같은 문자일 때
				if(x[i-1].equals(y[j-1])) {
					C[i][j] = C[i-1][j-1] + 1;
				}
				// X[i]와 Y[i]가 다른 문자일 때
				else {
					C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
				}
			}
		}

		// LCS 길이 리턴
		return C[m][n];
	}

	// LCS 문자열 반환
	public static String LCS_Str(String a, String b) {

		int m = a.length(); // a의 길이만큼의 크기를 가진 m 배열 생성
		int n = b.length(); // b의 길이만큼의 크기를 가진 m 배열 생성

		String x [] = a.split(""); // a 문자열의 문자를 잘라서 x 배열에 넣는다
		String y [] = b.split(""); // b 문자열의 문자를 잘라서 y 배열에 넣는다

		String D [][] = new String[m+1][n+1]; // LCS를 저장하는 배열

		// 가로 1행 0으로 초기화
		for(int i = 0; i <= m; i++) {
			D[i][0] = "";
		}

		// 세로 1행 0으로 초기화
		for(int j = 0; j <= n; j++) {
			D[0][j] = "";
		}

		// LCS 길이 배열에 저장
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				// X[i]와 Y[i]가 같은 문자일 때
				if(x[i-1].equals(y[j-1])) {
					D[i][j] = D[i-1][j-1] + x[i-1];
				}
				// X[i]와 Y[i]가 다른 문자일 때
				else {
					if(D[i-1][j].length() > D[i][j-1].length()) {
						D[i][j] = D[i-1][j];
					}
					else {
						D[i][j] = D[i][j-1];
					}
				}
			}
		}

		// LCS 리턴
		return D[m][n];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("hw9-1:양재용");

		System.out.print("첫번째 문자열 입력:");
		String a = sc.nextLine();
		System.out.print("두번째 문자열 입력:");
		String b = sc.nextLine();

		int lcs =  LCS(a,b);
		String lcs_Str = LCS_Str(a,b);

		System.out.println("LCS 길이 = "+lcs);
		System.out.println("LCS ="+lcs_Str);


	}
}
