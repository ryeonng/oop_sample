package member.repository;

import member.Member;

public interface MemberRepository {

	void save(Member member);
	Member findById(Long memberId); // 특정 회원을 조회하는 기능
	
}
