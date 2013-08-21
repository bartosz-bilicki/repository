package pl.bb.practicalUnitTesting.raceResultService;

public class NotSubscribedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Client client;

	public NotSubscribedException(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}
}
