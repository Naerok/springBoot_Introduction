package hello.hellospring.repasitory;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{


    //아이디가 Long Type니까 Long을 K로 설정한다.
    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findById(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // member에서 넘어온값이 name과 같을때만 filter로 걸러준다.
                .findAny(); // filter로 찾아내면 반환해준다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //  store.values()가 member 들일것.
    }

    public void clearStore(){
        store.clear();
    }

}
