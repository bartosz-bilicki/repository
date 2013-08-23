package pl.bb.practicalUnitTesting.mailClient;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

public class MailClientTest {
	private static final String ANY = "ANY";

	@Test
	public void shouldEmailServerSendEmail() throws Exception {
		// given
		EmailServer emailServerMock = mock(EmailServer.class);
		MailClient mailClientSut = new MailClient(emailServerMock);

		// when
		mailClientSut.sendEmail(ANY, ANY, ANY);

		Email email = new Email(ANY, ANY, ANY);

		// then
		/*
		 * lame because creates real email and verifies against it. relies on
		 * equals of that email test many at once (email, equals of email)
		 */
		verify(emailServerMock).sendEmail(eq(email));
	}
}
