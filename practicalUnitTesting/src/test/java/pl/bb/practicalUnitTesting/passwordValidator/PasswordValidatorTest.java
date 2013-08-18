package pl.bb.practicalUnitTesting.passwordValidator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class PasswordValidatorTest {

	private PasswordValidator validator;

	@BeforeMethod
	public void setUp() {
		validator = new PasswordValidator();
	}

	@Test(dataProvider = "passingMinLenght")
	public void minimumLenghtPass(int length, String password) {
		validator.setMinimumLength(length);
		Assert.assertEquals(validator.validate(password), ValidationResult.PASS);
	}

	@DataProvider
	private Object[][] passingMinLenght() {
		return new Object[][] { { 0, "" }, { 0, "abcd" }, { 1, "a" }, { 1, "aa" }, { 2, "aa" }, { 10, "1234567890" },
				{ 1, "1234567890" } };
	}

	@Test(dataProvider = "failingMinLenght")
	public void minimumLenghtFail(int length, String password) {
		validator.setMinimumLength(length);
		Assert.assertEquals(validator.validate(password), ValidationResult.FAIL_MINIMUM_LENGTH);
	}

	@DataProvider
	private Object[][] failingMinLenght() {
		return new Object[][] { { 1, "", }, { 2, "a" }, { 10, "" }, { 10, "1267890" } };
	}

	@Test(dataProvider = "failingNonAlfaNumericCharacters")
	public void alfaNumericCharactersFail(int alfaNumeric, String password) {
		validator.setMinimumAlfaNumeric(alfaNumeric);
		Assert.assertEquals(validator.validate(password), ValidationResult.FAIL_ALFA_NUMERIC);
	}

	@DataProvider
	private Object[][] failingNonAlfaNumericCharacters() {
		return new Object[][] { { 1, "a" }, { 1, "abc" }, { 1, "abc123" }, { 2, "¹123avx" } };
	}

	@Test(dataProvider = "passNonAlfaNumericCharacters")
	public void alfaNumericCharactersPass(int alfaNumeric, String password) {
		validator.setMinimumAlfaNumeric(alfaNumeric);
		Assert.assertEquals(validator.validate(password), ValidationResult.PASS);
	}

	@DataProvider
	private Object[][] passNonAlfaNumericCharacters() {
		return new Object[][] { { 0, "" }, { 0, "abc" }, { 0, "¹êœæ" }, { 2, "!#" }, { 3, "!a#32*" } };
	}

}
