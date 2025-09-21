package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.OrganizationBean;
import org.ssksamaj.app.persist.dto.OrganizationDTO;

@Mapper(config = MapperConfig.class, uses = {ChitConverter.class})
public interface OrganizationConverter {
    OrganizationConverter INSTANCE = Mappers.getMapper(OrganizationConverter.class);

    OrganizationBean toBean(OrganizationDTO dto);
    OrganizationDTO toDTO(OrganizationBean bean);
}
