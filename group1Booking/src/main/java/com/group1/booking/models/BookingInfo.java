package com.group1.booking.models;

public class BookingInfo {
	int bookingNum;
	int shipperId;
	int consigneeId;
	String containerNumber;
	String containerType;
	String cargoNature;
	String cargoDescrpiption;
	int grossWeight;
	int netWeight;
	String fromCity;
	String toCity;
	String createdBy;
	String updatedBy;
	String createDate;
	String updateDate;
	int isActive;
	String grossUnit;
	String netUnit;
	public int getBookingNum() {
		return bookingNum;
	}
	public void setBookingNum(int bookingNum) {
		this.bookingNum = bookingNum;
	}
	public int getShipperId() {
		return shipperId;
	}
	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}
	public int getConsigneeId() {
		return consigneeId;
	}
	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
	}
	public String getContainerNumber() {
		return containerNumber;
	}
	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getCargoNature() {
		return cargoNature;
	}
	public void setCargoNature(String cargoNature) {
		this.cargoNature = cargoNature;
	}
	public String getCargoDescrpiption() {
		return cargoDescrpiption;
	}
	public void setCargoDescrpiption(String cargoDescrpiption) {
		this.cargoDescrpiption = cargoDescrpiption;
	}
	public int getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(int grossWeight) {
		this.grossWeight = grossWeight;
	}
	public int getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(int netWeight) {
		this.netWeight = netWeight;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getGrossUnit() {
		return grossUnit;
	}
	public void setGrossUnit(String grossUnit) {
		this.grossUnit = grossUnit;
	}
	public String getNetUnit() {
		return netUnit;
	}
	public void setNetUnit(String netUnit) {
		this.netUnit = netUnit;
	}
	public void setBooking (BookingInfo booking) {
		
		this.bookingNum = booking.getBookingNum();
		this.shipperId = booking.getShipperId();
		this.consigneeId = booking.getConsigneeId();
		this.containerNumber = booking.getContainerNumber();
		this.containerType = booking.getContainerType();
		this.cargoNature = booking.getCargoNature();
		this.cargoDescrpiption = booking.getCargoDescrpiption();
		this.grossWeight = booking.getGrossWeight();
		this.netWeight = booking.getNetWeight();
		this.fromCity = booking.getFromCity();
		this.toCity = booking.getToCity();
		this.updatedBy = booking.getUpdatedBy();
		this.updateDate = booking.getUpdateDate();
		this.isActive = booking.getIsActive();
		this.grossUnit = booking.getGrossUnit();
		this.netUnit = booking.getNetUnit();
		
	}

}
