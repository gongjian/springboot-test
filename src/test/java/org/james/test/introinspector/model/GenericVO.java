package org.james.test.introinspector.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GenericVO implements Serializable, Cloneable, GenericValueObject {

  private static final long serialVersionUID = 5877651171436098110L;

  private GenericVO extObject;

  private Map<String, String> extendedProps = new HashMap<String, String>();

  @SuppressWarnings("unchecked")
  public <T extends GenericVO> T getExtObject(Class<T> clazz) {
    return (T) extObject;
  }

  public void setExtObject(GenericVO extObject) {
    this.extObject = extObject;
  }

  @Override
  public GenericVO clone() {
    try {
      GenericVO clonedObject = (GenericVO) super.clone();
      if (extObject != null) {
        clonedObject.setExtObject(extObject.clone());
      }
      return clonedObject;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  public Map<String, String> getExtendedProps() {
    return extendedProps;
  }

  public void setExtendedProps(Map<String, String> extendedProps) {
    this.extendedProps = extendedProps;
  }

}
