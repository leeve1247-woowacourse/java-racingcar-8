package racingcar;

public class TestUtil {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    /**
     * Converts the given integer to a binary representation and returns a movement pattern
     * based on each bit.
     *
     * <p>
     * - Each bit in the binary string represents a vehicle movement.<br>
     * - 1 → move forward (FORWARD)<br>
     * - 0 → stop (STOP)
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: 4 (binary: 100) → Output: [4, 3, 3]</li>
     *   <li>Input: 3 (binary: 11) → Output: [4, 3]</li>
     *   <li>Input: 5 (binary: 101) → Output: [4, 3, 4]</li>
     * </ul>
     *
     * @param valueOrder the integer value used to generate the movement pattern
     * @return an array of integers representing the movement pattern based on each bit
     */
    public Integer[] movementPattern(int valueOrder) {
        return Integer.toBinaryString(valueOrder)
                .chars()
                .map(c -> (c - '0') == 1 ? MOVING_FORWARD : STOP)
                .boxed()
                .toArray(Integer[]::new);
    }
}
