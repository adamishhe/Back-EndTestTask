package ru.adamishhe.BackEndTestTask.DTO.products;

public record MonitorDTO(Long id, String type, String serial, String manufacturer,
                        String cost, String amount, String diagonal) {
}
