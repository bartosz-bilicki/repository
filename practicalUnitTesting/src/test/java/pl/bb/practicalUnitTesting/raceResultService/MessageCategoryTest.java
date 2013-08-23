package pl.bb.practicalUnitTesting.raceResultService;

import org.testng.annotations.Test;

public class MessageCategoryTest {

	@Test()
	public void valueAllTest() {
		MessageCategory.valueOf(MessageCategory.ALL.name());
	}
}
