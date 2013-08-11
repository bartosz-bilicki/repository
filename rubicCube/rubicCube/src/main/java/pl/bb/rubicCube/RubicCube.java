package pl.bb.rubicCube;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

import pl.bb.rubicCube.enums.FacePosition;

public class RubicCube {

	Map<FacePosition, Face> faces;

	public RubicCube() {
		initalizeFaces();
	}

	private void initalizeFaces() {
		Map<FacePosition, Face> faces = new Hashtable<FacePosition, Face>();
		for (FacePosition facePosition : FacePosition.values()) {
			faces.put(facePosition, new Face(facePosition));
		}
		this.faces = Collections.unmodifiableMap(faces);
	}

	public boolean isSolved() {
		// TODO Auto-generated method stub
		return false;
	}

	public Face getFace(FacePosition facePosition) {
		return faces.get(facePosition);

	}

}
