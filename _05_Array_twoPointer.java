public class _05_Array_twoPointer{
    public static void main(String[] args){
        int[] arr = {10 , 2 , 5 , 9,  7};
        // Check if array has 2 no equal to target
        int target  = 12;
        System.out.println("Check if array has 2 no equal to target : "+hasPair(arr,target));

        // move zeros to End 
        int [] arr2 = {1,0,0,3,12};
        moveZerosToEnd(arr2);
        for(int n : arr2){
            System.out.print(n+" ");
        }

        // merge sorted array 
        System.out.println("\n sorted merged array : ");
        int a[]= {1,3,5,7};
        int b[]= {0,2,4,5,8,9};
        int c[] = mergeSortedArray(a, b);
        for(int n : c){
            System.out.print(n+" ");
        }


        // Container With Most Water
        int[] arr3 = {10 , 2 , 5 , 9,  7};
        System.out.println("\n max water : "+containerMaxWater(arr3));

        // Minimum Size Subarray Sum 
        int[] arr4 = {2,3,1,2,4,3}; int target1 = 7 ;
        System.out.println("\n min size subarray sum : "+minSubArrayLen(arr4,target1));

    }

    public static boolean hasPair(int [] arr , int target){
        int i =0; int j = arr.length-1;

        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum==target) return true;
            if(sum < target ) i++;
            else j--;
        }
        return false;
    }


    public static void moveZerosToEnd(int [] arr){
        int l = 0 , r = 0 ;
        // dono ko zero kar ke rak diya abhi 
        // 1,0,0,3,12     || l=0 arr[l] = 1 , r = 0 arr[r]= 1
        // yaha par abhi swap hoga swap se same result aahyega  1,0,0,3,12  , fir jis se (l++ , r++) ho jayega 
        // fir apne pe l = 1 arr[l] = 0 || r = 1 hoga arr[r]=0
        // tho l tho same hi rahega but loop run hoga r ke sath fir r ko non zero value milegi 
        // fir l= 1 , r= 3 ,,, fir swap hoga ,,, fir arr = 1,3,0,0,12 ,, l++ , l =2
        // fir l= 2 , r = 4 ,, fir swap hoga ,,, fir arr = 1,3,12,0,0 
        // code finisdhed   
        while(r < arr.length){
            if(arr[r]!=0){
                int temp = arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
            }
            r++;
        }

    }


    public static int[] mergeSortedArray(int [] a , int [] b){
        int [] m = new int[a.length+b.length];

        int i = 0 , j =0 , k = 0 ;

        while(i< a.length && j< b.length){
            if(a[i]<=b[j]){
                m[k++]=a[i++];
            }else{
                m[k++]=b[j++];
            }
        }

        while(i<a.length){
            m[k++]=a[i++];
        }
        while(j<b.length){
            m[k++]=b[j++];
        }

        return m;
    }

    public static int containerMaxWater(int[]arr){
        int left = 0; int right = arr.length-1;
        int maxW = 0;

        while(left <right ){
            int h = Math.min(arr[left],arr[right]);
            int width = right - left ;
            int area = h * width;

            maxW = Math.max(maxW , area);
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxW;
    }

    public static int minSubArrayLen(int[] nums,int target){
        int left = 0 ; int minL = Integer.MAX_VALUE;
        int sum =0 ;
        for(int right = 0; right <nums.length ; right++){
            sum += nums[right];
            while(sum >=target){
                minL = Math.min(minL,right-left+1);
                sum-=nums[left++];
            }
        }
        return minL == Integer.MAX_VALUE ? 0 : minL ;
    }
}