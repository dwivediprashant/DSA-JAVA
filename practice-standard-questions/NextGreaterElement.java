
public class NextGreaterElement {

    public static int[] getNGE(int[] ele) {
        int n = ele.length;
        int[] nge = new int[n];
        for (int i = 0; i < n - 1; i++) {
            // find nge for each ele
            for (int j = i + 1; j < n; j++) {
                if (ele[j] > ele[i]) {
                    nge[i] = ele[j];
                    break;
                }
            }
        }
        return nge;
    }

    public static int[] optimizeNGE(int[] ele) {
        int n = ele.length;
        int[] nge = new int[n];
        int rightMax = ele[n - 1];
        nge[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (ele[i + 1] > ele[i]) {
                nge[i] = ele[i + 1];
                rightMax = ele[i + 1];
            } else if (rightMax > ele[i]) {
                nge[i] = rightMax;
            } else {
                nge[i] = 0;
                rightMax = ele[i];
            }
        }
        return nge;
    }

    public static void main(String[] args) {

        int[] ele = { 12, 11, 9, 15, -3, -11, 23, 10 };

        int[] nge = getNGE(ele);
        int[] ngeOp = optimizeNGE(ele);
        System.out.println("Optimize solution : ");
        for (int i = 0; i < ele.length; i++) {
            System.out.print(ngeOp[i] + " ");
        }
        // 0 means no next greater value exist for ith ele
        System.out.println();
        System.out.println("Brute force :");
        for (int i = 0; i < ele.length; i++) {
            System.out.print(nge[i] + " ");
        }
    }
}
