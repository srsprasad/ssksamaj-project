package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.ChitPaymentBean;
import org.ssksamaj.app.manager.converter.ChitPaymentConverter;
import org.ssksamaj.app.persist.dto.ChitPaymentDTO;
import org.ssksamaj.app.persist.repository.ChitPaymentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChitPaymentManager {

    private final ChitPaymentRepository chitPaymentRepository;
    private final ChitPaymentConverter chitPaymentConverter;

    public ChitPaymentBean save(ChitPaymentBean paymentBean) {
        ChitPaymentDTO dto = chitPaymentConverter.toDTO(paymentBean);
        return chitPaymentConverter.toBean(chitPaymentRepository.save(dto));
    }

    public Optional<ChitPaymentBean> findById(Long id) {
        return chitPaymentRepository.findById(id).map(chitPaymentConverter::toBean);
    }

    public List<ChitPaymentBean> findAll() {
        return chitPaymentRepository.findAll()
                .stream()
                .map(chitPaymentConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitPaymentBean> findByChitAuctionId(Long chitAuctionId) {
        return chitPaymentRepository.findByChitAuctionId(chitAuctionId)
                .stream()
                .map(chitPaymentConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitPaymentBean> findByChitRenewalMembersId(Long chitRenewalMembersId) {
        return chitPaymentRepository.findByChitRenewalMembersId(chitRenewalMembersId)
                .stream()
                .map(chitPaymentConverter::toBean)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        chitPaymentRepository.deleteById(id);
    }
}
