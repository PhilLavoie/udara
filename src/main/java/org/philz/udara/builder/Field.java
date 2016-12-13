package org.philz.udara.builder;

public interface Field<T> {
    T get();
    boolean isSet();
}
