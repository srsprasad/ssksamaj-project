package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.ChitBean;
import org.ssksamaj.app.manager.converter.ChitConverter;
import org.ssksamaj.app.persist.dto.ChitDTO;
import org.ssksamaj.app.persist.repository.ChitRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChitManager {

    private final ChitRepository chitRepository;
    private final ChitConverter chitConverter;

    public ChitBean save(ChitBean chitBean) {
        ChitDTO dto = chitConverter.toDTO(chitBean);
        return chitConverter.toBean(chitRepository.save(dto));
    }

    public Optional<ChitBean> findById(Long id) {
        return chitRepository.findById(id).map(chitConverter::toBean);
    }

    public List<ChitBean> findAll() {
        return chitRepository.findAll()
                .stream()
                .map(chitConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitBean> findByOrganizationId(Long organizationId) {
        return chitRepository.findByOrganizationId(organizationId)
                .stream()
                .map(chitConverter::toBean)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        chitRepository.deleteById(id);
    }
}
