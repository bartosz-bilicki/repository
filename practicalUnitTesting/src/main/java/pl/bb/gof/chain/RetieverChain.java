package pl.bb.gof.chain;

import java.util.LinkedList;
import java.util.List;

public class RetieverChain<RETURN, CRITERIA> {

	private final List<Retriever<RETURN, CRITERIA>> retrievers = new LinkedList<Retriever<RETURN, CRITERIA>>();

	public RetieverChain(Retriever<RETURN, CRITERIA>... retrievers) {
		for (Retriever<RETURN, CRITERIA> r : retrievers) {

		}
	}
}
