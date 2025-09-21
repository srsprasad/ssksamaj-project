package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.persist.dto.MemberDTO;

@Mapper(componentModel = "spring", uses = {ChitRenewalMembersConverter.class})
public interface MemberConverter {
    MemberConverter INSTANCE = Mappers.getMapper(MemberConverter.class);

    MemberBean toBean(MemberDTO dto);
    MemberDTO toDTO(MemberBean bean);
}
