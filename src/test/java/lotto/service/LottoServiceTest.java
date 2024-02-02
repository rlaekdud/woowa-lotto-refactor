package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    void calculateRank() {
        List<Lotto> testLottoList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Lotto lotto = new Lotto(Arrays.asList(i+1, i+2, i+3, i+4, i+5, i+6));
            testLottoList.add(lotto);
        }
        LottoService lottoService = new LottoService(testLottoList, Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Map<Rank, Integer> rankResult = lottoService.calculateRank();
        System.out.println("rankResult = " + rankResult);
    }

    @Test
    void rateOfReturn() {
    }
}