package com.imooc.demo.service;

import com.imooc.demo.entity.Member;
import com.imooc.demo.entity.Msg;
import com.imooc.demo.entity.User;
import com.imooc.demo.dao.MsgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("msgService")
public class MsgService {
    @Autowired
    private MsgDao msgDao;

    public Page<Msg> findPage(){
        Pageable pageable = PageRequest.of(0, 10);
        return msgDao.findAll(pageable);
    }
    
    public Page<Msg> findByReceId(Long receId){
        Pageable pageable = PageRequest.of(0, 10);
        return msgDao.findByReceId(receId,pageable);
    }
    
    public Page<Msg> findBySender(Long sendId){
        Pageable pageable = PageRequest.of(0, 10);
        return msgDao.findBySendId(sendId,pageable);
    }
    
    public Msg save(Msg m){
        return msgDao.save(m);
    }

}
