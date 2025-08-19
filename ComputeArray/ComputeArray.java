public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] computedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            if (value % 3 == 0) {
                // If the item is a multiple of 3, multiply it by 5
                computedArray[i] = value * 5;
            } else if (value % 3 == 1) {
                // If the item is a multiple of 3 + 1, increment it by 7
                computedArray[i] = value + 7;
            } else {
                // If the item is a multiple of 3 + 2, it stays unchanged
                computedArray[i] = value;
            }
        }

        return computedArray;
    }
}