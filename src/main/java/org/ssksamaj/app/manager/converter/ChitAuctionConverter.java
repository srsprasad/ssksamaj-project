package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.ChitAuctionBean;
import org.ssksamaj.app.persist.dto.ChitAuctionDTO;

@Mapper(componentModel = "spring", uses = {ChitPaymentConverter.class}, config = MapperConfig.class)
public interface ChitAuctionConverter {
    ChitAuctionConverter INSTANCE = Mappers.getMapper(ChitAuctionConverter.class);

    ChitAuctionBean toBean(ChitAuctionDTO dto);
    ChitAuctionDTO toDTO(ChitAuctionBean bean);
}
