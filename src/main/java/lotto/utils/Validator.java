package lotto.utils;

import lotto.exceptions.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Validator {
    public static void isValidPrice(String priceStr) {
        isNumericStr(priceStr);
        isDivideByThousand(priceStr);
    }

    public static void isValidLottoNum(List<Integer> lottoNums) {
        isValidSize(lottoNums);
        lottoNums.forEach(Validator::isOutOfRange);
        isDuplicated(lottoNums);
    }

    public static void isValidWinningNum(String allWinningNumStr) {
        List<String> winningNumberStrs = List.of(allWinningNumStr.split(","));
        isValidSize(winningNumberStrs);

        winningNumberStrs.stream()
                .peek(Validator::isNumericStr)
                .map(Integer::parseInt)
                .forEach(Validator::isOutOfRange);

        isDuplicated(winningNumberStrs);
    }

    public static void isValidBonusNum(String bonusNumStr) {
        isNumericStr(bonusNumStr);
        isOutOfRange(Integer.parseInt(bonusNumStr));
    }

    private static void isNumericStr(String str) {
        if(!str.matches("\\d+")) throw new IllegalArgumentException(ErrorMessage.NOT_NUM_INPUT.getMessage());
    }

    private static void isDivideByThousand(String str) {
        Integer temp = Integer.parseInt(str);
        if(temp % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.CANNOT_DIVIDE_BY_THOUSAND.getMessage());
    }

    private static <T> void isValidSize(List<T> nums) {
        if(nums.size() != 6) throw new IllegalArgumentException(ErrorMessage.INVALID_NUM_COUNT.getMessage());
    }

    private static <T> void isDuplicated(List<T> numList) {
        Set<T> set = new HashSet<>(numList);
        if(set.size() < numList.size()) throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUM.getMessage());
    }

    private static void isOutOfRange(Integer num) {
        if(num > 45 || num < 1) throw new IllegalArgumentException(ErrorMessage.NUM_OUT_OF_RANGE.getMessage());
    }
}
