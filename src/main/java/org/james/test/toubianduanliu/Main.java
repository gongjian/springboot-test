package org.james.test.toubianduanliu;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Main {

  public static void main(String[] args) {
    User user = new MapperProxy().newInstance(UserMapper.class).getUserById(14);
    System.out.println(ToStringBuilder.reflectionToString(user));

  }

}
