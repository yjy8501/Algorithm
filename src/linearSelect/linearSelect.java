package linearSelect;

import java.util.Arrays;
import java.util.Scanner;

public class linearSelect {

	public static String[] quickSort(String[] words, int p, int r) {

		// r과 p가 같으면 재귀호출을 끝낸다
		if(r <= p) {

			// 배열을 리턴한다
			return words;
		}

		// 파티션 진입
		int q = partition(words, p, r);

		// 전위 퀵 sort
		quickSort(words, p, q - 1);

		// 후위 퀵 sort
		quickSort(words, q + 1, r);

		// 배열을 리턴한다
		return words;

	}

	public static int partition(String[] words, int p, int r) {

		// 피벗
		String pivot = words[r];

		// 1구역 i
		int i = p - 1 ;

		// 2구역 j
		for (int j = p; j < r; j++) {

			// words[j] 와 pivot을 비교해서 words[j]가 더 작으면
			// words[++i] 과 words[j]를 교환
			if (words[j].compareToIgnoreCase(pivot) <= 0) {

				String temp = words[++i];
				words[i] = words[j];
				words[j] = temp;
			}

		}

		// 반복문을 빠져나오고 pivot 위치 정렬
		String temp = words[i + 1];
		words[i + 1] = words[r];
		words[r] = temp;

		// pivot 위치 리턴
		return i + 1;
	}

	                                                     /* 17 19 20 */
	public static String linear_Select(String[] words, int p, int r, int i) {
		// 원소가 5개 이하이면 i번째 작은 원소를 찾는다
		if(r-p < 5) {
			quickSort(words, p, r);


			return words[i - 1];
		}


		// 5개의 작은 그룹으로 나누기
		String group [][] = new String[(int)Math.ceil((double)(r-p) / 5)][];

		int count = r-p;

		for(int e = 0; e < (int)Math.ceil((double)(r-p) / 5); e++) {

			if(count < 4) {
				group[e] = new String[count+1];
			}
			else{
				group[e] = new String[5];
			}
			count += -5;

		}

		int w = p;

		// 5개의 작은 그룹에 값 넣기
		for(int n = 0; n < group.length; n++) {
			for(int c = 0; c < group[n].length; c++) {
				group[n][c] = words[w++];
			}
		}


		// 각 그룹에서 중앙값 찾기
		String midarr [] = new String[(int)Math.ceil((double)(r-p) / 5)];

		// 그룹의 중앙값 배열에 넣기
		for(int j = 0; j < group.length; j++) {
			midarr[j] = linear_Select(group[j], 0, group[j].length -1, 3);

		}


		  // 배열의 중앙값 mid
		  String mid = linear_Select(midarr, 0, midarr.length -1, (int)Math.ceil((double)(midarr.length) / 2));

		  // 중앙값의 인덱스 값 찾기
		  int index = Arrays.asList(words).indexOf(mid);


		  	  // 중앙값과 배열의 끝값 교환
			  String temp = words[r];
			  words[r] = mid;
			  words[index] = temp;


			  // 파티션 실행
			  int q = partition(words, 0, r);

			  // 찾으려고 하는 값이 q보다 작을 때 전위 정렬
			  if(q > i) {
				  return linear_Select(words, p, q-1, i);
				  }

			  // 찾으려고 하는 값과 q가 같을 때
			  else if(q == i-1) {
				  return words[q];
				  }

			  // 찾으려고 하는 값이 q보다 끌 태 후위 정렬
			  else {
				  return linear_Select(words, q+1, r, i);
				  }


	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a [] = new String[20];
		String b [] = new String[20];
		String c [] = new String[20];
		String d [] = new String[20];

		System.out.println("hw5_1:양재용");
		System.out.print("20개의 단어 입력:");

		for(int i = 0; i < a.length; i++) {
			a[i] = sc.next();
			b[i] = a[i];
			c[i] = a[i];
			d[i] = a[i];
		}

		String first = linear_Select(a,0, a.length -1, 1);
		String sixth = linear_Select(b,0, a.length -1, 6);
		String seventeenth = linear_Select(c,0, a.length -1, 17);
		String twentieth = linear_Select(d,0, a.length -1, 20);



		System.out.println("1번째 작은 단어 ="+first);
		System.out.println("6번째 작은 단어 ="+sixth);
		System.out.println("17번째 작은 단어 ="+seventeenth);
		System.out.println("20번째 작은 단어 ="+twentieth);

		sc.close();
	}

}

