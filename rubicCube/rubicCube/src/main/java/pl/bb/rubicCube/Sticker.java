package pl.bb.rubicCube;

import pl.bb.rubicCube.enums.StickerColor;

public class Sticker {
	private StickerColor color;

	public Sticker(StickerColor color) {
		this.color = color;
	}

	public void setColor(StickerColor color) {
		this.color = color;
	}

	public StickerColor getColor() {
		return color;
	}

}
