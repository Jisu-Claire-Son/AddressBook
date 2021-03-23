package com.javaex.phone;

public class PhoneVoDB {
	private Long id;
	private String name;		// 이름
	private String hp;			// 휴대폰번호
	private String tel;			// 집전화번호
	
	public PhoneVoDB() {
		
	}
	
	public PhoneVoDB(String name, String hp, String tel) {
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}
	
	public PhoneVoDB(Long id, String name, String hp, String tel) {
		this(name, hp, tel);
		this.id = id;
	}

	//	Getters / Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "PhoneVoDB [id=" + id + ", name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}
	
	
	
}
