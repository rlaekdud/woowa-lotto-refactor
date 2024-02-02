package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void lottoSystem() {
        Integer price = InputView.getPrice();
        List<Lotto> lottos = generateLottos(price);

        OutputView.printLottoNumbers(lottos);

        List<Integer> winningNums = InputView.getWinningNum();
        Integer bonusNum = InputView.getBonusNum(winningNums);
        LottoService lottoService = new LottoService(lottos, winningNums, bonusNum);
        OutputView.printStatistics(lottoService.getRankStatistics());
        OutputView.printRateOfReturn(lottoService.rateOfReturn(price));
    }

    private static List<Lotto> generateLottos(Integer price) {
        int count = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(RandomNumberGenerator.generateRandomNumberList());
            lottos.add(lotto);
        }

        return lottos;
    }
}
