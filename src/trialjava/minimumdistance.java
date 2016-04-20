package trialjava;

public class minimumdistance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp  = {1,2,3,4,8,2,1,5,3};
		int[][] cost = new int[3][3];
		int k = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				cost[i][j] = temp[k++];
			}
		}
		int tempCost;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				tempCost = Integer.MAX_VALUE;
				if(i-1 >= 0){
					tempCost = cost[i-1][j];
				}
				if(j-1 >= 0){
					if(tempCost > cost[i][j-1]){
						tempCost = cost[i][j-1];
					}
				}
				if(i-1 >= 0 && j-1 >= 0){
					if(tempCost > cost[i-1][j-1]){
						tempCost = cost[i-1][j-1];
					}
				}
				if(tempCost < Integer.MAX_VALUE)
				cost[i][j] = cost[i][j] + tempCost;
			}
		}
		System.out.println(cost[2][2]);
	}

}
