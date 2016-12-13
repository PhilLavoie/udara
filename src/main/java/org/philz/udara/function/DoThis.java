package org.philz.udara.function;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;

import java.util.stream.Stream;

public class DoThis {

    private final Iterable<CheckedProcedure> stuffToDo;

    private DoThis(Iterable<CheckedProcedure> stuffToDo) {
        this.stuffToDo = stuffToDo;
    }

    public DoThis doThis(CheckedProcedure firstThing, CheckedProcedure... theRest) {
        return new DoThis(FluentIterable.of(firstThing, theRest).transform(Preconditions::checkNotNull).toList());
    }
}
