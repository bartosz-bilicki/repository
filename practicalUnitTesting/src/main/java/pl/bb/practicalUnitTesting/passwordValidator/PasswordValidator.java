package pl.bb.practicalUnitTesting.passwordValidator;

public class PasswordValidator {

	private int minimumLenght;
	private int minimumAlfaNumeric;

	public void setMinimumLength(int length) {
		this.minimumLenght = length;
	}

	public void setMinimumAlfaNumeric(int alfaNumeric) {
		this.minimumAlfaNumeric = alfaNumeric;

	}

	public ValidationResult validate(String password) {
		if (minimumLenght > 0 && password.length() < minimumLenght) {
			return ValidationResult.FAIL_MINIMUM_LENGTH;
		}

		if (validadeAlfaNumeric(password) == false) {
			return ValidationResult.FAIL_ALFA_NUMERIC;
		}

		return ValidationResult.PASS;
	}

	private boolean validadeAlfaNumeric(String password) {
		if (minimumAlfaNumeric == 0) {
			return true;
		}

		int alfaNumericCount = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (isAlphaNumeric(c) == false) {
				alfaNumericCount++;
				if (alfaNumericCount >= minimumAlfaNumeric) {
					return true;
				}
			}

		}
		return false;
	}

	private boolean isAlphaNumeric(char c) {
		return Character.isAlphabetic(c) || Character.isDigit(c);

	}

}
