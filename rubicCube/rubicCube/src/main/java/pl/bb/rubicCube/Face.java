package pl.bb.rubicCube;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

import pl.bb.rubicCube.enums.FacePosition;
import pl.bb.rubicCube.enums.StickerColor;
import pl.bb.rubicCube.enums.StickerPosition;

public class Face {

	private final FacePosition facePosition;
	private Map<StickerPosition, Sticker> faceStickers;

	public Face(FacePosition position) {
		this.facePosition = position;
		initFaceStickersWithDefaultFaceColor();
	}

	private void initFaceStickersWithDefaultFaceColor() {
		faceStickers = new Hashtable<StickerPosition, Sticker>();
		for (StickerPosition stickerPosition : StickerPosition.values()) {
			faceStickers.put(stickerPosition, new Sticker(facePosition.getDefaultColor()));
		}
		faceStickers = Collections.unmodifiableMap(faceStickers);
	}

	public FacePosition getPosition() {
		return facePosition;
	}

	public Sticker getSticker(StickerPosition position) {
		return faceStickers.get(position);
	}

	public StickerColor getColor(StickerPosition position) {
		return getSticker(position).getColor();
	}

	public void rotate(HowMuchRotate howMuch) {
		// for all non-center elements, swap those element with next element
	}

	public static enum HowMuchRotate {
		LEFT(-1), LEFT2(-2), RIGHT(1), RIGHT2(2), RIGHT3(3);

		private final int howMuch;

		HowMuchRotate(int howMuch) {
			this.howMuch = howMuch;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facePosition == null) ? 0 : facePosition.hashCode());
		result = prime * result + ((faceStickers == null) ? 0 : faceStickers.hashCode());
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
		Face other = (Face) obj;
		if (facePosition != other.facePosition)
			return false;
		if (faceStickers == null) {
			if (other.faceStickers != null)
				return false;
		} else if (!faceStickers.equals(other.faceStickers))
			return false;
		return true;
	}

}
