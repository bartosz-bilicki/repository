package pl.bb.gof.chain;

public class CacheRetriever extends Retriever<Data, Criteria> {

	@Override
	public Data get(Criteria criteria) {
		if (criteria.age <= 1) {
			return new Data(getName() + Integer.toString(criteria.age));
		}
		return null;
	}

}
