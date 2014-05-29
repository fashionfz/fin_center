package com.megaeyes.fin.utill;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.megaeyes.fin.po.TabletGroup;

/**
 * 
 * ClassName: XmlUtil <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 *  
 * @author dengbin ibcm@qq.com  
 * @version   
 * @since JDK 1.6
 */
public class XmlUtil {

	protected static final Logger logger = LoggerFactory
			.getLogger(XmlUtil.class);
	
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/*
	 * ========================================================XML==================================================================
	 */

	/**
	 * 
	 * @param xmlstr
	 * @param clazz
	 * @return
	 */
	public static Object stringToObject(String xmlstr, Class<?> clazz) {
		Document doc = stringToXml(xmlstr);
		try {
			Element root = doc.getRootElement();
			@SuppressWarnings("unchecked")
			Iterator<Element> iters = root.elementIterator();
			return findObject(iters, clazz);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param xmlstr
	 * @param clazz
	 * @return
	 */
	public static List<Object> stringToList(String xmlstr, Class<?> clazz) {
		Document doc = stringToXml(xmlstr);
		try {
			Element root = doc.getRootElement();
			@SuppressWarnings("unchecked")
			Iterator<Element> iters = root.elementIterator();
			return findList(iters, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param xmlStr
	 * @return Document
	 */
	protected static Document stringToXml(String xmlStr) {
		try {
			if (xmlStr == null || "".equals(xmlStr))
				return null;
			else {
				return DocumentHelper.parseText(xmlStr);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param iters
	 * @param clazz
	 * @return
	 */
	protected static Object findObject(Iterator<Element> iters, Class<?> clazz) {
		Attribute attr = null;
		try {
			Object object = clazz.newInstance();
			while (iters.hasNext()) {
				Element item = (Element) iters.next();
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					if (isSimpleType(field.getType())) {
						attr = item.attribute(field.getName());
						if (attr == null)
							continue;
						setter(object, firstLetterToUpper(field.getName()),
								attr.getValue(), field.getType());
					} else if (List.class == field.getType()) {
						ParameterizedType pt = (ParameterizedType) field
								.getGenericType();
						Class<?> childzz = (Class<?>) pt
								.getActualTypeArguments()[0];
						@SuppressWarnings("unchecked")
						Iterator<Element> children = item.elementIterator();
						Object o = findList(children, childzz);
						setter(object, firstLetterToUpper(field.getName()), o,
								field.getType());
					} else {
						@SuppressWarnings("unchecked")
						Iterator<Element> children = item.elementIterator();
						System.out.println(field.getType().getCanonicalName());
						Object o = findObject(children, field.getType());
						setter(object, firstLetterToUpper(field.getName()), o,
								field.getType());
					}
				}
				return object;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param iters
	 * @param clazz
	 * @return
	 */
	protected static List<Object> findList(Iterator<Element> iters,
			Class<?> clazz) {
		Attribute attr;
		List<Object> list = new ArrayList<Object>();
		try {
			while (iters.hasNext()) {
			    Element item = (Element) iters.next();
                if(!item.getName().equals(clazz.getSimpleName())) {
                    continue;
                }
				Object object = clazz.newInstance();
				
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					if (isSimpleType(field.getType())) {
						attr = item.attribute(field.getName());
						if (attr == null)
							continue;
						setter(object, firstLetterToUpper(field.getName()),
								item.attribute(field.getName()).getValue(),
								field.getType());
					} else if (List.class == field.getType()) {
						ParameterizedType pt = (ParameterizedType) field
								.getGenericType();
						Class<?> childzz = (Class<?>) pt
								.getActualTypeArguments()[0];
						@SuppressWarnings("unchecked")
						Iterator<Element> children = item.elementIterator();
						Object o = findList(children, childzz);
						setter(object, firstLetterToUpper(field.getName()), o,
								field.getType());
					} else {
						@SuppressWarnings("unchecked")
						Iterator<Element> children = item.elementIterator();
						Object o = findObject(children, field.getType());
						setter(object, firstLetterToUpper(field.getName()), o,
								field.getType());
					}
				}
				list.add(object);
			}
			return list;

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/*
	 * =============================================================XML================================================================
	 */

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToString(Object obj) {
		Document doc = ObjectToXml(obj);
		return XmlToString(doc);
	}

	/**
	 * 
	 * @param doc
	 * @return xml
	 */
	protected static String XmlToString(Document doc) {
		if (doc == null)
			return null;
		else
			return doc.asXML();
	}

	/**
	 * 
	 * @param object
	 * @param scheme
	 * @param nodeType
	 * @return Document
	 */
	protected static Document ObjectToXml(Object object) {
		if (object == null)
			return null;
		else {
			Document doc = new DOMDocument();
			if (object instanceof List) {
				for (Object obj : (List<?>) object) {
					findObject(doc, obj);
				}
			} else if (object instanceof Set) {
				for (Object obj : (Set<?>) object) {
					findObject(doc, obj);
				}
			} else {
				findObject(doc, object);
			}
			return doc;
		}
	}

	/**
	 * 
	 * @param root
	 * @param object
	 */
	protected static void findObject(Document root, Object object) {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Element element = null;
		element = new DOMElement(clazz.getSimpleName());
		for (Field field : fields) {
			parseChildren(field, element, object);
		}
		root.add(element);
	}

	@SuppressWarnings("deprecation")
	protected static void parseChildren(Field field, Element element,
			Object object) {
		Class<?> type = field.getType();
		if (isSimpleType(type)) {
			try {
				element.setAttributeValue(
						field.getName(),
						toString(getter(object,
								firstLetterToUpper(field.getName()))));
			} catch (Exception e) {
			}
		} else {
			try {
				Object child = getter(object,
						firstLetterToUpper(field.getName()));
				if (child instanceof List) {
					for (Object obj : (List<?>) child) {
						Element chidElelment = new DOMElement(obj.getClass()
								.getSimpleName());
						Field[] fields = obj.getClass().getDeclaredFields();
						for (Field chidField : fields) {
							parseChildren(chidField, chidElelment, obj);
						}
						element.add(chidElelment);
					}

				} else {
					if (child != null) {
						Element chidElelment = null;
						chidElelment = new DOMElement(child.getClass()
								.getSimpleName());
						Field[] chidFields = child.getClass()
								.getDeclaredFields();
						for (Field chidField : chidFields)
							parseChildren(chidField, chidElelment, child);
						element.add(chidElelment);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
	}

	/*
	 * =======================================================================
	 * ========================================================
	 */

	/**
	 * 
	 * @param type
	 * @return
	 */
	protected static boolean isSimpleType(Class<?> type) {
		if (type == String.class || type == int.class || type == Integer.class
				|| type == double.class || type == Double.class
				|| type == char.class || type == Character.class
				|| type == long.class || type == Long.class
				|| type == float.class || type == Float.class
				|| type == byte.class || type == Byte.class
				|| type == boolean.class || type == Boolean.class
				|| type == short.class || type == Short.class
				|| type == Date.class || type == Timestamp.class) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param obj
	 * @param att
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	protected static Object getter(Object obj, String att)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Method method = obj.getClass().getMethod("get" + att);
		return method.invoke(obj);
	}

	/**
	 * 
	 * @param obj
	 * @param att
	 * @param value
	 * @param type
	 */
	protected static void setter(Object obj, String att, Object value,
			Class<?> type) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		try {
			Method method = obj.getClass().getMethod("set" + att, type);
			if (type == String.class)
				method.invoke(obj, toString(value));
			else if (type == Integer.class || type == int.class)
				method.invoke(obj, toInteger(value));
			else if (type == double.class || type == Double.class)
				method.invoke(obj, toDouble(value));
			else if (type == char.class || type == Character.class)
				method.invoke(obj, toCharacter(value));
			else if (type == long.class || type == Long.class)
				method.invoke(obj, toLong(value));
			else if (type == float.class || type == Float.class)
				method.invoke(obj, toFloat(value));
			else if (type == byte.class || type == Byte.class)
				method.invoke(obj, toByte(value));
			else if (type == boolean.class || type == Boolean.class)
				method.invoke(obj, toBoolean(value));
			else if (type == short.class || type == Short.class)
				method.invoke(obj, toShort(value));
			else if (type == java.util.Date.class) {
				method.invoke(obj, df.parse(String.valueOf(value)));
			} else if (type == java.sql.Timestamp.class) {
                method.invoke(obj ,
                        new Timestamp(
                                df.parse(String.valueOf(value)).getTime()));
            } else
				method.invoke(obj, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	protected static String firstLetterToUpper(String str) {
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	protected static String firstUpperToLetter(String str) {
		char[] array = str.toCharArray();
		array[0] += 32;
		return String.valueOf(array);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static String toString(Object object) {
		if (object == null) {
		    return "";}
		else if (object instanceof Date) {
			return df.format(object);
		} else if (object instanceof Timestamp) {
		    System.out.println("------"+df.format(object));
            return df.format(object);
        }
		else
			return object.toString();
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Integer toInteger(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Integer.parseInt(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Double toDouble(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0.0;
		else
			return Double.parseDouble(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Float toFloat(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0.0f;
		else
			return Float.parseFloat(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Long toLong(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0l;
		else
			return Long.parseLong(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Boolean toBoolean(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return true;
		else
			return Boolean.parseBoolean(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Short toShort(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Short.parseShort(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Byte toByte(Object object) {
		String str = toString(object);
		if ("".equals(str))
			return 0;
		else
			return Byte.parseByte(str);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	protected static Character toCharacter(Object object) {
		if (object == null)
			return '\u0beb';
		else
			return (Character) object;
	}
	
	public static void main(String[] args){
		String xml="<Message><MboxTablet deviceNumber='123' name='abc' address='444' /></Message>";
		String xml2="<Message>"
		        + "<MboxTabletGroup id='' name='66'>"
		        + "<MboxTablet id=''/>"
		        + "<User id=''/>"
		        + "</MboxTabletGroup>"
		        + "</Message>";
		TabletGroup tablet = (TabletGroup) XmlUtil.stringToObject(xml2, TabletGroup.class);
		System.out.println(tablet.getName());
	}

}
