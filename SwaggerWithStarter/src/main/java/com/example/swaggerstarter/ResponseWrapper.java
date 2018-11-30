package com.example.swaggerstarter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseWrapper<T> {
    String code;
    String message;
    T data;
}
