package pl.bb.practicalUnitTesting.raceResultService;

import static com.googlecode.catchexception.CatchException.*;
import static org.mockito.Mockito.*;

import org.fest.assertions.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class RaceResultsServiceTest {

	private RaceResultsService serviceSut;
	Message f1RaceMessageMock;
	Client clientMock;

	@BeforeMethod
	public void init() {
		serviceSut = new RaceResultsService();

		f1RaceMessageMock = mock(Message.class);
		when(f1RaceMessageMock.getCategory()).thenReturn(MessageCategory.F1_RACE);

		clientMock = mock(Client.class);
	}

	public void shouldNotSubscribedClientDoNotRecieveMessage() {
		// given
		Client client2 = mock(Client.class);

		// when
		serviceSut.addSubscriber(clientMock);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock).receive(f1RaceMessageMock);
		verify(client2, never()).receive(f1RaceMessageMock);
	}

	public void shouldUnsubscribedClientDoNotRecieveMessage() {
		// when
		serviceSut.addSubscriber(clientMock);
		serviceSut.removeSubscriber(clientMock);
		serviceSut.send(f1RaceMessageMock);

		verify(clientMock, never()).receive(f1RaceMessageMock);
	}

	public void shouldSubscriberRecieveMessageOnce() {
		// when
		serviceSut.addSubscriber(clientMock);
		serviceSut.addSubscriber(clientMock);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock).receive(f1RaceMessageMock);
	}

	public void shouldUnsubcribingNotSubscribed_throwException() {
		// given
		Client client2 = mock(Client.class);

		// when
		verifyException(serviceSut, NotSubscribedException.class).removeSubscriber(client2);
		NotSubscribedException ex = caughtException();

		Assertions.assertThat(ex.getClient()).isEqualTo(client2);
	}

	public void subcribeToCategoryTest() {
		// given
		when(f1RaceMessageMock.getCategory()).thenReturn(MessageCategory.BOAT_RACE);

		// when
		serviceSut.addSubscriber(clientMock, MessageCategory.BOAT_RACE);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock).receive(f1RaceMessageMock);
	}

	public void subcribeToAnotherCategoryTest() {
		// when
		serviceSut.addSubscriber(clientMock, MessageCategory.BOAT_RACE);
		serviceSut.send(f1RaceMessageMock);

		// then
		verify(clientMock, never()).receive(f1RaceMessageMock);
	}
}
