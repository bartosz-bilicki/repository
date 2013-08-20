package pl.bb.practicalUnitTesting.raceResultService;

public class NotSubscribedException extends RuntimeException {
	private final Client client;

	public NotSubscribedException(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}
}
