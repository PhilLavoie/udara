package org.philz.udara.matchers;

import org.hamcrest.Matcher;

public class Matchers {

    private Matchers() {}

    public static <T> Matcher<Iterable<T>> contentEqualsInAnyOrder(Iterable<T> iterable) {
        return ContentEqualsAnyOrderIterableMatcher.create(iterable);
    }
}
