package com.conversor.modelo;

public record RespuestaConversion(String result,
                                  String base_code,
                                  String target_code,
                                  double conversion_rate,
                                  double conversion_result) {
}
