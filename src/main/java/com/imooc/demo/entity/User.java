package com.imooc.demo.entity;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    public String getName() {
    	return name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
    	this.name=name;
    }
}
