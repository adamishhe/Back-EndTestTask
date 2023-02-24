package ru.adamishhe.BackEndTestTask.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adamishhe.BackEndTestTask.DTO.products.PcDTO;
import ru.adamishhe.BackEndTestTask.entity.products.PC;
import ru.adamishhe.BackEndTestTask.service.interfaces.PcServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/products/pc")
public class PcController {

    private final PcServiceInterface pcService;

    @Autowired
    public PcController(PcServiceInterface pcService) {
        this.pcService = pcService;
    }

    @GetMapping()
    public List<PC> getAllPc() {
        return pcService.getAllPc();
    }

    @GetMapping("/{id}")
    public PC getPc(@PathVariable("id") Long id)
    {
        return pcService.getPcById(id);
    }

    @DeleteMapping("/{id}")
    private void deletePc(@PathVariable("id") Long id)
    {
        pcService.delete(id);
    }

    @PostMapping("/addlist")
    @ResponseBody
    public String addPcList (@RequestBody List<PcDTO> pcDTOList) {

        for(PcDTO pcDTO: pcDTOList){
            pcService.saveOrUpdate((pcDtoToEntity(pcDTO)));
        }

        return "pc added to database";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addPc (@RequestBody PcDTO pcDTO) {

        pcService.saveOrUpdate(pcDtoToEntity(pcDTO));

        return "pc added to database";
    }

    @PutMapping ( "/update/{id}")
    @ResponseBody
    public PcDTO update(@PathVariable(name = "id") Long id, @RequestBody PcDTO update) {
        return pcService.update(id, update);
    }

    private PC pcDtoToEntity(PcDTO pcDTO){
        PC pc = new PC();

        pc.setId(pcDTO.id());
        pc.setPcType(pcDTO.pcType());
        pc.setAmount(pcDTO.amount());
        pc.setCost(pcDTO.cost());
        pc.setManufacturer(pcDTO.manufacturer());
        pc.setSerial(pcDTO.serial());
        pc.setType(pcDTO.type());

        return pc;
    }
}
