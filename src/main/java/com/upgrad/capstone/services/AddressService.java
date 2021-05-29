package com.upgrad.capstone.services;

import com.upgrad.capstone.entities.eshopShippingAddress;
import com.upgrad.capstone.exceptions.AddressDetailsNotFoundException;

public interface AddressService {
    public eshopShippingAddress acceptAddressDetails(eshopShippingAddress address);
    public eshopShippingAddress getAddressDetails(int id) throws AddressDetailsNotFoundException;
    public eshopShippingAddress updateAddressDetails(int id, eshopShippingAddress address) throws AddressDetailsNotFoundException;
    public boolean deleteAddress(int id) throws AddressDetailsNotFoundException;
}
