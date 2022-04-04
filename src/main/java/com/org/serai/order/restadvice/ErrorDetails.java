package com.org.serai.order.restadvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

}
