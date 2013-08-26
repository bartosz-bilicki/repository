package pl.bb.pagerKata;

import com.google.common.collect.Range;

public class PagerImpl {

	private final int itemCount;
	private final int itemsPerPage;
	private final int visiblePageLinksBeforeAndAfterCurrentPage;
	private final int pageCount; // computed
	private int currentPageNumber;

	public PagerImpl(int totalItemCount, int itemsPerPage, int visiblePageLinksBeforeAndAfterCurrentPage) {
		this.itemCount = totalItemCount;
		this.itemsPerPage = itemsPerPage;
		this.visiblePageLinksBeforeAndAfterCurrentPage = visiblePageLinksBeforeAndAfterCurrentPage;
		this.pageCount = computePageCount();
	}

	public PagerImpl(int totalItemCount, int itemsPerPage) {
		this(totalItemCount, itemsPerPage, 3);
	}

	private int computePageCount() {
		float pageDouble = (float) itemCount / (float) itemsPerPage;
		return (int) Math.ceil(pageDouble);
	}

	public int getPageCount() {
		return pageCount;
	}

	public boolean hasPreviousPage() {
		return currentPageNumber != 0;

	}

	public boolean hasNextPage() {
		int lastPageNumber = getPageCount() - 1;
		return currentPageNumber != lastPageNumber;

	}

	public Range<Integer> getVisiblePageNumbers() {
		int firstIndex = Math.max(0, currentPageNumber - visiblePageLinksBeforeAndAfterCurrentPage);
		int lastIndex = Math.min(currentPageNumber + visiblePageLinksBeforeAndAfterCurrentPage, pageCount - 1);

		return Range.closed(firstIndex, lastIndex);
	}

	public void goToPage(int pageNumber) {
		validatePageNumber(pageNumber);
		currentPageNumber = pageNumber;
	}

	private void validatePageNumber(int pageNumber) {
		if (pageNumber < 0 || pageNumber >= getPageCount()) {
			throw new PageOutOfBoundException();
		}
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

}
