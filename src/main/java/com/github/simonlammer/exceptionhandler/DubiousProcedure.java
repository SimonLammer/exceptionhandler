package com.github.simonlammer.exceptionhandler;

@FunctionalInterface
public interface DubiousProcedure {
	void apply() throws Exception;
}
