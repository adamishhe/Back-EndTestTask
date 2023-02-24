package ru.adamishhe.BackEndTestTask.DTO.products;

public record PcDTO(Long id, String type, String serial, String manufacturer,
                    String cost, String amount, String pcType) {
}
