package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.ChitRenewalBean;
import org.ssksamaj.app.persist.dto.ChitRenewalDTO;

@Mapper(componentModel = "spring", uses = {ChitRenewalMembersConverter.class, ChitAuctionConverter.class}, config = MapperConfig.class)
public interface ChitRenewalConverter {
    ChitRenewalConverter INSTANCE = Mappers.getMapper(ChitRenewalConverter.class);

    ChitRenewalBean toBean(ChitRenewalDTO dto);
    ChitRenewalDTO toDTO(ChitRenewalBean bean);
}
