package pl.bb.pagerKata;

import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

	public void shouldNotHavePreviousLinkOnFirstPage() {

	}

	public void shouldHavePreviousLinkOnNonFirstPage() {

	}

	public void shouldNotHaveNextLinkOnLastPage() {

	}

	public void shouldHaveLastLinkOnNonFirstPage() {

	}

	@Test(expectedExceptions = PageOutOfBoundException.class)
	public void shouldNotAllowNegativePageNumber() {
		PagerImpl pager = new PagerImpl(10, 33);
		pager.goToPage(-1);
	}

	@Test(dataProvider = "threePagePagers", expectedExceptions = PageOutOfBoundException.class)
	public void shouldNotAllowGoToPageGreaterThanPageCount(int itemCount, int itemsPerPage) {
		PagerImpl pager = new PagerImpl(itemCount, itemsPerPage);
		pager.goToPage(4);
	}

}
