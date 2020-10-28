package model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User implements Serializable {
	
	private static final long serialVersionUID = -7351729135012380019L;
	
	private Integer userId;
	
	private String username;
	
	private String password;

}
