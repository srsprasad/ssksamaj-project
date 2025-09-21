package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.ChitBean;
import org.ssksamaj.app.persist.dto.ChitDTO;

@Mapper(componentModel = "spring", uses = {ChitRenewalConverter.class, OrganizationConverter.class}, config = MapperConfig.class)
public interface ChitConverter {
    ChitConverter INSTANCE = Mappers.getMapper(ChitConverter.class);

    ChitBean toBean(ChitDTO dto);
    ChitDTO toDTO(ChitBean bean);
}
