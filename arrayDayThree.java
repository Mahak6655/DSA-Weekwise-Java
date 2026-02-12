import java.util.*;
public class arrayDayThree {

    //print matrix.
    public static void printMatrix(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //q1 transpose matrix
    public static void transposeMatrix(int arr[][],int r, int c){
        for(int i=0;i<c;i++){
            for(int j=i+1;j<r;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    //q2 pascal triangle
    public static int[][] pascalTriangle(int n){
        int ans [][] = new int[n][];

        for(int i=0;i<n;i++){

            ans[i] = new int[i+1];

            ans[i][0] = ans[i][i] = 1;

            for(int j=1;j<i;j++){
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }
        }
        return ans;
    }

    //q3 PrintsprialMatrix
    public static void printSprial(int matrix[][],int r,int c){
        int topRow = 0, bottomRow = r-1, leftCol = 0, rightCol = c-1;
        int totaElement = 0;

        while (totaElement<r*c) {
            
            //top -> lefcol to rightcol
            for(int j=leftCol;j<=rightCol && totaElement<r*c;j++){
                System.out.print(matrix[topRow][j]+" ");
                totaElement++;
            }
            topRow++;

            //right -> top to bottom
            for(int i=topRow;i<=bottomRow && totaElement<r*c;i++){
                System.out.print(matrix[i][rightCol]+" ");
                totaElement++;
            }
            rightCol--;
            //bottom -> right to left

            for(int j=rightCol;j>=leftCol  && totaElement<r*c;j--){
                System.out.print(matrix[bottomRow][j]+" ");
                totaElement++;
            }
            bottomRow--;

            //left -> bottom to top
            for(int i=bottomRow;i>=topRow  && totaElement<r*c;i--){
                System.out.print(matrix[i][leftCol]+" ");
                totaElement++;
            }
            leftCol++;
        }
    }

    //q3 assign number to sprialMatrix
    public static int [][] AssignNumSprial(int n){
        int matrix [][] = new int[n][n];
        int topRow = 0, bottomRow = n-1, leftCol = 0, rightCol = n-1;
        int curr = 1;

        while (curr <= n*n) {
            
            //top -> lefcol to rightcol
            for(int j=leftCol;j<=rightCol && curr <= n*n;j++){
                matrix[topRow][j] = curr++;
            }
            topRow++;

            //right -> top to bottom
            for(int i=topRow;i<=bottomRow && curr <= n*n ;i++){
                matrix[i][rightCol] = curr++;
            }
            rightCol--;
            //bottom -> right to left

            for(int j=rightCol;j>=leftCol && curr <= n*n;j--){
                matrix[bottomRow][j] = curr++;
            }
            bottomRow--;

            //left -> bottom to top
            for(int i=bottomRow;i>=topRow && curr <= n*n ;i--){
                matrix[i][leftCol] = curr++;
            }
            leftCol++;
        }
        return matrix;
    }

    //q4 move zeroesAtEnd
    public static int[] moveZeroesAtEnd(int arr[]){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }

        if(j==-1) return arr;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    //q5 FindMissingNum
    public static int missingNumber(int arr[]){
        int n = arr.length;
        int diff = 0;
        int sum = (n+1)*(n+2)/2;
        for(int i=0;i<arr.length;i++){
            diff+=arr[i];
        }
        return sum-diff;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        System.out.println(missingNumber(arr));
            
    }
}
