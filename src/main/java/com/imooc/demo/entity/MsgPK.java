package com.imooc.demo.entity;

import java.io.Serializable;

public class MsgPK implements Serializable {

	protected Long sendId;
    
    protected Long receId;

    protected String makeTime;
    
    public MsgPK() {}

    public MsgPK(Long sendId, Long receId, String makeTime) {
        this.sendId = sendId;
        this.receId = receId;
        this.makeTime = makeTime;
    }
    // equals, hashCode
}