package com.github.simonlammer.exceptionhandler;

@FunctionalInterface
public interface DubiousFunction<T> {
	T apply() throws Exception;
}
