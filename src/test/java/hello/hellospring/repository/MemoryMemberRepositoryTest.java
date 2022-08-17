package hello.hellospring.repository;

import hello.hellospring.repasitory.MemberRepository;
import hello.hellospring.repasitory.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){

    }

}
