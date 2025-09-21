package org.ssksamaj.app.persist.dto;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CHIT_PYMT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitPaymentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUCT_ID", nullable = false)
    private ChitAuctionDTO auction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RNWL_MEMR_ID", nullable = false)
    private ChitRenewalMembersDTO paymentRenewalMember;

    @Column(name = "PYMT_AMT", nullable = false)
    private BigDecimal paymentAmount;

    @Column(name = "PAID_DATE", nullable = false)
    private LocalDate paidDate;

    @Column(name = "PYMT_STUS", nullable = false, length = 50)
    private String paymentStatus;

    @Column(name = "CRTD_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UPTD_DATE", nullable = false)
    private LocalDateTime updatedDate;

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
