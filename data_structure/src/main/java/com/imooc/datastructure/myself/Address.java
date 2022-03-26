package com.imooc.datastructure.myself;

public class Address implements Cloneable{

    private String addressId;
    private String addressName;


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address)super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
