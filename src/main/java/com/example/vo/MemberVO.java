package com.example.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
public class MemberVO {
	@NonNull private String userid;
	@NonNull private String nickname;
	private String passwd;
	private String role;
	private int enabled;
}
