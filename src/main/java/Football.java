

import java.util.Scanner;

public class Football {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (String s:
//			 args) {
//			System.out.print(s);
//		}
//		System.out.println();
//		System.out.print(args[0]);
//		Scanner sc = new Scanner(System.in);
		long startTime= System.nanoTime();
		int n = Integer.parseInt(args[0].trim());
		int w = 0, l = 0;
		int count = 0;
		int h=1;
		int[][] x = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				x[i][j] = Integer.parseInt(args[h]);
				h++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					switch (x[i][j]) {
					case 0:
						l++;
						break;
					case 3:
						w++;
						break;
					}
//					System.out.println("x["+i+"]["+j+"],w:"+w+",l:"+l);
				}
			}
			if (w > l) {
				count++;
			}
			w = 0;
			l = 0;
		}
		System.out.println(count);
		long endtime = System.nanoTime();
		System.out.println("time in nano:"+(endtime-startTime));
		System.out.println("start:"+startTime);
		System.out.println("end:"+endtime);
	}
//	 4
//	 0 1 0 0
//	 3 0 0 3
//	 1 3 0 1
//	 3 0 1 0
//	4
//	0 1 1 3
//	0 0 1 3
//	1 1 0 3
//	1 0 3 0
}
