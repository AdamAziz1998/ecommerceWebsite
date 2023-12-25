package com.eComm.store.convert;

import com.eComm.store.dto.CartItemDTO;
import com.eComm.store.model.CartItem;
import org.modelmapper.ModelMapper;

public class CartItemConverter {

    private final ModelMapper modelMapper;

    public CartItemConverter (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CartItemDTO convertCartItemToCartItemDTO (CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    public CartItem convertCartItemDTOToCartItem (CartItemDTO cartItemDTO) {
        return modelMapper.map(cartItemDTO, CartItem.class);
    }
}
