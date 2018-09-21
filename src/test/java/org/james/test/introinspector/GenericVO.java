package org.james.test.introinspector;

public class GenericVO {
	
	private GenericVO extObj;

	@SuppressWarnings("unchecked")
	public <T extends GenericVO> T getExtObj() {
		return (T)extObj;
	}

	public void setExtObj(GenericVO extObj) {
		this.extObj = extObj;
	}

}
