package org.ssksamaj.app.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssksamaj.app.beans.MemberBean;
import org.ssksamaj.app.manager.converter.MemberConverter;
import org.ssksamaj.app.persist.dto.MemberDTO;
import org.ssksamaj.app.persist.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberManager {

    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;

    public MemberBean save(MemberBean memberBean) {
        MemberDTO dto = memberConverter.toDTO(memberBean);
        return memberConverter.toBean(memberRepository.save(dto));
    }

    public Optional<MemberBean> findById(Long id) {
        return memberRepository.findById(id).map(memberConverter::toBean);
    }

    public List<MemberBean> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(memberConverter::toBean)
                .collect(Collectors.toList());
    }

    public MemberBean findByName(String name) {
        return memberConverter.toBean(memberRepository.findByName(name));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
