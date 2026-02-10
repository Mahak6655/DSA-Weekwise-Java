import java.util.Arrays;

public class arrayDayOne{

    //q1 linear Search
    public static int linrarSearch(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    //q2 largest in array
    public static int largestArray(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    //q3 binary Search
    public static int binarySearch(int arr[],int k){
        int low =0;
        int high = arr.length;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] == k) return mid;
            else if( arr[mid]<= k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    //q4 reverse an array
    public static void reverseArray(int arr[]){
        int s = 0;
        int e = arr.length-1;

        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    //q5 max subarray 0(n3)
    public static void printSubarray(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                maxSum = Math.max(sum,maxSum);
            }
        }
        System.out.println(maxSum+ " ");
    }

    //q6 maxsubaaray 0(n2)
    public static void prefixArray(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                maxSum = Math.max(maxSum, sum);
        }
    }
    System.out.println(maxSum);
}

    //kedans algo
    public static void kedansAlgo(int arr[]){
        int cs =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            cs+=arr[i];
            max = Math.max(max, cs);
            if(cs<0){
                cs =0;
            }
        }
        System.out.println(max);
    }

    //q7 trapping RainWater 0(n)
    public static int trappedRAinwater(int arr[]){
        int n = arr.length;
        //left max
        int left[] = new int[arr.length];
        left[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            left[i] = Math.max(arr[i], left[i-1]);
        }

        //rightmax
        int right[] =new int[arr.length];
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(arr[i], right[i+1]);
        }

        int trappedWater =0;
        for(int i=0;i<n;i++){
            int waterlevel = Math.min(left[i],right[i]);
            trappedWater+=(waterlevel-arr[i]);
        }

        return trappedWater;
    }

    //q8 buysellstock 0(n)
    public static int buyAndSellStaock(int arr[]){
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int i=0;i<arr.length;i++){
            if(buyprice<arr[i]){
                int profit = arr[i] - buyprice;
                maxprofit = Math.max(profit,maxprofit);
            }else{
                buyprice = arr[i];
            }
        }
        return maxprofit;
    }

    //q9 calculate the sum of all element

    public static int calculateSum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    //q10 count the occurence of particular elemrnt 
    public static int countElement(int arr[],int x){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == x) count++;
        }
        return count;
    }

    //q11 last occurenece of an element 
    public static int lastOccurenece(int arr[],int x){
        int last =-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] == x){
                last = i;
                break;
            }
        }
        return last;
    }

    //q12 number of element strictly greater than x
    public static int greaterThanX(int arr[],int x){
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > x) count++;
        }
        return count;
    }

    //q13 ArraySorted or not
    public static boolean sortedOrNot(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }

    //q14 return an array that a=contin smallest and lasgest value of that array
    public static int [] smallestAndLargest(int arr[]){
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < smallest) smallest = arr[i];
            else if (arr[i] > largest) largest = arr[i];
        }
        return new int[] {smallest,largest};
    }

    //q15 kth smallest
    public static int kthSmallest(int arr[],int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    //q16 kth largest
    public static int kthlargest(int arr[],int k){
        Arrays.sort(arr);
        return arr[arr.length-k];
    }

    //q17Combine code for both kthsmallestand LArgest
    public static int kthSmallestandLargestElement(int[] arr, int k, boolean smallest){
        Arrays.sort(arr);
        if(smallest){
            return arr[k-1];
        }
        else{
            return arr[arr.length-k];
        }
    }

    //q18 target sum pair count
    public static int targetSumPairCount(int arr[], int t){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == t) count++;
            }
        }
        return count;
    }
     //q18 target sum triplet count
    public static int targetSumTripletCount(int arr[], int t){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == t) count++;
                }
            }
        }
        return count;
    }

    //q19 uniqueNumber(that appear only once)
    public static int appearOnces(int arr[]){
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans^=arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1,4,3,2,3};
        System.out.println(appearOnces(arr));
    }
}