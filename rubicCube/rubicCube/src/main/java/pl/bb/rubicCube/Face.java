package pl.bb.rubicCube;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

import pl.bb.rubicCube.enums.FacePosition;
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
			faceStickers.put(stickerPosition, new Sticker(position.getDefaultColor()));
		}
		faceStickers = Collections.unmodifiableMap(faceStickers);
	}

	public FacePosition getPosition() {
		return facePosition;
	}

	public Sticker getSticker(StickerPosition position) {
		return faceStickers.get(position);
	}
}
