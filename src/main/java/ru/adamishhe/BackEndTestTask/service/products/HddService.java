package ru.adamishhe.BackEndTestTask.service.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adamishhe.BackEndTestTask.DTO.products.HddDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Hdd;
import ru.adamishhe.BackEndTestTask.repository.products.HddRep;
import ru.adamishhe.BackEndTestTask.service.interfaces.HddServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class HddService implements HddServiceInterface {

    private final HddRep hddRep;

    @Autowired
    public HddService(HddRep hddRep) {
        this.hddRep = hddRep;
    }

    public List<Hdd> getAllHdd() {
        return new ArrayList<>(hddRep.findAll());
    }

    public Hdd getHddById(Long id) {
        return hddRep.findById(id).get();
    }

    public void saveOrUpdate(Hdd hdd)
    {
        hddRep.save(hdd);
    }

    public void delete(Long id)
    {
        hddRep.deleteById(id);
    }

    public HddDTO update(Long id, HddDTO updateDTO) {
        Hdd hdd = hddRep.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        hdd = HddMapper.map(updateDTO, hdd);

        hddRep.save(hdd);

        return HddMapper.map(hdd);
    }


    private class HddMapper {

        public static Hdd map(HddDTO newDTO, Hdd oldEntity) {

            Hdd newHdd = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")) {
                newHdd.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")) {
                newHdd.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")) {
                newHdd.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")) {
                newHdd.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")) {
                newHdd.setAmount(newDTO.amount());
            }
            if (newDTO.capacity() != null && !newDTO.capacity().equals("")) {
                newHdd.setCapacity(newDTO.capacity());
            }

            return newHdd;

        }

        public static HddDTO map(Hdd hdd) {
            HddDTO dto = new HddDTO(hdd.getId(), hdd.getType(), hdd.getSerial(), hdd.getManufacturer(),
                    hdd.getCost(), hdd.getAmount(), hdd.getCapacity());

            return dto;
        }
    }
}
