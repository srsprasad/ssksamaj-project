package org.ssksamaj.app.beans;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitAuctionBean {
    private Long id;
    private ChitRenewalBean chitRenewal;
    private ChitRenewalMembersBean renewalMember;
    private Integer auctionCount;
    private LocalDate auctionDate;
    private BigDecimal auctionAmount;
    private BigDecimal auctionAdjAmount;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<ChitPaymentBean> payments;
}
