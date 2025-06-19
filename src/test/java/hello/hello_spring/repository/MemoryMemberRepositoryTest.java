package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repo.save(member);

        Member result = repo.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result);
        // org.assertj.core.api.Assertions <- 도 잘 사용한다고 함
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        Member findMember = repo.findByName("spring1").get();

        Assertions.assertEquals(member1, findMember);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> memList = repo.findAll();
        Assertions.assertEquals(2, memList.size());

    }
}
