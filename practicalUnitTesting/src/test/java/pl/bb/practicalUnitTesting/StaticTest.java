package pl.bb.practicalUnitTesting;

import java.util.Calendar;

import org.powermock.api.mockito.PowerMockito;
import org.testng.annotations.Test;

@Test(enabled = false)
public class StaticTest {

	public void staticTest() {
		PowerMockito.mockStatic(Calendar.class);
		PowerMockito.when(Calendar.getInstance()).thenReturn(null);
	}
}
