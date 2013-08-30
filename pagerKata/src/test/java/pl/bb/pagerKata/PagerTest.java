package pl.bb.pagerKata;

import static com.googlecode.catchexception.CatchException.*;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Range;

@Test
public class PagerTest {
	public final int ANY = 99;

	@Test(dataProvider = "onePagePager")
	public void shouldHaveOnePageWhenItemCountLessThanItemPerPage(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertThat(pager.getPageCount()).isEqualTo(1);
	}

	@DataProvider
	private Object[][] onePagePager() {
		return new Object[][] { { 1, 1 }, { 10, 10 }, { 10, 11 }, { 10, 25 } };
	}

	@Test(dataProvider = "invalidPager", expectedExceptions = InvalidPagerException.class)
	public void shouldNotAllowToConstructInvalidPager(int itemCount, int itemsPerPage) {
		new Pager(itemCount, itemsPerPage);
	}

	@DataProvider
	private Object[][] invalidPager() {
		return new Object[][] { { 0, 0 }, { -1, -1 }, { 2, -1 }, { -1, 2 } };
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldNewPagerBeOnPageOne(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertThat(pager.getCurrentPageNumber()).isEqualTo(1);
	}

	@DataProvider
	private Object[][] threePagePagers() {
		return new Object[][] { { 30, 10 }, { 3, 1 }, { 29, 10 } };
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldHaveThreePages(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertThat(pager.getPageCount()).isEqualTo(3);
	}

	@Test(dataProvider = "threePagePagers", dependsOnMethods = "shuldHaveThreePages")
	public void shouldGoToPageChangeCurrentPageNumber(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);

		for (int i = 1; i <= pager.getPageCount(); i++) {
			pager.setCurrentPage(i);
			assertThat(pager.getCurrentPageNumber()).isEqualTo(i);
		}
	}

	@Test(dataProvider = "onePagePager")
	public void shouldHandlePreviousNextLinksOnOnePagePager(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertPreviousAndNextPageLink(pager, false, false);
	}

	private void assertPreviousAndNextPageLink(Pager pager, boolean previousPageLinkVisible, boolean nextPageLinkVisible) {
		assertThat(pager.hasPreviousPage()).as("hasPreviousPage").isEqualTo(previousPageLinkVisible);
		assertThat(pager.hasNextPage()).as("hasNextPage").isEqualTo(nextPageLinkVisible);
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldHandlePreviousNextLinksOnThreePagePager(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertPreviousAndNextPageLink(pager, false, true);

		pager.setCurrentPage(1);
		assertPreviousAndNextPageLink(pager, false, true);

		pager.setCurrentPage(2);
		assertPreviousAndNextPageLink(pager, true, true);

		pager.setCurrentPage(3);
		assertPreviousAndNextPageLink(pager, true, false);
	}

	@Test(expectedExceptions = PageOutOfBoundException.class)
	public void shouldNotAllowNegativePageNumber() {
		Pager pager = new Pager(10, 33);
		pager.setCurrentPage(-1);
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldNotAllowGoToPageGreaterThanPageCount(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);

		// when
		catchException(pager).setCurrentPage(4);
		// then
		assertThat(caughtException()).isNotNull().isInstanceOf(PageOutOfBoundException.class);

		// when
		catchException(pager).setCurrentPage(11);
		// then
		assertThat(caughtException()).isNotNull().isInstanceOf(PageOutOfBoundException.class);
	}

	@Test(dataProvider = "onePagePager")
	public void shouldOnePagePagerShowOnePage(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		Range<Integer> r = pager.getVisiblePageNumbers();
		assertThat(r).isEqualTo(Range.closed(1, 1));
	}

	@Test(dataProvider = "threePagePagers")
	public void shouldThreePagePagerShowThreePages(int itemCount, int itemsPerPage) {
		Pager pager = new Pager(itemCount, itemsPerPage);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(1, 3));

		pager.setCurrentPage(1);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(1, 3));

		pager.setCurrentPage(2);
		assertThat(pager.getVisiblePageNumbers()).isEqualTo(Range.closed(1, 3));
	}

}
