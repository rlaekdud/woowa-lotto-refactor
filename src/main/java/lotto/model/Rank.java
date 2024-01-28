package lotto.model;

public enum Rank {

    FIRST_RANK(2000000000),
    SECOND_RANK(30000000),
    THIRD_RANK(1500000),
    FOURTH_RANK(50000),
    FIFTH_RANK(5000);

    Integer reward;

    Rank(Integer reward) {
        this.reward = reward;
    }
}
