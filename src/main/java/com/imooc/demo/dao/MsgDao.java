package com.imooc.demo.dao;

import com.imooc.demo.entity.Msg;
import com.imooc.demo.entity.MsgPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface MsgDao extends JpaRepository<Msg, MsgPK>{

    //默认提供了Optional<Msg> findById(MsgPK id);

    @Query("select m from Msg m where m.receId = ?1")
    Page<Msg> findByReceId(Long receId, Pageable pageable);

    @Query("select m from Msg m where m.sendId = ?1")
    Page<Msg> findBySendId(Long sendId, Pageable pageable);
    
}
