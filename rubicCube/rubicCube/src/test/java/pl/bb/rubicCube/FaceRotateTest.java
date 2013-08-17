package pl.bb.rubicCube;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.bb.rubicCube.Face.HowMuchRotate;
import pl.bb.rubicCube.enums.FacePosition;

public class FaceRotateTest {

	@Test
	public void rotateRightDoesSomething() {
		Face face = new Face(FacePosition.Bottom);
		face.rotate(HowMuchRotate.RIGHT);

		Face face2 = new Face(FacePosition.Bottom);
		Assert.assertNotEquals(face, face2);
	}

	@Test
	public void rotateRight4DoesNothing() {
		Face face = new Face(FacePosition.Bottom);
		face.rotate(HowMuchRotate.RIGHT);
		face.rotate(HowMuchRotate.RIGHT);
		face.rotate(HowMuchRotate.RIGHT);
		face.rotate(HowMuchRotate.RIGHT);

		Face face2 = new Face(FacePosition.Bottom);
		Assert.assertEquals(face, face2);
	}
}
