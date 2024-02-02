package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.utils.RandomNumberGenerator;

import java.util.*;

public class LottoService {

    List<Lotto> lottoList;
    Set<Integer> winningNumber;
    Integer bonusNumber;

    private static Map<Double, Rank> rankMap = new HashMap<Double, Rank>() {{
        put(3.0, Rank.FIFTH_RANK);
        put(4.0, Rank.FOURTH_RANK);
        put(5.0, Rank.THIRD_RANK);
        put(5.5, Rank.SECOND_RANK);
        put(6.0, Rank.FIRST_RANK);
    }};

    public LottoService(Integer lottoCount, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottoList = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            this.lottoList.add(new Lotto(RandomNumberGenerator.generateRandomNumberList()));
        }
        this.winningNumber = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank,Integer> calculateRank() {

    }

    private Rank judgeLottoRank(Lotto lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
        lottoSet.retainAll(winningNumber);

        if(lottoSet.size() < 3) return null;
        if(lottoSet.size() != 5) return rankMap.get(lottoSet.size());

        if(lotto.getNumbers().stream().anyMatch(num -> num.equals(bonusNumber))) return rankMap.get(5.5);
        return rankMap.get(5.0);
    }
}
