package com.eComm.store.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    CATEGORY1("Category 1", "The first category"),
    CATEGORY2("Category 2", "The second category"),
    CATEGORY3("Category 3", "The third category"),
    CATEGORY4("Category 4", "The fourth category");

    private final String label;
    private final String description;
}
