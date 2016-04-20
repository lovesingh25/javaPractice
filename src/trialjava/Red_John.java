package trialjava;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Red_John {
	public static int calFactorial(int i, int one){
		
		BigInteger mul = new BigInteger("1");
		BigInteger inc = new BigInteger("1");
		BigInteger fac = new BigInteger("1");
		BigInteger facone = new BigInteger("1");
		BigInteger faci = new BigInteger("1");
		int j;
		for(j=1;j<=(i+one);j++){
			fac = fac.multiply(mul);
			mul = mul.add(inc);
			if(j==i){
				faci = fac;
			}
			if(j==one){
				facone = fac;
			}
		}
		facone = facone.multiply(faci);
		fac = fac.divide(facone);
		return fac.intValue();	
	}
	public static int calCases(int cases,int n){
		int four=n/4,one,i;
       for(i=1;i<=four;i++){
    	   one = n - (i*4);
    	   cases+=calFactorial(i,one);
    	   
       }
		return cases;
	}
 public static boolean findPrime(int g){
	 for(int i=2;i<=Math.sqrt(g);i++){
		 if(g%i == 0){ 
			 return false;
		 }
	 }
	return true;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t,count,i,check=0;
		boolean prime;
		HashSet<Integer> setnotprime = new HashSet<Integer>();
		HashMap<Integer,Integer> mapcount = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> FinalAns = new HashMap<Integer,Integer>();
		Scanner reader  = new Scanner(System.in); 
		t=reader.nextInt();
		int[] n = new int[t];
		int []cases = new int[t];
		int []countarray = new int[t];
		for(i=0;i<t;i++){
			cases[i] = 1;
			n[i]=reader.nextInt();
			if(n[i]>=4){
				cases[i] = calCases(cases[i],n[i]);
			}
			FinalAns.put(i,cases[i]);
		}
	Arrays.sort(cases);
      for(i=0;i<t;i++){
        count = 0;	
        check=0;
		for(int j=cases[i];j>1;j--){
			check++;
			if(!mapcount.containsKey(j)){
				if(!setnotprime.contains(j)){
					prime = findPrime(j);
					if(prime == true){
						count++;
					}
					else{
						setnotprime.add(j);
					}
				}
			}
			else{
				count+=mapcount.get(j);
				break;
			}
		}
		mapcount.put(cases[i], count);
		//System.out.println("check="+check);
	}
      for(i=0;i<t;i++){
    	  countarray[i]=mapcount.get(FinalAns.get(i));
      }
		
      for(i=0;i<t;i++){
    	  System.out.println(countarray[i]);
      }
 }
}
