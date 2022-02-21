package com.imooc.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.imooc.demo.entity.Member;
import com.imooc.demo.entity.MsgPK;

@Entity // Entity Bean
@Table(name = "msg") // table name
@IdClass(MsgPK.class) //class for combined primary key
public class Msg implements Serializable{
	@Id
    @Column(name = "sendid")
    private Long sendId;

	@Id
    @Column(name = "receid")
    private Long receId;
    
	@Id
    @Column(name = "maketime")
    private String makeTime;    
        
    @Column(name = "content")
    private String content;
    
    @Column(name = "state")
    private Integer state;
    
    //(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@ManyToOne
    //@JoinColumn(name = "sender_id")
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sendid", insertable = false, updatable = false)
    private Member sender;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "receid", insertable = false, updatable = false)
    private Member receiver;
    
    public Msg() {}
    public Msg(Long sendId, Long receId, String makeTime, String content) {
    	this.sendId=sendId;
    	this.receId=receId;
    	this.makeTime=makeTime;
    	this.content=content;
    	this.state=0;
    }
    
	public Long getSendId() {
		return sendId;
	}

	public void setSender(Long sendId) {
		this.sendId = sendId;
	}

	public Long getReceId() {
		return receId;
	}

	public void setReceiver(Long receId) {
		this.receId = receId;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
    public Member getSender() {  
        return sender;  
    } 	

    public void setSender(Member sender) {  
        this.sender = sender;  
    }

    public Member getReceiver() {  
        return receiver;  
    } 	

    public void setReceiver(Member receiver) {  
        this.receiver = receiver;  
    }
}