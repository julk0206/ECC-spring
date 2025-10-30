package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //회원 저장해둘 곳
    private static long sequence = 0L; //key값 생성


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    } //멤버 ID 값 세팅 -> store에 저장

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store.get(id)가 null값일 수도 있는걸 감안
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //findAny() : 하나라도 찾기
    } //루프를 돌면서 name 일치하는거 하나라도 찾기 -> 없으면 optional에 null 포함해서 반환

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear(); //store를 비움
    }
}
