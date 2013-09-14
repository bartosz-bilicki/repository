package pl.bb.gof.chain;

public abstract class Retriever<RETURN, CRITERIA> {

	public abstract RETURN get(CRITERIA criteria);

	protected String getName() {
		return getClass().getSimpleName();
	}
}
