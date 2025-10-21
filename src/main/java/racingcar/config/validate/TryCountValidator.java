package racingcar.config.validate;

public record TryCountValidator() {
    public void validate(int tryCount) {
        validatePositiveNum(tryCount);
    }

    private void validatePositiveNum(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("Number of tries must be a positive integer.");
        }
    }
}
