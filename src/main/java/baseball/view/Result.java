package baseball.view;

public class Result {

	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final String ALL_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public void resultPrint(int strikeScore, int ballScore) {
		System.out.println(getResultString(strikeScore, ballScore));
		if (strikeScore == 3) {
			System.out.println(ALL_STRIKE_SENTENCE);
		}
	}

	private String getResultString(int strikeScore, int ballScore) {
		if (strikeScore == 0 && ballScore == 0) {
			return NOTHING;
		}
		StringBuilder sb = new StringBuilder();
		if (ballScore > 0) {
			sb.append(ballScore).append(BALL);
		}
		if (strikeScore > 0) {
			sb.append(strikeScore).append(STRIKE);
		}
		return sb.toString();
	}
}
