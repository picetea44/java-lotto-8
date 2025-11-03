package lotto.domain;

import java.util.HashSet;
import java.util.List;

import lotto.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_EMPTY);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NOT_SIX);
        }
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorMessages.LOTTO_OUT_OF_RANGE);
            }
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
