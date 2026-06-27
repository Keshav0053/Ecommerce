package Demo.Ecommerce.Service;

import Demo.Ecommerce.DTO.BrandRequestDTO;
import Demo.Ecommerce.DTO.BrandResponseDTO;
import Demo.Ecommerce.Entity.Brand;
import Demo.Ecommerce.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;


    @Override
    public BrandResponseDTO create(BrandRequestDTO dto) {
        Brand brand = Brand.builder()
                .name(dto.getName())
                .logoUrl(dto.getLogoUrl())
                .build();
        brand = brandRepository.save(brand);
        return mapToDTO(brand);
    }
    @Override
    public List<BrandResponseDTO> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }
    @Override
    public BrandResponseDTO getById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand Not Found"));
        return mapToDTO(brand);
    }
    @Override
    public BrandResponseDTO update(Long id, BrandRequestDTO dto) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand Not Found"));
        brand.setName(dto.getName());
        brand.setLogoUrl(dto.getLogoUrl());
        brand = brandRepository.save(brand);
        return mapToDTO(brand);
    }
    @Override
    public void delete(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand Not Found"));
        brandRepository.delete(brand);
    }

    private BrandResponseDTO mapToDTO(Brand brand) {
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .logoUrl(brand.getLogoUrl())
                .build();
    }
}
