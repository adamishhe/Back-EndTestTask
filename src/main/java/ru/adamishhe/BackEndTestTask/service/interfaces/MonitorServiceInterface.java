package ru.adamishhe.BackEndTestTask.service.interfaces;

import ru.adamishhe.BackEndTestTask.DTO.products.MonitorDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Monitor;

import java.util.List;

public interface MonitorServiceInterface {
    public List<Monitor> getAllMonitors();

    public Monitor getMonitorById(Long id);

    public void saveOrUpdate(Monitor monitor);

    public void delete(Long id);

    public MonitorDTO update(Long id, MonitorDTO update);
}
