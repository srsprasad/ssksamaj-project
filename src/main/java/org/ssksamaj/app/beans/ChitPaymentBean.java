package org.ssksamaj.app.beans;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitPaymentBean {
    private Long id;
    private ChitAuctionBean auction;
    private ChitRenewalMembersBean renewalMember;
    private BigDecimal paymentAmount;
    private LocalDate paidDate;
    private String paymentStatus;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
