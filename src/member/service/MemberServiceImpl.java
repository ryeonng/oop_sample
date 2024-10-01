package member.service;

import member.Member;
import member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{

	private MemberRepository repository; // 회원의 정보를 저장하려면 가지고 있어야 한다.
	
	// 생성자 의존 주입 DI
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.repository = memberRepository;
	}
	
	@Override
	public void signUp(Member member) {
		repository.save(member);
	}

	@Override
	public Member findByIdMember(Long memberId) {
		return repository.findById(memberId);
	}

}
