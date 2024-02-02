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

        LottoService lottoService = new LottoService(lottos, InputView.getWinningNum(), InputView.getBonusNum());
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
