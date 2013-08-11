package pl.bb.rubicCube;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	public void hasFacesWithAllSides() {
		for (Side side : Side.values()) {
			Face face = cube.getFace(side);
			Assert.assertEquals(face.getSide(), side);
		}
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void cannotAddFace() {
		cube.faces.put(Side.Bottom, new Face(Side.Bottom));
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void cannotRemoveFace() {
		cube.faces.clear();
	}

	@Test
	public void hasNineFaces() {

	}

}
