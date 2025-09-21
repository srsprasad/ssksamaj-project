package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.ChitRenewalMembersBean;
import org.ssksamaj.app.manager.converter.ChitRenewalMembersConverter;
import org.ssksamaj.app.persist.dto.ChitRenewalMembersDTO;
import org.ssksamaj.app.persist.repository.ChitRenewalMembersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChitRenewalMembersManager {

    private final ChitRenewalMembersRepository chitRenewalMembersRepository;
    private final ChitRenewalMembersConverter chitRenewalMembersConverter;

    public ChitRenewalMembersBean save(ChitRenewalMembersBean bean) {
        ChitRenewalMembersDTO dto = chitRenewalMembersConverter.toDTO(bean);
        return chitRenewalMembersConverter.toBean(chitRenewalMembersRepository.save(dto));
    }

    public Optional<ChitRenewalMembersBean> findById(Long id) {
        return chitRenewalMembersRepository.findById(id).map(chitRenewalMembersConverter::toBean);
    }

    public List<ChitRenewalMembersBean> findAll() {
        return chitRenewalMembersRepository.findAll()
                .stream()
                .map(chitRenewalMembersConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitRenewalMembersBean> findByChitRenewalId(Long chitRenewalId) {
        return chitRenewalMembersRepository.findByChitRenewalId(chitRenewalId)
                .stream()
                .map(chitRenewalMembersConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitRenewalMembersBean> findByMemberId(Long memberId) {
        return chitRenewalMembersRepository.findByMemberId(memberId)
                .stream()
                .map(chitRenewalMembersConverter::toBean)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        chitRenewalMembersRepository.deleteById(id);
    }
}
