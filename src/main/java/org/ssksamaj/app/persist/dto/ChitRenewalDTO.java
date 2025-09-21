package org.ssksamaj.app.persist.dto;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHIT_RNWL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitRenewalDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHIT_ID", nullable = false)
    private ChitDTO chit;

    @Column(name = "RNWL_CNT", nullable = false)
    private Integer count;

    @Column(name = "STRT_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @Column(name = "CRTD_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "chitRenewal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitRenewalMembersDTO> renewalMembers;

    @OneToMany(mappedBy = "chitRenewal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitAuctionDTO> auctions;

    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
