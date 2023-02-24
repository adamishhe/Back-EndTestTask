package ru.adamishhe.BackEndTestTask.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adamishhe.BackEndTestTask.DTO.products.HddDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Hdd;
import ru.adamishhe.BackEndTestTask.service.interfaces.HddServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/products/hdd")
public class HddController {

    private final HddServiceInterface hddService;

    @Autowired
    public HddController(HddServiceInterface hddService) {
        this.hddService = hddService;
    }

    @GetMapping()
    public List<Hdd> getAllHdd()
    {
        return hddService.getAllHdd();
    }

    @GetMapping("/{id}")
    public Hdd getHdd(@PathVariable("id") Long id) {
        return hddService.getHddById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHdd(@PathVariable(name = "id") Long id) {
        hddService.delete(id);
    }


    @PostMapping("/addlist")
    @ResponseBody
    public String addHddList (@RequestBody List<HddDTO> hddDTOList) {

        for(HddDTO hddDTO: hddDTOList){
            hddService.saveOrUpdate(hddDtoToEntity(hddDTO));
        }

        return "hdd added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addHdd (@RequestBody HddDTO hddDTO) {

        hddService.saveOrUpdate(hddDtoToEntity(hddDTO));

        return "hdd added to database";
    }

    @PutMapping ( "/update/{id}")
    @ResponseBody
    public HddDTO update(@PathVariable(name = "id") Long id, @RequestBody HddDTO update) {
        return hddService.update(id, update);
    }

    private Hdd hddDtoToEntity(HddDTO hddDTO){
        Hdd hdd = new Hdd();

        hdd.setId(hddDTO.id());
        hdd.setCapacity(hddDTO.capacity());
        hdd.setAmount(hddDTO.amount());
        hdd.setCost(hddDTO.cost());
        hdd.setManufacturer(hddDTO.manufacturer());
        hdd.setSerial(hddDTO.serial());
        hdd.setType(hddDTO.type());

        return hdd;
    }

}
