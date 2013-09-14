package pl.bb.gof.chain;

public class DbRetriever extends Retriever<Data, Criteria> {

	@Override
	public Data get(Criteria criteria) {
		if (criteria.age <= 30) {
			return new Data(getName() + Integer.toString(criteria.age));
		}
		return null;
	}

}
