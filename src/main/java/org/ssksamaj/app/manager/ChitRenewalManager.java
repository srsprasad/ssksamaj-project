package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.ChitRenewalBean;
import org.ssksamaj.app.manager.converter.ChitRenewalConverter;
import org.ssksamaj.app.persist.dto.ChitRenewalDTO;
import org.ssksamaj.app.persist.repository.ChitRenewalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChitRenewalManager {

    private final ChitRenewalRepository chitRenewalRepository;
    private final ChitRenewalConverter chitRenewalConverter;

    public ChitRenewalBean save(ChitRenewalBean renewalBean) {
        ChitRenewalDTO dto = chitRenewalConverter.toDTO(renewalBean);
        return chitRenewalConverter.toBean(chitRenewalRepository.save(dto));
    }

    public Optional<ChitRenewalBean> findById(Long id) {
        return chitRenewalRepository.findById(id).map(chitRenewalConverter::toBean);
    }

    public List<ChitRenewalBean> findAll() {
        return chitRenewalRepository.findAll()
                .stream()
                .map(chitRenewalConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitRenewalBean> findByChitId(Long chitId) {
        return chitRenewalRepository.findByChitId(chitId)
                .stream()
                .map(chitRenewalConverter::toBean)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        chitRenewalRepository.deleteById(id);
    }
}
