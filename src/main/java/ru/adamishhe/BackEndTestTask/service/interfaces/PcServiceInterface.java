package ru.adamishhe.BackEndTestTask.service.interfaces;

import ru.adamishhe.BackEndTestTask.DTO.products.PcDTO;
import ru.adamishhe.BackEndTestTask.entity.products.PC;

import java.util.List;

public interface PcServiceInterface {
    public List<PC> getAllPc();

    public PC getPcById(Long id);

    public void saveOrUpdate(PC pc);

    public void delete(Long id);

    public PcDTO update(Long id, PcDTO update);
}
