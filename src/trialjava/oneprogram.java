package trialjava;
import java.util.Scanner;

public class oneprogram {

    public static long calculatemax(int a, int b,long[] z){
	long maxi=0;
	while(a<b){
		if(z[a] >= maxi){
			maxi = z[a];
		}
		a++;
	}
return maxi;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	int t,n,i=0;
	long maxi=0,cost=0,share=0,income=0;
	Scanner reader  = new Scanner(System.in); 
	t=reader.nextInt();
	while(t > 0){ 
        n=reader.nextInt();
		long[] a = new long[n];
		while(i < n){
			a[i] = reader.nextLong();
			i++;
		}
		i=0;
		maxi = calculatemax(0,n,a);	
		while(i<n){
			if(a[i] < maxi){
				cost = cost + a[i];
				share++;
			}
			else{
				income = income + share*a[i];
				share = 0;
				
			}
			i++;
			maxi = calculatemax(i,n,a);	
		}
		System.out.println(income-cost);
        i=0;
        income = 0;
        cost = 0;
		t--;
	}
 }
}
