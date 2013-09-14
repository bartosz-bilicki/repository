package pl.bb.gof.chain;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

@Test
public class RetrieverTest {

	@Test
	private void x() {
		DbRetriever dbRetriever = new DbRetriever();
		CacheRetriever cacheRetriever = new CacheRetriever();

		Data data = dbRetriever.get(new Criteria(1));
		assertThat(data).isNotNull();
		assertThat(data.data).contains("DbRetriever");

		data = cacheRetriever.get(new Criteria(1));
		assertThat(data).isNotNull();
		assertThat(data.data).contains("CacheRetriever");

		data = cacheRetriever.get(new Criteria(2));
		assertThat(data).isNull();
	}
}
