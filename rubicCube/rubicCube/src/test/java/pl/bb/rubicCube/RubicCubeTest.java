package pl.bb.rubicCube;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.rubicCube.enums.FacePosition;

public class RubicCubeTest {

	RubicCube cube = new RubicCube();

	@BeforeMethod
	public void initCube() {
		this.cube = new RubicCube();
	}

	@Test
	public void notSolved() {
		Assert.assertFalse(cube.isSolved());
	}

	@Test
	public void cubeHasAll6Faces() {
		Assert.assertEquals(6, FacePosition.values().length);

		for (FacePosition facePosition : FacePosition.values()) {
			Face face = cube.getFace(facePosition);
			Assert.assertEquals(face.getPosition(), facePosition);
		}
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void cannotAddFace() {
		cube.faces.put(FacePosition.Bottom, new Face(FacePosition.Bottom));
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void cannotRemoveFace() {
		cube.faces.clear();
	}

}
