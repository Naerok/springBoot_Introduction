package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repasitory.MemberRepository;
import hello.hellospring.repasitory.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    // 테스트하나 끝나고 repository를 초기화 해주는 코드
    // 테스트는 서로 순서나 의존관계없이 설계되어야 한다.
    public void afterEach(){
        repository.clearStore();
    }

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member));

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findById("spring2").get();
        Assertions.assertThat(result).isEqualTo(member2);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spirng1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spirng2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}