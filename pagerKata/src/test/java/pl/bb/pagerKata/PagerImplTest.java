package pl.bb.pagerKata;

import static com.googlecode.catchexception.CatchException.*;
import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Range;

@Test
public class PagerImplTest {

	@Test(dataProvider = "onePagePager")
	public void shouldHaveOnePageWhenItemCountLessThanItemPerPage(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		assertThat(pager.getPageCount()).isEqualTo(1);

	}

	@DataProvider
	private Object[][] onePagePager() {
		return new Object[][] { { 1, 1 }, { 10, 10 }, { 10, 11 }, { 10, 25 } };
	}

	@Test(dataProvider = "threePagePagers")
	public void shuldHaveThreePages(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		assertThat(pager.getPageCount()).isEqualTo(3);
	}

	@DataProvider
	private Object[][] threePagePagers() {
		return new Object[][] { { 30, 10 }, { 3, 1 }, { 29, 10 } };
	}

	@Test(dataProvider = "threePagePagers", dependsOnMethods = "shuldHaveThreePages")
	public void shouldGoToPageChangeCurrentPageNumber(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);

		for (int i = 0; i < pager.getPageCount(); i++) {
			pager.goToPage(i);
			assertThat(pager.getCurrentPageNumber()).isEqualTo(i);
		}
	}

	@Test(dataProvider = "onePagePager")
	public void shouldHandlePreviousNextLinksOnOnePagePager(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		assertPreviousAndNextPageLink(pager, false, false);
	}

	private void assertPreviousAndNextPageLink(PagerImpl pager, boolean previousPageLinkVisible,
			boolean nextPageLinkVisible) {
		assertThat(pager.hasPreviousPage()).isEqualTo(previousPageLinkVisible);
		assertThat(pager.hasNextPage()).isEqualTo(nextPageLinkVisible);
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldHandlePreviousNextLinksOnThreePagePager(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		assertPreviousAndNextPageLink(pager, false, true);

		pager.goToPage(0);
		assertPreviousAndNextPageLink(pager, false, true);

		pager.goToPage(1);
		assertPreviousAndNextPageLink(pager, true, true);

		pager.goToPage(2);
		assertPreviousAndNextPageLink(pager, true, false);
	}

	@Test(expectedExceptions = PageOutOfBoundException.class)
	public void shouldNotAllowNegativePageNumber() {
		PagerImpl pager = new PagerImpl(10, 33);
		pager.goToPage(-1);
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldNotAllowGoToPageGreaterThanPageCount(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);

		// when
		catchException(pager).goToPage(3);
		// then
		assertThat(caughtException()).isNotNull().isInstanceOf(PageOutOfBoundException.class);

		// when
		catchException(pager).goToPage(4);
		// then
		assertThat(caughtException()).isNotNull().isInstanceOf(PageOutOfBoundException.class);
	}

	@Test(dataProvider = "onePagePager")
	public void testGetVisiblePageNumbersOnePage(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		Range<Integer> r = pager.getVisiblePageNumbers();
		assertThat(r).isEqualTo(Range.closed(0, 0));
	}

	@Test(dataProvider = "threePagePagers")
	public void testGetVisiblePageNumbersThreePages(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(0, 2));

		pager.goToPage(1);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(0, 2));

		pager.goToPage(2);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(0, 2));
	}

}
