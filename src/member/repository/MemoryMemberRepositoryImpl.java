package member.repository;

import java.util.HashMap;
import java.util.Map;

import member.Grade;
import member.Member;

public class MemoryMemberRepositoryImpl implements MemberRepository{

	private static MemoryMemberRepositoryImpl instance;
	private Map<Long, Member> memberStore = new HashMap<>(); // 자료구조 메모리 공간 생성
	// HashMap에 데이터 넣기 : put
	// HashMap에서 데이터 꺼내기 : get
	
	// 생성자
	private MemoryMemberRepositoryImpl() {
		initData();
	}
	
	// 싱글톤 패턴 외부 접근 메서드 만들기
	public static MemoryMemberRepositoryImpl getInstance() {
		if(instance == null) {
			instance = new MemoryMemberRepositoryImpl();
		}
		return instance;
	}
	
	// 샘플 초기 데이터
	private void initData() {
		memberStore.put(1L, new Member(1L, "김자두", Grade.VIP));
		memberStore.put(2L, new Member(2L, "이자두", Grade.BASIC));
		memberStore.put(3L, new Member(3L, "박자두", Grade.VIP));
	}
	
	@Override
	public void save(Member member) {
		// 회원 저장 기능
		memberStore.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return memberStore.get(memberId);
	}

}
