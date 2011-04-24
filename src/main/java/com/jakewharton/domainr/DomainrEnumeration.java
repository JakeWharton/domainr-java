package com.jakewharton.domainr;

/**
 * <p>Interface which allows for central unification of the type heirarchy of
 * all Domainr-specific enumerations.</p>
 * 
 * <p>All implementing enumerations should override {@link Object#toString()}
 * in order to provide a string representation of their type.</p>
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public interface DomainrEnumeration {}