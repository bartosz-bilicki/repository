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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sticker other = (Sticker) obj;
		if (color != other.color)
			return false;
		return true;
	}

}
