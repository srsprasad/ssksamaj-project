package org.ssksamaj.app.beans;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChitRenewalMembersBean {
    private Long id;
    private ChitRenewalBean chitRenewal;
    private MemberBean member;
    private List<ChitAuctionBean> auctions;
    private List<ChitPaymentBean> payments;
}
