package lotto.utils;

import lotto.exceptions.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isValidPrice(String priceStr) {
        isNumericStr(priceStr);
        isDivideByThousand(priceStr);
    }

    public static void isValidWinningNum(String allWinningNumStr) {
        List<String> winningNumberStrs = List.of(allWinningNumStr.split(","));
        if(winningNumberStrs.size() != 6) throw new IllegalArgumentException(ErrorMessage.INVALID_NUM_COUNT.getMessage());
        for(String winningNumberStr : winningNumberStrs) {
            isNumericStr(winningNumberStr);
            isOutOfRange(winningNumberStr);
        }
        isDuplicated(winningNumberStrs);
    }

    public static void isValidBonusNum(String bonusNumStr) {
        isNumericStr(bonusNumStr);
        isOutOfRange(bonusNumStr);
    }

    private static void isNumericStr(String str) {
        if(!str.matches("\\d+")) throw new IllegalArgumentException(ErrorMessage.NOT_NUM_INPUT.getMessage());
    }

    private static void isDivideByThousand(String str) {
        Integer temp = Integer.parseInt(str);
        if(temp % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.CANNOT_DIVIDE_BY_THOUSAND.getMessage());
    }

    private static void isDuplicated(List<String> strList) {
        Set<String> set = new HashSet<>(strList);
        if(set.size() < strList.size()) throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUM.getMessage());
    }

    private static void isOutOfRange(String str) {
        Integer temp = Integer.parseInt(str);
        if(!(temp > 45 || temp < 1)) throw new IllegalArgumentException(ErrorMessage.NUM_OUT_OF_RANGE.getMessage());
    }
}
