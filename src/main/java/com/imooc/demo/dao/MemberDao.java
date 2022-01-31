package com.imooc.demo.dao;

import com.imooc.demo.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface MemberDao extends JpaRepository<Member, Long>{

    //默认提供了Optional<Member> findById(Long id);

    Member findByName(String name);

    @Query("select m from Member m where m.id <= ?1")
    Page<Member> findMore(Long maxId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Member m set m.name = ?1, m.birth=?2, m.height=?3 where m.id = ?4")
    int updateById(String name, String birth, Integer height, Long id);
}
