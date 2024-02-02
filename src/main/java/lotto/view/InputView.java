package lotto.view;

import lotto.utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String getPriceStr = "구입금액을 입력해 주세요.";
    private static final String getWinningNumStr = "\n당첨 번호를 입력해 주세요.";
    private static final String getBonusNumStr = "\n보너스 번호를 입력해 주세요.";

    public static Integer getPrice() {

        System.out.println(getPriceStr);
        String inputString = readLine();

        Validator.isValidPrice(inputString);

        return toInteger(inputString);
    }

    public static List<Integer> getWinningNum() {
        System.out.println(getWinningNumStr);
        String inputString = readLine();

        Validator.isValidWinningNum(inputString);

        return toIntegerList(inputString);
    }

    public static Integer getBonusNum(List<Integer> winningNums) {
        System.out.println(getBonusNumStr);
        String inputString = readLine();

        Validator.isValidBonusNum(inputString, winningNums);

        return toInteger(inputString);
    }

    private static Integer toInteger(String numStr) {
        return Integer.parseInt(numStr);
    }

    private static List<Integer> toIntegerList(String numStr) {
        return Arrays.stream(numStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
