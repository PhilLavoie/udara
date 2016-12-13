package org.philz.udara.matchers;

import com.google.common.collect.Iterables;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

class ContentEqualsAnyOrderIterableMatcher<T> extends TypeSafeMatcher<Iterable<T>> {

    private final Iterable<T> iterable;

    private ContentEqualsAnyOrderIterableMatcher(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public static <T> ContentEqualsAnyOrderIterableMatcher<T> create(Iterable<T> iterable) {
        checkNotNull(iterable);

        return new ContentEqualsAnyOrderIterableMatcher<>(iterable);
    }

    @Override
    protected boolean matchesSafely(Iterable<T> toMatch) {
        Map<T, Integer> itemsOcurrences = new HashMap<>(Iterables.size(iterable));

        for (T item : iterable) {
            int itemOcurrences = 1;

            if (itemsOcurrences.containsKey(item)) {
                itemOcurrences = itemsOcurrences.get(item) + 1;
            }

            itemsOcurrences.put(item, itemOcurrences);
        }

        for (T item : toMatch) {
            if (!itemsOcurrences.containsKey(item)) { //Not in the current iterable.
                return false;
            }

            int itemOccurrences = itemsOcurrences.get(item) - 1;

            if (itemOccurrences == 0) {
                itemsOcurrences.remove(item);
            } else {
                itemsOcurrences.put(item, itemOccurrences);
            }
        }


        return itemsOcurrences.isEmpty();
    }

    @Override
    public void describeTo(Description description) {

    }
}
