package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;

public class BaseBallGame {

	private final Computer computer = new Computer();
	private final Player player = new Player();
	private boolean exit = false;

	public void startGame() {
		//게임이 시작하면 컴퓨터에서 3개의 수를 만들고, 가져온다.
		computer.createBallNumber();

		//시작하면 사용자한테 입력받기
		while (!exit) {
			player.inputAnswer();
		}

	}
}
