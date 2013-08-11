package pl.bb.rubicCube;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class RubicCube {

	Map<Side, Face> faces;

	public RubicCube() {
		initalizeFaces();
	}

	private void initalizeFaces() {
		Map<Side, Face> faces = new Hashtable<Side, Face>();
		for (Side side : Side.values()) {
			faces.put(side, new Face(side));
		}
		this.faces = Collections.unmodifiableMap(faces);
	}

	public boolean isSolved() {
		// TODO Auto-generated method stub
		return false;
	}

	public Face getFace(Side side) {
		return faces.get(side);

	}

}
