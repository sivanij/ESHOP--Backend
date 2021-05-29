package com.upgrad.capstone.services;

import com.upgrad.capstone.dao.eshopShippingAddressDAO;
import com.upgrad.capstone.entities.eshopShippingAddress;
import com.upgrad.capstone.exceptions.AddressDetailsNotFoundException;

public class AddressServiceImpl implements AddressService{
    private eshopShippingAddressDAO eshopshippingaddressdao;
    @Override
    public eshopShippingAddress acceptAddressDetails(eshopShippingAddress address) {
        return eshopshippingaddressdao.save(address);
    }

    @Override
    public eshopShippingAddress getAddressDetails(int id) throws AddressDetailsNotFoundException {
        return eshopshippingaddressdao.findById(id);
    }

    @Override
    public eshopShippingAddress updateAddressDetails(int id, eshopShippingAddress address) throws AddressDetailsNotFoundException {
        eshopShippingAddress shippingAddress = getAddressDetails(id);
        shippingAddress.setId(id);
        shippingAddress.setCity(address.getCity());
        shippingAddress.setLandmark(address.getLandmark());
        shippingAddress.setName(address.getName());
        shippingAddress.setPhone(address.getPhone());
        shippingAddress.setState(address.getState());
        shippingAddress.setUserId(address.getUserId());
        shippingAddress.setStreet(address.getStreet());
        shippingAddress.setUserId(address.getUserId());
        acceptAddressDetails(shippingAddress);
        return shippingAddress;



    }

    @Override
    public boolean deleteAddress(int id) throws AddressDetailsNotFoundException {
        eshopShippingAddress address = getAddressDetails(id);
        eshopshippingaddressdao.delete(address);
        return true;
    }
}
