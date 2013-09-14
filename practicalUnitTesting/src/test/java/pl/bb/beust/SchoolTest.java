package pl.bb.beust;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class SchoolTest {

	@Test(dataProvider = "sameFields")
	public void shouldBeEualSameFields(School s1, School s2) {
		assertThat(s1).isEqualTo(s2);
		assertThat(s2).isEqualTo(s1);
	}

	@DataProvider
	private Object[][] sameFields() {
		return new Object[][] { { new School("name", "nick"), new School("name", "nick") },
				{ new School(null, null), new School(null, null) } };
	}

	@Test(dataProvider = "sameNameDiffrentNicks")
	public void shouldBeEualSameName(School s1, School s2) {
		assertThat(s1).isEqualTo(s2);
		assertThat(s2).isEqualTo(s1);
	}

	@DataProvider
	private Object[][] sameNameDiffrentNicks() {
		return new Object[][] { { new School("name", "nick1"), new School("name", "nick2") },
				{ new School("name", null), new School("name", "nick2") },
				{ new School(null, null), new School(null, "nick2") } };
	}
}
