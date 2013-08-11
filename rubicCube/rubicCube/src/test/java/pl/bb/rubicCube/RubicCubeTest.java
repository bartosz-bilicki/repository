package pl.bb.rubicCube;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.rubicCube.RubicCube;

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

	}

	@Test
	public void hasNineFaces() {

	}

}
