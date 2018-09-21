package org.james.test.introinspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class UserUtil {
	
	public static void getBeanInfo(Class<?> clazz) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Introspector.USE_ALL_BEANINFO);
		PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor prop : props) {
			System.out.println(prop);
		}
	}
	
	/*public static void main(String[] args) throws Exception {
		UserUtil.getBeanInfo(PartyAddressInfo.class);
	}*/

}
