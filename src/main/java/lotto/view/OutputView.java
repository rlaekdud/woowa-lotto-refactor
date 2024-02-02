package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String resultTitleStr = "\n당첨 통계\n---";
    private static final String purchaseCountStr = "\n#개를 구매했습니다.";
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
            Integer temp = resultList.get(rank);
            if(temp == null) temp = 0;
            System.out.println(rank.getResultMessage() + " - " + temp + "개");
        }
    }

    public static void printRateOfReturn(Double returnRate) {
        Double halfUpRate = Math.round(returnRate * 10) / 10.0;
        String formattedReturnRate = halfUpRate.toString();
        System.out.println(rateOfReturnStr.replace("#", formattedReturnRate));
    }
}
