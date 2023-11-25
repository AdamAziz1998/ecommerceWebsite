package com.eComm.store.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    INSTOCK("In Stock", "Product is in stcok"),
    OUTOFSTOCK("Out of Stock", "Item is out of stock"),
    ONELEFTINSTOCK("One left in Stock", "Item is out of stock"),
    ALMOSTSOLDOUT("Almost sold out", "Item is almost sold out");

    private final String label;
    private final String description;

}
