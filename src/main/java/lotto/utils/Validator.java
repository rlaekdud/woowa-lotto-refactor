package lotto.utils;

import lotto.exceptions.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isValidPrice(String priceStr) {

        if(!isNumericStr(priceStr)) throw new IllegalArgumentException(ErrorMessage.NOT_NUM_INPUT.getMessage());

        if(!isDivideByThousand(priceStr)) throw new IllegalArgumentException(ErrorMessage.CANNOT_DIVIDE_BY_THOUSAND.getMessage());

    }

    public static void isValidWinningNum(String allWinningNumStr) {
        List<String> winningNumberStrs = List.of(allWinningNumStr.split(","));
        if(winningNumberStrs.size() != 6) throw new IllegalArgumentException(ErrorMessage.INVALID_NUM_COUNT.getMessage());
        for(String winningNumberStr : winningNumberStrs) {
            if(!isNumericStr(winningNumberStr)) throw new IllegalArgumentException(ErrorMessage.NOT_NUM_INPUT.getMessage());
            if(isOutOfRange(winningNumberStr)) throw new IllegalArgumentException(ErrorMessage.NUM_OUT_OF_RANGE.getMessage());
        }
        if(isDuplicated(winningNumberStrs)) throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUM.getMessage());

    }

    public static void isValidBonusNum(String bonusNumStr) {
        if(!isNumericStr(bonusNumStr)) throw new IllegalArgumentException(ErrorMessage.NOT_NUM_INPUT.getMessage());
        if(!isOutOfRange(bonusNumStr)) throw new IllegalArgumentException(ErrorMessage.NUM_OUT_OF_RANGE.getMessage());
    }

    private static boolean isNumericStr(String str) {
        return str.matches("\\d+");
    }

    private static boolean isDivideByThousand(String str) {
        Integer temp = Integer.parseInt(str);
        if(temp % 1000 != 0) return false;
        return true;
    }

    private static boolean isDuplicated(List<String> strList) {
        Set<String> set = new HashSet<>(strList);
        return set.size() < strList.size();
    }

    private static boolean isOutOfRange(String str) {
        Integer temp = Integer.parseInt(str);
        return (temp > 45 || temp < 1);
    }
}
