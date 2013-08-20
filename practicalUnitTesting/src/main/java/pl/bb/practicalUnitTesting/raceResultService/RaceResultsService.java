package pl.bb.practicalUnitTesting.raceResultService;

import java.util.HashSet;
import java.util.Set;

public class RaceResultsService {
	private final Set<Client> clients = new HashSet<Client>();

	public void addSubscriber(Client client) {
		clients.add(client);
	}

	public void send(Message message) {
		for (Client client : clients) {
			client.receive(message);
		}
	}

	public void removeSubscriber(Client client) {
		if (clients.remove(client) == false) {
			throw new NotSubscribedException(client);
		}
	}
}
