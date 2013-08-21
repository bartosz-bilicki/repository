package pl.bb.practicalUnitTesting.raceResultService;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

public class RaceResultsService {
	// private final Set<Client> clients = new HashSet<Client>();
	private final SetMultimap<Client, MessageCategory> clientMap = HashMultimap.create();

	public void addSubscriber(Client client) {
		for (MessageCategory messageCategory : MessageCategory.values()) {
			addSubscriber(client, messageCategory);
		}
	}

	public void addSubscriber(Client client, MessageCategory messageCategory) {
		if (isClientSubscribedToMessageCategory(client, messageCategory)) {
			throw new AlreadySubscribedException();
		}
		clientMap.put(client, messageCategory);
	}

	private boolean isClientSubscribedToMessageCategory(Client client, MessageCategory messageCategory) {
		return clientMap.containsEntry(client, messageCategory);
	}

	public void send(Message message) {
		for (Client client : clientMap.keySet()) {
			if (isClientSubscribedToMessageCategory(client, message.getCategory())) {
				client.receive(message);
			}
		}
	}

	public void removeSubscription(Client client) {
		if (isClientSubscribed(client) == false) {
			throw new NotSubscribedException(client);
		}

		clientMap.removeAll(client);
	}

	private boolean isClientSubscribed(Client client) {
		return clientMap.containsKey(client);
	}
}
