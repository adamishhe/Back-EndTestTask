package ru.adamishhe.BackEndTestTask.service.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adamishhe.BackEndTestTask.DTO.products.MonitorDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Monitor;
import ru.adamishhe.BackEndTestTask.repository.products.MonitorRep;
import ru.adamishhe.BackEndTestTask.service.interfaces.MonitorServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorService implements MonitorServiceInterface {

    private final MonitorRep monitorRep;

    @Autowired
    public MonitorService(MonitorRep monitorRep) {
        this.monitorRep = monitorRep;
    }

    public List<Monitor> getAllMonitors() {
        return new ArrayList<>(monitorRep.findAll());
    }

    public Monitor getMonitorById(Long id) {
        return monitorRep.findById(id).get();
    }

    public void saveOrUpdate(Monitor monitor)
    {
        monitorRep.save(monitor);
    }

    public void delete(Long id)
    {
        monitorRep.deleteById(id);
    }

    public MonitorDTO update(Long id, MonitorDTO updateDTO) {
        Monitor monitor = monitorRep.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        monitor = MonitorMapper.map(updateDTO, monitor);

        monitorRep.save(monitor);

        return MonitorMapper.map(monitor);

    }

    private class MonitorMapper{

        public static Monitor map(MonitorDTO newDTO, Monitor oldEntity) {

            Monitor newMonitor = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")){
                newMonitor.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")){
                newMonitor.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")){
                newMonitor.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")){
                newMonitor.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")){
                newMonitor.setAmount(newDTO.amount());
            }
            if (newDTO.diagonal() != null && !newDTO.diagonal().equals("")){
                newMonitor.setDiagonal(newDTO.diagonal());
            }

            return newMonitor;

        }

        static public MonitorDTO map(Monitor monitor) {
            MonitorDTO dto = new MonitorDTO(monitor.getId(), monitor.getType(), monitor.getSerial(), monitor.getManufacturer(),
                    monitor.getCost(), monitor.getAmount(), monitor.getDiagonal());

            return dto;
        }

    }
}
