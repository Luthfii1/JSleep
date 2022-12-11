package com.LuthfiMisbachulMunirJSleepFN;

/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * This is a functional interface whose functional method is {@link #predicate(Object)}.
 *
 * @param <T> the type of the input to the predicate
 *
 * @author  Luthfi Misbachul Munir
 */
public interface Predicate<T> {
    public abstract boolean predicate(T arg);
}