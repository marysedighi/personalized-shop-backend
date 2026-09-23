package com.maryam.personalized_shop_backend.exception;

import java.util.Map;

public record ApiError(
        int status,
        String message,
        Map<String, String> errors) {
}