package hello.hellospring.repasitory;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);


    // Optional<> null값일때 Optional에 감싸서 반환해줌
    Optional<Member> findById(Long id);
    Optional<Member> findById(String name);


    // findAll() 위에 저장된 모든 값들을 Member List에 넣어준다.
    List<Member> findAll();
}
