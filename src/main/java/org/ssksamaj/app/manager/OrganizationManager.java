package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.manager.converter.OrganizationConverter;
import org.ssksamaj.app.persist.dto.OrganizationDTO;
import org.ssksamaj.app.persist.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationManager {

    private final OrganizationRepository organizationRepository;
    private final OrganizationConverter organizationConverter;

    public OrganizationBean save(OrganizationBean organizationBean) {
        OrganizationDTO dto = organizationConverter.toDTO(organizationBean);
        return organizationConverter.toBean(organizationRepository.save(dto));
    }

    public Optional<OrganizationBean> findById(Long id) {
        return organizationRepository.findById(id).map(organizationConverter::toBean);
    }

    public List<OrganizationBean> findAll() {
        return organizationRepository.findAll()
                .stream()
                .map(organizationConverter::toBean)
                .collect(Collectors.toList());
    }

    public OrganizationBean findByName(String name) {
        return organizationConverter.toBean(organizationRepository.findByName(name));
    }

    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }
}
