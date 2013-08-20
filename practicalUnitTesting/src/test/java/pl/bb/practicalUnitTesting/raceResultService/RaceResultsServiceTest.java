package pl.bb.practicalUnitTesting.raceResultService;

import static com.googlecode.catchexception.CatchException.*;
import static org.mockito.Mockito.*;

import org.fest.assertions.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class RaceResultsServiceTest {

	private RaceResultsService service;
	Message message;
	Client client;

	@BeforeMethod
	public void init() {
		service = new RaceResultsService();
		message = mock(Message.class);
		client = mock(Client.class);
	}

	public void shouldNotSubscribedClientDoNotRecieveMessage() {
		// given
		Client client2 = mock(Client.class);

		// when
		service.addSubscriber(client);
		service.send(message);

		// then
		verify(client).receive(message);
		verify(client2, never()).receive(message);
	}

	public void shouldUnsubscribedClientDoNotRecieveMessage() {
		// when
		service.addSubscriber(client);
		service.removeSubscriber(client);
		service.send(message);

		verify(client, never()).receive(message);
	}

	public void shouldSubscriberRecieveMessageOnce() {
		// when
		service.addSubscriber(client);
		service.addSubscriber(client);
		service.send(message);

		// then
		verify(client).receive(message);
	}

	public void shouldUnsubcribingNotSubscribed_throwException() {
		// given
		Client client2 = mock(Client.class);

		// when
		verifyException(service, NotSubscribedException.class).removeSubscriber(client2);
		NotSubscribedException ex = caughtException();

		Assertions.assertThat(ex.getClient()).isEqualTo(client2);
	}
}
