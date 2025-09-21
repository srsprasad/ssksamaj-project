package org.ssksamaj.app.persist.dto;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHIT_AUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitAuctionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RNWL_ID", nullable = false)
    private ChitRenewalDTO chitRenewal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RNWL_MEMR_ID", nullable = false)
    private ChitRenewalMembersDTO renewalMember;

    @Column(name = "AUCT_CNT", nullable = false)
    private Integer auctionCount;

    @Column(name = "AUCT_DATE", nullable = false)
    private LocalDate auctionDate;

    @Column(name = "AUCT_AMT", nullable = false)
    private BigDecimal auctionAmount;

    @Column(name = "AUCT_ADJ_AMT", nullable = false)
    private BigDecimal auctionAdjAmount;

    @Column(name = "CRTD_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UPTD_DATE", nullable = false)
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitPaymentDTO> payments;

    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
