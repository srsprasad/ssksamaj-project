package org.ssksamaj.app.beans;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitBean {
    private Long id;
    private BigDecimal principalAmount;
    private BigDecimal agentComission;
    private BigDecimal memberComission;
    private Integer totalMembersCount;
    private LocalDateTime createdDate;
    private OrganizationBean organization; 
    private List<ChitRenewalBean> renewals;
}
