package com.imooc.demo.service;

import com.imooc.demo.entity.Member;
import com.imooc.demo.entity.User;
import com.imooc.demo.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
    @Autowired
    private MemberDao memberDao;


    public Page<Member> find(Long maxId){
        Pageable pageable = PageRequest.of(0, 10);
        return memberDao.findMore(maxId,pageable);
    }

    public Member save(Member m){
        return memberDao.save(m);
    }

    public Member getMemberByID(Long id){
        return memberDao.findById(id).get();
    }
    
    public Boolean updateById(String  name, String birth, Integer height, Long id){
        return memberDao.updateById(name,birth, height, id)==1;
    }

}
