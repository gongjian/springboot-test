package org.james.test.introinspector.model;

/**
 * <b>Description:<b><br/>
 * Output model for individual address.
 */
public class AddressInfo extends GenericOVO implements Cloneable {

	public AddressInfo(){
		super();
	}
	
	public java.lang.Long getAddressId() {
		return addressId;
	}

	public void setAddressId(java.lang.Long addressId) {
		this.addressId = addressId;
	}

	private static final long serialVersionUID = -6337580923685479293L;

	private java.lang.Long addressId;
	
}
