package com.org.serai.order.restadvice;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
*/
public class CustomServieException extends RuntimeException {

    public CustomServieException(String message) {
        super(message);
    }

    public CustomServieException(String message, Throwable cause) {
        super(message, cause);
    }
}
