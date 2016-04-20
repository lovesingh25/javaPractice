package trialjava;

/**
 * Created by losandhu on 20-Apr-16.
 */
public class mergeSort {
    public static void merge(int[]a,int s, int m, int e){
        int n1 = m-s+1,n2 = e-m;
        int[] l = new int[n1];
        int[] r = new int[n2];
        int i=0,j=0,k=0;
        k=s;
        while(i<n1){
            l[i] = a[k];
            i++;
            k++;
        }
        k=m+1;
        while(j<n2){
            r[j] = a[k];
            j++;
            k++;
        }
       j=0;i=0;k=s;
        while(i<n1 && j<n2){
            if(l[i] < r[j]){
                a[k] = l[i];
                i++;
            }
            else{
                a[k] = r[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = l[i];
            i++;
            k++;
        }
        while (j<n2) {
            a[k] = r[j];
            j++;
            k++;
        }
    }
    public static void sort(int[] a ,int s,int e){
        int m = (s+e)/2;
        if(s<e){
            sort(a,s,m);
            sort(a,m+1,e);
            merge(a,s,m,e);
        }
    }
    public static void main(String[] arg){
        int[] a ={45,5,3,8,10,15,65};
        sort(a,0,a.length-1);
        int i =0;
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
    }
}
