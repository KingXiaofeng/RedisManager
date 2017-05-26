package cn.workcenter.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 加载器
 */
public class Loader {
	
	private static Log log = LogFactory.getLog(Loader.class);
	
	public static Class getClass(String clazz) throws ClassNotFoundException, NoSuchMethodException, SecurityException {

		try {

			return getTCL().loadClass(clazz);

		} catch (ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {

			log.warn("can not load class from ContextClassLoader");
		}
		return Class.forName(clazz);

	}
	
	protected static ClassLoader getTCL() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Method method = null;
		method = Thread.class.getMethod("getContextClassLoader", null);
		return (ClassLoader)method.invoke(Thread.currentThread(), null);
	}
	
}
