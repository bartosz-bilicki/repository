package pl.bb.rubicCube;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.rubicCube.enums.FacePosition;
import pl.bb.rubicCube.enums.StickerPosition;

public class FaceTest {
	RubicCube cube = new RubicCube();

	@BeforeMethod
	public void initCube() {
		this.cube = new RubicCube();
	}

	@Test
	public void faceHasAll9Stickers() {
		Assert.assertEquals(9, StickerPosition.values().length);

		Face face = new Face(FacePosition.Bottom);
		for (StickerPosition positition : StickerPosition.values()) {
			Sticker s = face.getSticker(positition);
			Assert.assertNotNull(s.getColor());
		}

	}
}
