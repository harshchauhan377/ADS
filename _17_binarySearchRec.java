
public class _17_binarySearchRec {

    public static void main(String[] args) {
        int[] arr = {1, 23, 54, 85, 103};
        int target = 85;
        int ans = bSearch(arr, 0, arr.length - 1, target);
        System.out.println("target at Index : " + ans);
    }

    public static int bSearch(int arr[], int l, int h, int target) {
        if (l > h) {
            return -1;
        }

        int mid = l + (h - l) / 2;

        if (arr[mid] == target) {
            return mid;
        }else if (arr[mid] > target) {
            return bSearch(arr, l, mid - 1, target);
        }else {
            return bSearch(arr, mid + 1, h, target);
        }
    }
}

