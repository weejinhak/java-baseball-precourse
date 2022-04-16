package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.Result;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class BaseBallGame {

	private final Computer computer = new Computer();
	private final Player player = new Player();
	private final Result result = new Result();
	private boolean exit = false;
	private int strikeCount = 0;
	private int ballCount = 0;
	private static final String BALL = "BALL";
	private static final String STRIKE = "STRIKE";
	private static final String NOTHING = "NOTHING";
	private static final String GAME_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public void startGame() {
		//게임이 시작하면 컴퓨터에서 3개의 수를 만들고, 가져온다.
		computer.createBallNumber();
		System.out.println(computer.getBallSet());
		//시작하면 사용자한테 입력받기
		while (!exit) {
			player.inputAnswer();
			calculatorScore();
		}
	}


	public void calculatorScore() {
		ArrayList<Integer> computerNums = new ArrayList<>(computer.getBallSet());
		ArrayList<Integer> playerNums = new ArrayList<>(player.getBallSet());
		for (int i = 0; i < 3; i++) {
			String result = checkStrikeAndBall(playerNums.get(i), computerNums, i);
			if (BALL.equals(result)) {
				ballCount++;
				continue;
			}
			if (STRIKE.equals(result)) {
				strikeCount++;
			}
		}

	}

	public String checkStrikeAndBall(int playerNum, ArrayList<Integer> computerNums, int index) {
		for (int i = 0; i < 3; i++) {
			if (computerNums.get(i) == playerNum && i == index) {
				return STRIKE;
			}
			if (computerNums.get(i) == playerNum) {
				return BALL;
			}
		}
		return BALL;
	}



}
