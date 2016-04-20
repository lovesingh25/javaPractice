package trialjava;

import java.util.*;

public class KthNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int n,q;
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			q = s.nextInt();
			int[] A = new int[n];
			for(int i=0;i<n;i++){
				A[i] = s.nextInt();
			}
			int[] L = new int[q]; 
			int[] K = new int[q];
			for(int i=0;i<q;i++){
				L[i] = s.nextInt();
				K[i] = s.nextInt();
			}
			for(int i=0;i<q;i++){
				int Number = CountNumber(L[i],K[i],A);
				System.out.println(Number);
			}
	}

	private static int CountNumber(int L, int K, int[] A) {
		int count = 0,i;
		int n = A.length;
		for(i=0;i<n;i++){
			if(A[i] >= L){
				count++;
			}
			if(count == K){
				break;
			}
		}
		return A[i];
		// TODO Auto-generated method stub
		
	}

}
