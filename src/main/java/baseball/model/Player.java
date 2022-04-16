package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Player extends Ball {

	private static final String INPUT_TEXT = "숫자를 입력해주세요 : ";
	private static String pattern = "^[1-9]*$"; //숫자만
	private static final int MAX_CNT = 3;

	public void inputAnswer() {
		System.out.print(INPUT_TEXT);
		String playerNum = Console.readLine();
		validInput(playerNum);
		super.ballSet = new HashSet<>();
		for (int i = 0; i < playerNum.length(); i++) {
			char currentCharacter = playerNum.charAt(i);
			ballSet.add(Character.getNumericValue(currentCharacter));
		}
	}

	public void validInput(String inputStr) {
		if (!isNumber(inputStr) || !isSize(inputStr) || !isDuplicate(inputStr)) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isNumber(String playerNum) {
		Pattern numberPattern = Pattern.compile(pattern);
		return numberPattern.matcher(playerNum).matches();
	}

	public boolean isSize(String playerNum) {
		if (playerNum.length() > MAX_CNT) {
			return false;
		}
		return true;
	}

	public boolean isDuplicate(String playerNum) {
		HashSet<Character> hashSet = new HashSet<>();
		for (char s : playerNum.toCharArray()) {
			hashSet.add(s);
		}
		if (playerNum.length() == hashSet.size()) {
			return true;
		}
		return false;
	}
}
