public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        return VerifySquenceOfBST(sequence, 0, sequence.length);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int length) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int root = sequence[start + length - 1];
        int i = start;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {
            left = VerifySquenceOfBST(sequence, start, i - start);
        }
        boolean right = true;
        if (i < length - 1) {
            right = VerifySquenceOfBST(sequence, i, length - i - 1);
        }
        return (left && right);
    }
}
