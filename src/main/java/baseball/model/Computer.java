package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Computer extends Ball {

	private static final int BALL_CNT = 3;
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 9;

	public void createBallNumber() {
		super.ballSet = new HashSet<>();
		while (ballSet.size() < BALL_CNT) {
			ballSet.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
		}
	}
}
