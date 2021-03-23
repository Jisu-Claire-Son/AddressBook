package com.javaex.phone;

import java.util.List;

public interface PhoneDao {
	public List<PhoneVoDB> getList();
	public List<PhoneVoDB> search(String keyword);
	public PhoneVoDB get(Long id);
	public boolean insert(PhoneVoDB vo);
	public boolean update(PhoneVoDB vo);
	public boolean delete(Long id);

}
