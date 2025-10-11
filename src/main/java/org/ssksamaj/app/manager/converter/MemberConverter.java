package org.ssksamaj.app.manager.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.persist.dto.MemberDTO;

@Mapper(componentModel = "spring", uses = {ChitRenewalMembersConverter.class})
public interface MemberConverter {
    MemberConverter INSTANCE = Mappers.getMapper(MemberConverter.class);

    @Mapping(source = "organizationDTO", target = "organizationBean")
    //@Mapping(source = "groupMemberDTOList", target = "memberGroups")
    MemberBean toBean(MemberDTO dto);
     @Mapping(source = "organizationBean", target = "organizationDTO")
    MemberDTO toDTO(MemberBean bean);
}
