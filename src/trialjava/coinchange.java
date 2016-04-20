package trialjava;

import java.util.Scanner;

public class coinchange {
	
	public static int calChange(int n,int m,int[] a){
		int count=0,i=0,j=0,num=0,t=0;
		for(i=0;i<m;i++){
			if(n/a[i] > 0){
				if(n%a[i] == 0){
					count++;
					System.out.println("Direct "+i+" "+a[i]);
				}
				num = n/a[i];
				j=i+1;
				t=num;
				while(j < m){
					if(num*a[i] < n){
						 if(num == 1){
								num = n/a[i];
								t=num;
							}
						if(t*a[i]+((n/a[i])-num)*a[j] == n && t>0 && ((n/a[i])-num) > 0){
							count++;
							System.out.println("Indirect"+t+" "+a[i]+" "+((n/a[i])-num)+" "+a[j]);
							num--;
							t--;
						}
						else if(t*a[i]+((n/a[i])-num)*a[j] > n && t>0){
							t--;
						}
						else{
							num--;
							t--;
						}
						 if(num == 1){
								j++;
							}
				}
             else{
               num--;
               t--;
             }
			}
				
		}
			
	}
		return count;
		
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0,m=0,i=0;
		Scanner reader  = new Scanner(System.in); 
		n=reader.nextInt();
		m=reader.nextInt();
		int[] a = new int[m];
		for(i=0;i<m;i++){
			a[i]=reader.nextInt();
		}
		System.out.println(calChange(n,m,a));
	}
}
