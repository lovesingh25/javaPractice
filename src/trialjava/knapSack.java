package trialjava;

public class knapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {50,60, 100, 120};
	    int[] wt = {1,10, 20, 30};
	    int  W = 100;
	    int[][] maxW = new int[wt.length][W+1]; 
	    for(int i=0;i<wt.length;i++){
	    	for(int j = i;j<W+1;j++){
	    		if(j<wt[i]){
	    			maxW[i][j] = 0;
	    		}
	    		else{
	    			if(i-1>=0 && j-wt[i] >= 0){
	    				maxW[i][j] = ((maxW[i-1][j-wt[i]] + val[i]) > maxW[i-1][j])? (maxW[i-1][j-wt[i]] + val[i]) : maxW[i-1][j];
	    			}
	    			else{
	    				maxW[i][j] = val[i];
	    			}
	    		}
	    	}
	    }
	    for(int i=0;i<wt.length;i++){
	    	for(int j=0;j<W+1;j++){
	    		System.out.print(maxW[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	    
	    	
	}

}
