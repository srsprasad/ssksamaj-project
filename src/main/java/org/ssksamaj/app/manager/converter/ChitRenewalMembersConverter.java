package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.ChitRenewalMembersBean;
import org.ssksamaj.app.persist.dto.ChitRenewalMembersDTO;

@Mapper(componentModel = "spring", uses = {MemberConverter.class, ChitAuctionConverter.class, ChitPaymentConverter.class}, config = MapperConfig.class)
public interface ChitRenewalMembersConverter {
    ChitRenewalMembersConverter INSTANCE = Mappers.getMapper(ChitRenewalMembersConverter.class);

    ChitRenewalMembersBean toBean(ChitRenewalMembersDTO dto);
    ChitRenewalMembersDTO toDTO(ChitRenewalMembersBean bean);
}
