package com.limethecoder.converter;

import com.limethecoder.model.Address;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressConverter {
    public static Address populateAddress(Address address, Address data) {
        if (address == null || data == null) {
            return address;
        }

        address.setBuilding(data.getBuilding());
        address.setCity(data.getCity());
        address.setCountry(data.getCountry());
        address.setPostalCode(data.getPostalCode());
        address.setStreet(data.getStreet());

        return address;
    }
}
