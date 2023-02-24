package ru.adamishhe.BackEndTestTask.service.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adamishhe.BackEndTestTask.DTO.products.LaptopDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Laptop;
import ru.adamishhe.BackEndTestTask.repository.products.LaptopRep;
import ru.adamishhe.BackEndTestTask.service.interfaces.LaptopServiceInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopService implements LaptopServiceInterface {

    private final LaptopRep laptopRep;

    @Autowired
    public LaptopService(LaptopRep laptopRep) {
        this.laptopRep = laptopRep;
    }

    public List<Laptop> getAllLaptops() {
        return new ArrayList<>(laptopRep.findAll());
    }

    public Laptop getLaptopById(Long id) {
        return laptopRep.findById(id).get();
    }

    public void saveOrUpdate(Laptop laptop)
    {
        laptopRep.save(laptop);
    }

    public void delete(Long id)
    {
        laptopRep.deleteById(id);
    }

    public LaptopDTO update(Long id, LaptopDTO updateDTO) {
        Laptop laptop = laptopRep.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        laptop = LaptopMapper.map(updateDTO, laptop);

        laptopRep.save(laptop);

        return LaptopMapper.map(laptop);
    }

    private class LaptopMapper{

        public static Laptop map(LaptopDTO newDTO, Laptop oldEntity) {

            Laptop newLaptop = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")){
                newLaptop.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")){
                newLaptop.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")){
                newLaptop.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")){
                newLaptop.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")){
                newLaptop.setAmount(newDTO.amount());
            }
            if (newDTO.screenSize() != null && !newDTO.screenSize().equals("")){
                newLaptop.setScreenSize(newDTO.screenSize());
            }

            return newLaptop;

        }

        static public LaptopDTO map(Laptop laptop) {
            LaptopDTO dto = new LaptopDTO(laptop.getId(), laptop.getType(), laptop.getSerial(), laptop.getManufacturer(),
                    laptop.getCost(), laptop.getAmount(), laptop.getScreenSize());

            return dto;
        }

    }
}
