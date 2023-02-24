package ru.adamishhe.BackEndTestTask.service.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adamishhe.BackEndTestTask.DTO.products.PcDTO;
import ru.adamishhe.BackEndTestTask.entity.products.PC;
import ru.adamishhe.BackEndTestTask.repository.products.PcRep;
import ru.adamishhe.BackEndTestTask.service.interfaces.PcServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class PcService implements PcServiceInterface {

    private final PcRep pcRep;

    @Autowired
    public PcService(PcRep pcRep) {
        this.pcRep = pcRep;
    }

    public List<PC> getAllPc() {
        return new ArrayList<>(pcRep.findAll());
    }

    public PC getPcById(Long id) {
        return pcRep.findById(id).get();
    }

    public void saveOrUpdate(PC pc)
    {
        pcRep.save(pc);
    }

    public void delete(Long id)
    {
        pcRep.deleteById(id);
    }

    public PcDTO update(Long id, PcDTO updateDTO) {
        PC pc = pcRep.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        pc = PcMapper.map(updateDTO, pc);

        pcRep.save(pc);

        return PcMapper.map(pc);

    }


    private class PcMapper{

        public static PC map(PcDTO newDTO, PC oldEntity) {

            PC newPc = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")){
                newPc.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")){
                newPc.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")){
                newPc.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")){
                newPc.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")){
                newPc.setAmount(newDTO.amount());
            }
            if (newDTO.pcType() != null && !newDTO.pcType().equals("")){
                newPc.setPcType(newDTO.pcType());
            }

            return newPc;

        }

        static public PcDTO map(PC pc) {
            PcDTO dto = new PcDTO(pc.getId(), pc.getType(), pc.getSerial(), pc.getManufacturer(),
                    pc.getCost(), pc.getAmount(), pc.getPcType());

            return dto;
        }

    }
}
