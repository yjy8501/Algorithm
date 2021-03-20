package QuickSort;

import java.util.Scanner;

// 퀵 정렬 메소드
public class QuickSort {

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
	
	// 파티션 메소드
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("hw4_1 : 양재용");
		System.out.println();

		System.out.print("단어 수 입력: ");
		int n = sc.nextInt();
		sc.nextLine();

		String words[] = new String[n];

		System.out.print("10개의 단어 입력: ");

		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}


		words = quickSort(words, 0, n-1);

		System.out.print("퀵 정렬 결과 = ");


		  for(int i = 0; i < words.length; i++) { System.out.print(words[i]+" "); }



	}

}
