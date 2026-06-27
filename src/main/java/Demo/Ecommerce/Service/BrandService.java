package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.BrandRequestDTO;
import Demo.Ecommerce.DTO.BrandResponseDTO;
import java.util.List;
public interface BrandService {
    BrandResponseDTO create(BrandRequestDTO dto);
    List<BrandResponseDTO> getAll();
    BrandResponseDTO getById(Long id);
    BrandResponseDTO update(Long id, BrandRequestDTO dto);
    void delete(Long id);
}
