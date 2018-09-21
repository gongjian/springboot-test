package org.james.test.toubianduanliu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy implements InvocationHandler {

  @SuppressWarnings("unchecked")
  public <T> T newInstance(Class<T> clz) {
    return (T)Proxy.newProxyInstance(clz.getClassLoader(), new Class[] {clz}, this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (Object.class.equals(method.getDeclaringClass())) {
      return method.invoke(this, args);
    }

    return new User((Integer) args[0], "zhangsan", 10);
  }

}
