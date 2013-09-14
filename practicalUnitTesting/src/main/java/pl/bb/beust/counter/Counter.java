package pl.bb.beust.counter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/**
 * http://beust.com/weblog/2008/06/27/
 * 
 * @author BB
 * 
 */
public class Counter {

	public boolean hasUniqueDigits(int number) {
		String str = Integer.toString(number);
		int len = str.length();
		Set<Character> charset = new HashSet<Character>(len);

		for (int i = 0; i < len; i++) {
			if (!charset.add(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public int countNumberwithUniueDigits(Range<Integer> range) {
		int ret = 0;
		ContiguousSet<Integer> set = ContiguousSet.create(range, DiscreteDomain.integers());
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) {

			if (hasUniqueDigits(i.next())) {
				ret++;
			}
		}
		return ret;
	}
}
