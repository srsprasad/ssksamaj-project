package org.ssksamaj.app.persist.dto;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(
    name = "CHIT_MEMR_ASSN",
    uniqueConstraints = {
        @UniqueConstraint(name = "CHIT_MEMR_ASSN_UQ_01", columnNames = {"RNWL_ID", "MEMR_ID"} )
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitRenewalMembersDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RNWL_ID", nullable = false)
    private ChitRenewalDTO chitRenewal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMR_ID", nullable = false)
    private MemberDTO member;

    @OneToMany(mappedBy = "renewalMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitAuctionDTO> auctions;

    @OneToMany(mappedBy = "paymentRenewalMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitPaymentDTO> payments;
}
