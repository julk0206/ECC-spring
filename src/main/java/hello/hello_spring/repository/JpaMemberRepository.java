package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; //JPA가 자동으로 EntityManager 생성

    public JpaMemberRepository(EntityManager em) { //생성된 것을 인젝션하면 됨
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //persist() : 영구 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
       List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //Jpql 언어 -> 객체 대상으로 쿼리 날림
        //객체 자체를 select 함 (ex. m)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
