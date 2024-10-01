package member.service;

import member.Member;

public interface MemberService {
	void signUp(Member member); // 회원 가입
	Member findByIdMember(Long memberId); // 회원 찾기
}
