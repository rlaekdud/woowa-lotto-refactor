package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void isValidPrice() {
        assertDoesNotThrow(() -> Validator.isValidPrice("1000"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidPrice("100"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidPrice("abc"));
    }

    @Test
    void isValidWinningNum() {
        assertDoesNotThrow(() -> Validator.isValidWinningNum("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5,6,7"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5,a"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5,46"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5,0"));
        assertThrows(IllegalArgumentException.class, () -> Validator.isValidWinningNum("1,2,3,4,5,5"));
    }
}