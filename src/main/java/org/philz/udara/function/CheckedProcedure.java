package org.philz.udara.function;

@FunctionalInterface
public interface CheckedProcedure {
    void execute() throws Exception;
}
