package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.*;

public class LottoService {

    private List<Lotto> lottoList;
    private Set<Integer> winningNumber;
    private Integer bonusNumber;
    private Map<Rank, Integer> rankStatistics;

    private static final Map<Double, Rank> rankMap = new HashMap<Double, Rank>() {{
        put(3.0, Rank.FIFTH_RANK);
        put(4.0, Rank.FOURTH_RANK);
        put(5.0, Rank.THIRD_RANK);
        put(5.5, Rank.SECOND_RANK);
        put(6.0, Rank.FIRST_RANK);
    }};

    public LottoService(List<Lotto> lottoList, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumber = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;

        this.rankStatistics = calculateRank();
    }


    private Map<Rank, Integer> calculateRank() {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottoList) {
            Rank rank = judgeLottoRank(lotto);
            if (rank != null) {
                rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
            }
        }

        return rankCount;
    }

    public Double rateOfReturn(Integer purchasePrice) {
        Integer returnPrice = calculateReturnPrice();
        return (returnPrice.doubleValue() / purchasePrice.doubleValue()) * 100.0;
    }

    private Integer calculateReturnPrice() {
        int totalReturnPrice = 0;
        for (Map.Entry<Rank, Integer> entry : rankStatistics.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            totalReturnPrice += rank.getReward() * count;
        }
        return totalReturnPrice;
    }

    private Rank judgeLottoRank(Lotto lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
        lottoSet.retainAll(winningNumber);

        if(lottoSet.size() < 3) return null;
        if(lottoSet.size() != 5) return rankMap.get((double)lottoSet.size());

        if(lotto.getNumbers().stream().anyMatch(num -> num.equals(bonusNumber))) return rankMap.get(5.5);
        return rankMap.get(5.0);
    }

    public Map<Rank, Integer> getRankStatistics() {
        return rankStatistics;
    }
}
