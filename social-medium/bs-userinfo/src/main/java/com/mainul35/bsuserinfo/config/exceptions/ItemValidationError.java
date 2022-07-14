package com.mainul35.bsuserinfo.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ItemValidationError {
    private String itemName;
    private String field;
    private Object rejectedValue;
    private String message;
}