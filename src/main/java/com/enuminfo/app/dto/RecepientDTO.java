/**
 * 
 */
package com.enuminfo.app.dto;

import java.io.Serializable;

/**
 * @author Kumar
 */
public class RecepientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recepientId;
	private String recepientName="", bankInfo, transitInfo;
	private String address1,address2,city,zipCode;
	private boolean selectCheckbox;
	
	public RecepientDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result
				+ ((bankInfo == null) ? 0 : bankInfo.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + recepientId;
		result = prime * result
				+ ((recepientName == null) ? 0 : recepientName.hashCode());
		result = prime * result
				+ ((transitInfo == null) ? 0 : transitInfo.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecepientDTO other = (RecepientDTO) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (bankInfo == null) {
			if (other.bankInfo != null)
				return false;
		} else if (!bankInfo.equals(other.bankInfo))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (recepientId != other.recepientId)
			return false;
		if (recepientName == null) {
			if (other.recepientName != null)
				return false;
		} else if (!recepientName.equals(other.recepientName))
			return false;
		if (transitInfo == null) {
			if (other.transitInfo != null)
				return false;
		} else if (!transitInfo.equals(other.transitInfo))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getaddress2() {
		return address2;
	}

	public void setaddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getRecepientId() {
		return recepientId;
	}

	public void setRecepientId(int recepientId) {
		this.recepientId = recepientId;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public String getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

	public String getTransitInfo() {
		return transitInfo;
	}

	public void setTransitInfo(String transitInfo) {
		this.transitInfo = transitInfo;
	}

	public boolean isSelectCheckbox() {
		return selectCheckbox;
	}

	public void setSelectCheckbox(boolean selectCheckbox) {
		this.selectCheckbox = selectCheckbox;
	}
}
