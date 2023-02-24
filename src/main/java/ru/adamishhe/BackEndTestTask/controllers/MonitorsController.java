package ru.adamishhe.BackEndTestTask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.adamishhe.BackEndTestTask.DTO.products.MonitorDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Monitor;
import ru.adamishhe.BackEndTestTask.service.interfaces.MonitorServiceInterface;

import java.util.List;


@RestController
@RequestMapping("/products/monitors")
public class MonitorsController {

    private final MonitorServiceInterface monitorService;

    public MonitorsController(MonitorServiceInterface monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("")
    public List<Monitor> getAllMonitors()
    {
        return monitorService.getAllMonitors();
    }

    @GetMapping("/{id}")
    public Monitor getMonitor(@PathVariable("id") Long id)
    {
        return monitorService.getMonitorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitor(@PathVariable("id") Long id)
    {
        monitorService.delete(id);
    }

    @PostMapping("/addlist")
    @ResponseBody
    public String addMonitorList (@RequestBody List<MonitorDTO> monitorsDTOList) {

        for(MonitorDTO monitorDTO: monitorsDTOList){
            monitorService.saveOrUpdate(monitorDtoToEntity(monitorDTO));
        }

        return "monitors added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addMonitor (@RequestBody MonitorDTO monitorDTO) {

        monitorService.saveOrUpdate(monitorDtoToEntity(monitorDTO));

        return "monitor added to database";
    }

    @PutMapping ( "/update/{id}")
    @ResponseBody
    public MonitorDTO update(@PathVariable(name = "id") Long id, @RequestBody MonitorDTO update) {
        return monitorService.update(id, update);
    }

    private Monitor monitorDtoToEntity(MonitorDTO monitorDTO){
        Monitor monitor = new Monitor();

        monitor.setId(monitorDTO.id());
        monitor.setDiagonal(monitorDTO.diagonal());
        monitor.setAmount(monitorDTO.amount());
        monitor.setCost(monitorDTO.cost());
        monitor.setManufacturer(monitorDTO.manufacturer());
        monitor.setSerial(monitorDTO.serial());
        monitor.setType(monitorDTO.type());

        return monitor;
    }


}
