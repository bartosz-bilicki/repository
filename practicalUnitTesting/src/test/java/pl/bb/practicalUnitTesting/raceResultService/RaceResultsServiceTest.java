package pl.bb.practicalUnitTesting.raceResultService;

import static com.googlecode.catchexception.CatchException.*;
import static org.mockito.Mockito.*;

import org.fest.assertions.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class RaceResultsServiceTest {

	private RaceResultsService serviceSut;
	private Message f1RaceMessageMock;
	private Message boatRaceMessageMock;
	private Client clientMock;

	@BeforeMethod
	public void init() {
		serviceSut = new RaceResultsService();

		f1RaceMessageMock = mock(Message.class);
		initMessageMock(f1RaceMessageMock, MessageCategory.F1_RACE);

		boatRaceMessageMock = mock(Message.class);
		initMessageMock(boatRaceMessageMock, MessageCategory.BOAT_RACE);

		clientMock = mock(Client.class);
	}

	private void initMessageMock(Message message, MessageCategory messageCategory) {
		when(message.getCategory()).thenReturn(messageCategory);
	}

	public void shouldSubscriberRecieveMessage() {
		// when
		serviceSut.addSubscriber(clientMock);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock).receive(f1RaceMessageMock);
	}

	public void shouldSubscribeTwice_ThrowException() {
		// when
		serviceSut.addSubscriber(clientMock);

		// when -then
		verifyException(serviceSut, AlreadySubscribedException.class).addSubscriber(clientMock);
	}

	public void shouldNotSubscribedClientDoNotRecieveMessage() {
		// given not subscribed client
		Client client2 = mock(Client.class);

		// when
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(client2, never()).receive(f1RaceMessageMock);
	}

	public void shouldUnsubscribedClientDoNotRecieveMessage() {
		// when
		serviceSut.addSubscriber(clientMock);
		serviceSut.removeSubscription(clientMock);
		serviceSut.send(f1RaceMessageMock);

		verify(clientMock, never()).receive(f1RaceMessageMock);
	}

	public void shouldUnsubcribingNotSubscribed_throwException() {
		// given
		Client client2 = mock(Client.class);

		// when
		verifyException(serviceSut, NotSubscribedException.class).removeSubscription(client2);
		NotSubscribedException ex = caughtException();

		Assertions.assertThat(ex.getClient()).isEqualTo(client2);
	}

	public void shouldNotRecieveMessage_WhenNotSubscribedToMessageCategory() {
		// when
		serviceSut.addSubscriber(clientMock, MessageCategory.BOAT_RACE);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock, never()).receive(f1RaceMessageMock);
	}

	public void shouldClientSubscribedToTwoCategories_RecieveMessagesForThoseCategories() {
		// when
		serviceSut.addSubscriber(clientMock, MessageCategory.BOAT_RACE);
		serviceSut.addSubscriber(clientMock, MessageCategory.F1_RACE);
		serviceSut.send(f1RaceMessageMock);
		serviceSut.send(boatRaceMessageMock);

		// then
		verify(clientMock).receive(f1RaceMessageMock);
		verify(clientMock).receive(boatRaceMessageMock);
	}
}
