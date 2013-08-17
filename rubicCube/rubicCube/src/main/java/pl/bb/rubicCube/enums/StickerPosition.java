package pl.bb.rubicCube.enums;

public enum StickerPosition {
	NW, N, NE, E, SE, S, SW, W, CENTER;

	public StickerPosition getNext() {
		switch (this) {
		case NW:
			return N;
		case N:
			return NE;
		case NE:
			return E;
		case E:
			return SE;
		case SE:
			return S;
		case S:
			return SW;
		case SW:
			return W;
		case W:
			return NW;
		case CENTER:
			return CENTER;
		default:
			throw new IllegalArgumentException("No next element for" + this);
		}

	}
}
