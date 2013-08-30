package pl.bb.pagerKata;

import org.assertj.core.api.AbstractAssert;

public class PagerAssert extends AbstractAssert<PagerAssert, Pager> {

	protected PagerAssert(Pager actual) {
		super(actual, Pager.class);
	}

	public static PagerAssert assertThat(Pager actual) {
		return new PagerAssert(actual);
	}

	public PagerAssert hasPreviousPage() {
		if (!actual.hasPreviousPage()) {
			failWithMessage("Expected hasPreviousPage to be true but was false");
		}
		return this;
	}

	public PagerAssert hasNextPage() {
		if (!actual.hasNextPage()) {
			failWithMessage("Expected hasNextPage to be true but was false");
		}
		return this;
	}

}
