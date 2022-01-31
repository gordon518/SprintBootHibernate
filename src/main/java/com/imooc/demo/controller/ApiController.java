package com.imooc.demo.controller;

import com.imooc.demo.entity.Member;
import com.imooc.demo.service.MemberService;
import com.imooc.demo.entity.Msg;
import com.imooc.demo.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class ApiController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MsgService msgService;
    
    @GetMapping("/init")
    public String init(){
        /*User user = null;
        for(int i=0;i<10;i++){
            user = new User();
            user.setName("test"+i);
            userService.save(user);
        }*/
        Member member = null;
        for(int i=0;i<9;i++){
            member = new Member();
            member.setName("test"+i);
            member.setBirth("1980010"+(i+1));
            member.setHeight(170+i);
            memberService.save(member);
        }
        Msg msg = null;
        Member m1=memberService.getMemberByID(1L);
        Member m2=memberService.getMemberByID(2L);
        msg=new Msg(1L, 2L, "20220222_13:23:23.236","Hi, You?");
//        msg.setSender(m1);
//        msg.setReceiver(m2);
        msgService.save(msg);
        msg=new Msg(2L, 1L, "20220222_13:23:24.234","Hi, Nice to hear from you! What's your name?");
//        msg.setSender(m2);
//        msg.setReceiver(m1);
        msgService.save(msg);
        msg=new Msg(1L, 2L, "20220223_09:23:24.234","My name is Gordon. What's your name?");
//        msg.setSender(m1);
//        msg.setReceiver(m2);
        msgService.save(msg);
        msg=new Msg(2L, 1L, "20220223_09:26:26.222","My name is Ava. How tall are you?");
//        msg.setSender(m2);
//        msg.setReceiver(m1);
        msgService.save(msg);
        
        return "Init Finished!";
    }

    @GetMapping("/member")
    public Page<Member> getMember(){
        return memberService.find(100L);
    }
    
    @GetMapping("/msg")
    public Page<Msg> getMsg(){
    	Page<Msg> ret= msgService.findPage();
    	/*for(Msg msg : ret) {
    		Member sender=memberService.getMemberByID(msg.getSendId());
    		Member receiver=memberService.getMemberByID(msg.getReceId());
    		msg.setSender(sender);
    		msg.setReceiver(receiver);
    	}*/
    	return ret;
    }
    
    /*
    @GetMapping("/userByName/{username}")
    public User getUserByName(@PathVariable("username") String username){
        return userService.getByName(username);
    }

    @GetMapping("/userById/{userid}")
    public User getUserById(@PathVariable("userid") Long userid){
        return userService.getUserByID(userid);
    }

    @GetMapping("/page")
    public Page<User> getPage(){
        return userService.findPage();
    }

    @GetMapping("/page/{maxID}")
    public Page<User> getPageByMaxID(@PathVariable("maxID") Long maxID){
        return userService.find(maxID);
    }

    @RequestMapping("/update/{id}/{name}")
    public User update(@PathVariable Long id, @PathVariable String name){
        return userService.update(id,name);
    }

    @RequestMapping("/update/{id}")
    public Boolean updateById(@PathVariable Long id){
        return userService.updateById("newName",id);
    }
    */
}
