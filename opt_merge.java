import java.util.*;

class Optimal {
    int arr[];
    public int res;
    Optimal(int n, Scanner sc) {
        arr = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int a[] = new int[n1];
        int b[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            a[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            b[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (a[i] > b[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = b[j];
            j++;
            k++;
        }
    }

    void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    int small(int n) {
        if(n==2){
            return res=res+arr[n-1]+arr[n-2];
        }
        int val=arr[n-1]+arr[n-2];
        arr[n-2]=val;
        res+=val;
        n=n-1;
        mergesort(arr,0, n);
        small(n);
        return res;
    }
   
}

class opt_merge {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Optimal o = new Optimal(n, sc);
        o.mergesort(o.arr, 0, n - 1);
        System.out.println(o.small(n));
    }
}
