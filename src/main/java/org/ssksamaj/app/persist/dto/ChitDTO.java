package org.ssksamaj.app.persist.dto;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGN_ID", nullable = false)
    private OrganizationDTO organization;

    @Column(name = "PRPL_AMT", nullable = false)
    private BigDecimal principalAmount;

    @Column(name = "AGNT_CMSN_PRCT", nullable = false)
    private BigDecimal agentComission;

    @Column(name = "MEMR_CMSN_PRCT", nullable = false)
    private BigDecimal memberComission;

    @Column(name = "MEMR_CNT", nullable = false)
    private Integer totalMembersCount;

    @Column(name = "CRTD_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "chit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChitRenewalDTO> renewals;

    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
