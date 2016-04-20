package trialjava;

public class heapSort {

	public void sort(int arr[]){
		int n = arr.length;
		for(int i=(n/2)-1;i>=0;i--){
			heapify(arr,n,i);
		}
		for(int i=n-1;i>=0;i--){
			int swap = arr[0];
			arr[0]   = arr[i];
			arr[i] = swap;
			heapify(arr,i,0);
		}		
	}
	
	private void heapify(int arr[],int n,int i){
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		if(l < n && arr[l] > arr[largest]){
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;
			heapify(arr,n,largest);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {42,12, 11, 13, 5, 6, 7,35};
		heapSort hs = new heapSort();
		hs.sort(arr);
		printArray(arr);
		
	}
	
	private static void printArray(int arr[]){
		int n = arr.length;
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
