package org.ssksamaj.app.beans;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitRenewalBean {
    private Long id;
    private ChitBean chit;
    private Integer count;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private LocalDateTime createdDate;
    private List<ChitRenewalMembersBean> renewalMembers;
    private List<ChitAuctionBean> auctions;
}
