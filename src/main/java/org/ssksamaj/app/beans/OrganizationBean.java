package org.ssksamaj.app.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String locationName;
	private String address;
	private String description;
	private LocalDateTime localDateTime;
	private List<MemberBean> allMemberBeans;
	private List<ChitBean> chits;
		

}
