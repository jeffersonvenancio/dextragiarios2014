package com.dextra.dextragiarios2014.atividade_13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Reflector {
	public static Object getNextValue(Iterator<String> it)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		Method m = it.getClass().getMethod("next");
		return m.invoke(it);
	}
}
