package pl.bb.bowlingKata;

public class Game {
	private int currentFrame;
	private final Frame[] frames = new Frame[10];

	public Game() {
		for (int i = 0; i < frames.length; i++) {
			frames[i] = new Frame();
		}
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < frames.length; i++) {
			Frame frame = frames[i];
			score += frame.score();
			score += getScoreBonusForSpare(i);
		}
		return score;
	}

	private int getScoreBonusForSpare(int spareFrameNumber) {
		if (spareFrameNumber == 9) {
			return 0;
		}
		return 2 * frames[spareFrameNumber + 1].score();
	}

	public void roll(int roll) {
		Frame frame = frames[currentFrame];
		if (frame.isStrike() && frame.isAfterRollTwo()) {
			currentFrame++;
			frame = frames[currentFrame];
			frame.rollOne(roll);
		} else if (frame.isAfterRollOne()) {
			frame.rollTwo(roll);
		} else {
			frame.rollOne(roll);
		}
	}

}
