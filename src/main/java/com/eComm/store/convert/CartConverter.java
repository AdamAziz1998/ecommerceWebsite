package com.eComm.store.convert;

import com.eComm.store.dto.CartDTO;
import com.eComm.store.model.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    private final ModelMapper modelMapper;

    public CartConverter (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CartDTO convertCartToCartDTO (Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }

    public Cart convertProductDTOToProduct (CartDTO cartDTO) {
        return modelMapper.map(cartDTO, Cart.class);
    }
}
