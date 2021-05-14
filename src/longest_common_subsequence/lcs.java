package longest_common_subsequence;

import java.util.Scanner;

public class lcs {

	public static int LCS(String a, String b) {

		int m = a.length();
		int n = b.length();

		String x [] = a.split("");
		String y [] = b.split("");

		int C [][] = new int[m+1][n+1];

		for(int i = 0; i <= m; i++) {
			C[i][0] = 0;
		}

		for(int j = 0; j <= n; j++) {
			C[0][j] = 0;
		}

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(x[i-1].equals(y[j-1])) {
					C[i][j] = C[i-1][j-1] + 1;
				}
				else {
					C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
				}
			}
		}

		return C[m][n];
	}

	public static String LCS_Str(String a, String b) {

		int m = a.length();
		int n = b.length();

		String x [] = a.split("");
		String y [] = b.split("");

		String D [][] = new String[m+1][n+1];

		for(int i = 0; i <= m; i++) {
			D[i][0] = "";
		}

		for(int j = 0; j <= n; j++) {
			D[0][j] = "";
		}

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(x[i-1].equals(y[j-1])) {
					D[i][j] = D[i-1][j-1] + x[i-1];
				}
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
