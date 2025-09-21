package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.ChitAuctionBean;
import org.ssksamaj.app.manager.converter.ChitAuctionConverter;
import org.ssksamaj.app.persist.dto.ChitAuctionDTO;
import org.ssksamaj.app.persist.repository.ChitAuctionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChitAuctionManager {

    private final ChitAuctionRepository chitAuctionRepository;
    private final ChitAuctionConverter chitAuctionConverter;

    public ChitAuctionBean save(ChitAuctionBean auctionBean) {
        ChitAuctionDTO dto = chitAuctionConverter.toDTO(auctionBean);
        return chitAuctionConverter.toBean(chitAuctionRepository.save(dto));
    }

    public Optional<ChitAuctionBean> findById(Long id) {
        return chitAuctionRepository.findById(id).map(chitAuctionConverter::toBean);
    }

    public List<ChitAuctionBean> findAll() {
        return chitAuctionRepository.findAll()
                .stream()
                .map(chitAuctionConverter::toBean)
                .collect(Collectors.toList());
    }

    public List<ChitAuctionBean> findByChitRenewalId(Long chitRenewalId) {
        return chitAuctionRepository.findByChitRenewalId(chitRenewalId)
                .stream()
                .map(chitAuctionConverter::toBean)
                .collect(Collectors.toList());
    }

    

    public void deleteById(Long id) {
        chitAuctionRepository.deleteById(id);
    }
}
