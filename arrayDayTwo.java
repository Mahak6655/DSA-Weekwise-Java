import java.util.*;

public class arrayDayTwo{

    //print 2d matrix
    public static void printArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    //q1. swap two number using sum and diff
    public static void swap(int a,int b){
        System.out.println(a + " "+b);

        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println(a + " "+b);
    }

    //q2 sort array using two pointer
    public static void sortArray(int arr[]){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        int i=0;

        while (j<arr.length) {
            if(arr[i]!=0 && arr[j]== 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }

    //2nd approach to solve sort an array
    public static void sortAarray2(int arr[]){
        int left =0;
        int right = arr.length-1;

        while (left<right) {
            if(arr[left] == 0) left++;
            else if(arr[right] == 1) right--;
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    //3rd approach to sort an array
    public static void sortArray3(int arr[]){
        int count =0;
        for(int num : arr){
            if(num == 0) count++;
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = i<count?0:1;
        }
    }

    //q3 move all even integer at start and odd at the end
    public static void moveOddEven(int arr[]){
        int l = 0;
        int r = arr.length-1;

        while (l<r) {
            if(arr[l] %2 == 0) l++;
            else if(arr[r] %2 !=0) r--;
            else{
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }

    //q4 sortSquare in array
    public static int[] sortSquare(int arr[]){
        int n = arr.length;
        int l =0;
        int r = n-1;
        int ans[] = new int[arr.length];
        int k=0;
        while (l<=r) {
            if((Math.abs(arr[l])) > (Math.abs(arr[r]))){
                ans[k++] = arr[l]*arr[l];
                l++;
            }
            else{
                ans[k++] = arr[r]*arr[r];
                r--;
            }
        }
        return ans;
    }

    //q5 summ two d matrix

    public static void SumdArray(int arr[][] , int r1,int c1, int arr2[][], int r2,int c2){
        if(r1!=r2 && c1!=c2){
            System.out.println("Wrong input");
            return;
        } 
        int sum [][] =  new int[r1][c1];
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                sum[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        printArray(sum);
    }

        //q6 summ two d matrix

    public static void multiplyMatrix(int arr[][] , int r1,int c1, int arr2[][], int r2,int c2){
        if(c1!=r2){
            System.out.println("Wrong input");
            return;
        } 
        int multiply[][] =  new int[r1][c1];
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                multiply[i][j] = arr[i][j] * arr2[i][j];
            }
        }
        printArray(multiply);
    }
    //input of 2d array
    // Scanner sc = new Scanner(System.in);
    //     System.out.println("enter no of rows  & col2: ");
    //     int r1 = sc.nextInt();
    //     int c1 = sc.nextInt();

    //     System.out.println("enter the first elementmatrix ;" );
    //     int arr[][] = new int[r1][c1];
    //     for(int i=0;i<r1;i++){
    //         for(int j=0;j<c1;j++){
    //             arr[i][j] = sc.nextInt();
    //         }
    //     }

    //     System.out.println("Second matrix");

    //     System.out.println("enter no of rows  & col: ");
    //     int r2 = sc.nextInt();
    //     int c2 = sc.nextInt();
    //     System.out.println("enter the second elementmatrix ;" );
    //     int arr2[][] = new int[r2][c2];
    //     for(int i=0;i<r2;i++){
    //         for(int j=0;j<c2;j++){
    //             arr2[i][j] = sc.nextInt();
    //         }
    //     }

    //     System.out.println("matrix1");
    //     printArray(arr);
    //     System.out.println("matrix 2");
    //     printArray(arr2);

    //     System.out.println("output ");
    //     SumdArray(arr,r1,c2,arr2,r2,c2);

        //q7 secondlargest - O(n)
        public static int secondLargest(int arr[]){
            int l = -1;
            int sl = -1;

            for(int i=0;i<arr.length;i++){
                if(arr[i]>l){
                    sl=l;
                    l = arr[i];
                }
                if(arr[i]!=l && arr[i] > sl){
                    sl = arr[i];
                }
            }
            return sl;
        }

        //remove duplicate inplace Sorted array
        public static int[] removeDuplicate(int arr[]){
            int i=0;
            int j= i+1;
            while (j<arr.length) {
                if(arr[i] == arr[j]) j++;
                else{
                    arr[i+1] = arr[j];
                    i++;
                    j++;
                }
            }
            return arr;
        }

    public static void main(String[] args) {
        int arr [] = {1,1,1,2,2,3,3,3,3,4,4};
        System.out.println(Arrays.toString(removeDuplicate(arr)));
    }
}