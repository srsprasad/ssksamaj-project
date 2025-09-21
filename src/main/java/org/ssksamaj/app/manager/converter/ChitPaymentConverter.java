package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.ChitPaymentBean;
import org.ssksamaj.app.persist.dto.ChitPaymentDTO;

@Mapper(componentModel = "spring", config = MapperConfig.class)
public interface ChitPaymentConverter {
    ChitPaymentConverter INSTANCE = Mappers.getMapper(ChitPaymentConverter.class);

    ChitPaymentBean toBean(ChitPaymentDTO dto);
    ChitPaymentDTO toDTO(ChitPaymentBean bean);
}
