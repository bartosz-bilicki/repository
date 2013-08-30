package pl.bb.pagerKata;

import java.math.RoundingMode;

import com.google.common.collect.Range;
import com.google.common.math.IntMath;

public class Pager {

	private final int itemCount;
	private final int itemsPerPage;
	private final int visiblePageLinksBeforeAndAfterCurrentPage;
	private final int pageCount; // computed
	private int currentPageNumber = 1;

	public Pager(int totalItemCount, int itemsPerPage) {
		this(totalItemCount, itemsPerPage, 3);
	}

	public Pager(int totalItemCount, int itemsPerPage, int visiblePageLinksBeforeAndAfterCurrentPage) {
		if (totalItemCount <= 0 || itemsPerPage <= 0) {
			throw new InvalidPagerException();
		}
		this.itemCount = totalItemCount;
		this.itemsPerPage = itemsPerPage;
		this.visiblePageLinksBeforeAndAfterCurrentPage = visiblePageLinksBeforeAndAfterCurrentPage;
		this.pageCount = computePageCount();
	}

	private int computePageCount() {
		return IntMath.divide(itemCount, itemsPerPage, RoundingMode.CEILING);
	}

	public int getPageCount() {
		return pageCount;
	}

	public boolean hasPreviousPage() {
		int firstPageNumber = 1;
		return currentPageNumber != firstPageNumber;

	}

	public boolean hasNextPage() {
		int lastPageNumber = getPageCount();
		return currentPageNumber != lastPageNumber;

	}

	public Range<Integer> getVisiblePageNumbers() {
		int firstIndex = Math.max(1, currentPageNumber - visiblePageLinksBeforeAndAfterCurrentPage);
		int lastIndex = Math.min(currentPageNumber + visiblePageLinksBeforeAndAfterCurrentPage, pageCount);

		return Range.closed(firstIndex, lastIndex);
	}

	public void setCurrentPage(int pageNumber) {
		validatePageNumber(pageNumber);
		currentPageNumber = pageNumber;
	}

	private void validatePageNumber(int pageNumber) {
		if (pageNumber < 1 || pageNumber > getPageCount()) {
			throw new PageOutOfBoundException();
		}
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

}
