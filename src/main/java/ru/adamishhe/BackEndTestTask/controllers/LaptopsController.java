package ru.adamishhe.BackEndTestTask.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adamishhe.BackEndTestTask.DTO.products.LaptopDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Laptop;
import ru.adamishhe.BackEndTestTask.service.interfaces.LaptopServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/products/laptops")
public class LaptopsController {

    private final LaptopServiceInterface laptopService;

    @Autowired
    public LaptopsController(LaptopServiceInterface laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping()
    public List<Laptop> getAllLaptop() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getLaptop(@PathVariable("id") Long id)
    {
        return laptopService.getLaptopById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLaptop(@PathVariable("id") Long id)
    {
        laptopService.delete(id);
    }

    @PostMapping("/addlist")
    @ResponseBody
    public String addLaptopList (@RequestBody List<LaptopDTO> laptopDTOList) {

        for(LaptopDTO laptopDTO: laptopDTOList){
            laptopService.saveOrUpdate(laptopDtoToEntity(laptopDTO));
        }

        return "laptops added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addLaptop (@RequestBody LaptopDTO laptopDTO) {

        laptopService.saveOrUpdate(laptopDtoToEntity(laptopDTO));

        return "laptop added to database";
    }

    @PutMapping ( "/update/{id}")
    @ResponseBody
    public LaptopDTO update(@PathVariable(name = "id") Long id, @RequestBody LaptopDTO update) {
        return laptopService.update(id, update);
    }

    private Laptop laptopDtoToEntity(LaptopDTO laptopDTO){
        Laptop laptop = new Laptop();

        laptop.setId(laptopDTO.id());
        laptop.setScreenSize(laptopDTO.screenSize());
        laptop.setAmount(laptopDTO.amount());
        laptop.setCost(laptopDTO.cost());
        laptop.setManufacturer(laptopDTO.manufacturer());
        laptop.setSerial(laptopDTO.serial());
        laptop.setType(laptopDTO.type());

        return laptop;
    }


}
