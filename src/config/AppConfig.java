package config;

import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import order.DiscountPolicy;
import order.FixDiscountPolicyImpl;
import order.OrderService;
import order.OrderServiceImpl;

public class AppConfig {
	
	public MemberRepository getMemberRepository() {
		return MemoryMemberRepositoryImpl.getInstance();
	}
	
	public MemberService getMemberService() {
		return new MemberServiceImpl(getMemberRepository());
	}
	
	public DiscountPolicy getDiscountPolicy() {
		// 할인 정책 -> 고정할인
		// 변경 -> 정율 할인
		
		// return new FixDiscountPolicyImpl(); <- 이 부분만 변경하면 된다.
		return new FixDiscountPolicyImpl();
	}
	
	public OrderService getOrderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}
	
}
