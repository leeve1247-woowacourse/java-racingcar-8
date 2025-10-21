package racingcar.config.validate;

public record TryCountValidator() {
    public void check(int tryCount) {
        checkIfNegative(tryCount);
    }

    private void checkIfNegative(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("Number of tries must be a positive integer.");
        }
    }
}
