package pl.bb.pagerKata;

public class PagerImpl {

	private final int itemCount;
	private final int itemsPerPage;
	private final int pageCount;
	private int currentPageNumber;

	public PagerImpl(int itemCount, int itemsPerPage) {
		this.itemCount = itemCount;
		this.itemsPerPage = itemsPerPage;
		this.pageCount = computePageCount();
	}

	private int computePageCount() {
		float pageDouble = (float) itemCount / (float) itemsPerPage;
		return (int) Math.ceil(pageDouble);
	}

	public int getPageCount() {
		return pageCount;
	}

	public boolean isPreviousPageLinkVisible() {
		return currentPageNumber != 0;

	}

	public boolean isNextPageLinkVisible() {
		int lastPageNumber = getPageCount() - 1;
		return currentPageNumber != lastPageNumber;

	}

	public int[] getVisiblePageNumbers() {
		return null;
	}

	public void goToPage(int pageNumber) {
		validatePageNumber(pageNumber);
		currentPageNumber = pageNumber;
	}

	private void validatePageNumber(int pageNumber) {
		if (pageNumber < 0 || pageNumber > getPageCount()) {
			throw new PageOutOfBoundException();
		}
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

}
