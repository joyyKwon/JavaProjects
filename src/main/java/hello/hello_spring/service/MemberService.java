package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    /*
    // 현재 구현부와 테스트부가 각각 객체를 생성해서 사용하게 됨
    // 불필요하면 실제 테스트가 달라질수도 있기 때문에 아래 방법으로 사용함
    private final MemberRepository memoryMemberRepository = new MemoryMemberRepository();
     */

    private final MemberRepository memoryMemberRepository;

    // 이게 바로 DI (의존성 주입. Dependency Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memoryMemberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);        // 중복회원 검증
        memoryMemberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
            // .orElseGet() -> 있으면 꺼내고, 없으면 정해진 동작을 실행해. 이것도 잘 쓰인다고 함
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memId) {
        return memoryMemberRepository.findById(memId);
    }
}
