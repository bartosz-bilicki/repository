package pl.bb.rubicCube.enums;

import static pl.bb.rubicCube.enums.StickerColor.Blue;
import static pl.bb.rubicCube.enums.StickerColor.Green;
import static pl.bb.rubicCube.enums.StickerColor.Orange;
import static pl.bb.rubicCube.enums.StickerColor.Red;
import static pl.bb.rubicCube.enums.StickerColor.White;
import static pl.bb.rubicCube.enums.StickerColor.Yellow;

public enum FacePosition {
	Top(Blue), Bottom(Green), North(Orange), South(Red), West(White), East(
			Yellow);

	private final StickerColor defaultColor;

	FacePosition(StickerColor defaultColor) {
		this.defaultColor = defaultColor;
	}

	public StickerColor getDefaultColor() {
		return defaultColor;
	}
}