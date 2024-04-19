package com.conversor.moeda;

public record Moeda(String base_code, String target_code,
                    float conversion_result) {
}