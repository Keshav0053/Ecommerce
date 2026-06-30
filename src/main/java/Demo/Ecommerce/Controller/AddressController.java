package Demo.Ecommerce.Controller;

import Demo.Ecommerce.DTO.AddressRequestDTO;
import Demo.Ecommerce.DTO.AddressResponseDTO;
import Demo.Ecommerce.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {
    @Autowired
    private  AddressService service;
    @PostMapping
    public AddressResponseDTO create(@RequestBody AddressRequestDTO request) {
        return service.create(request);
    }
    @GetMapping("/getBYId/{id}")
    public AddressResponseDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @GetMapping("/getAllAddresses")
    public List<AddressResponseDTO> getAll() {
        return service.getAll();
    }
    @PutMapping("/{id}")
    public AddressResponseDTO update(@PathVariable UUID id,
                                     @RequestBody AddressRequestDTO request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Address Deleted Successfully";
    }
}
