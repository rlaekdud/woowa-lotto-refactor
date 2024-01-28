package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String resultTitleStr = "당첨 통계\n---";
    private static final String purchaseCountStr = "#개를 구매했습니다.";
    private static final String rateOfReturnStr = "총 수익률은 #%입니다.";

    public static void printLottoNumbers(List<Lotto> lottos) {

        System.out.println(purchaseCountStr.replace("#", String.valueOf(lottos.size())));

        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(Map<Rank, Integer> resultList) {
        System.out.println(resultTitleStr);
        for(Rank rank : Rank.getAllRanks()) {
            System.out.println(rank.getResultMessage() + " - " + resultList.get(rank) + "개");
        }
    }

    public static void printRateOfReturn(Double returnRate) {
        String formattedReturnRate = String.format("%.2f", returnRate);
        System.out.println(rateOfReturnStr.replace("#", formattedReturnRate));
    }
}
