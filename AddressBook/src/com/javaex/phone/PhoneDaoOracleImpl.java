package com.javaex.phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PhoneDaoOracleImpl implements PhoneDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//	드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, "C##JISOO", "1234");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
	}

	@Override
	public List<PhoneVoDB> getList() {
//		자바 객체를 이용 주고받기	: SQL RS -> Java 객체로 변환
			List<PhoneVoDB> list = new ArrayList<>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT id, name, hp, tel  FROM phone_book";
				rs = stmt.executeQuery(sql);
				
				//	루프를 돌면서 자바 객체로 변환
				while(rs.next()) {
					Long id = rs.getLong("id");
					String name = rs.getString("name");
					String hp = rs.getString("hp");
					String tel = rs.getString("tel");
					
					//	VO 객체 생성
					PhoneVoDB vo = new PhoneVoDB(id, name, hp, tel);
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e) {
					
				}
			}
			return list;
	}

	@Override
	public List<PhoneVoDB> search(String keyword) {
		List<PhoneVoDB> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneVoDB vo = new PhoneVoDB();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setTel(rs.getString(4));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public PhoneVoDB get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(PhoneVoDB vo) {
//		매개변수 vo를 전달받아서 author 테이블에 insert
			// INSERT, UPDATE, DELETE 수행시 executeUpdate 메서드 -> 결과 int(영향 받은 레코드 수)
			Connection conn = null;
			String sql = "INSERT INTO phone_book VALUES(seq_phone_book.NEXTVAL, ?, ?, ?)";	//	실행계획
			int insertedCount = 0;
			PreparedStatement pstmt = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				//	파라미터 연결
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getHp());
				pstmt.setString(3, vo.getTel());
				
				insertedCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {}
			}
			return insertedCount == 1;	//	INSERT 문장의 성공 여부
	}

	@Override
	public boolean update(PhoneVoDB vo) {
		// VO 객체 전달 name, bio 필드를 교체
				Connection conn = null;
				PreparedStatement pstmt = null;
				int updatedCount = 0;
				
				try {
					conn = getConnection();
					String sql = "UPDATE phone_book SET name=?, hp=?, tel=? WHERE id=?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getHp());
					pstmt.setString(3, vo.getTel());
					pstmt.setLong(4, vo.getId());
					
					updatedCount = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						pstmt.close();
						conn.close();
					} catch (Exception e) {}
				}
				return updatedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return deletedCount == 1;
	}

	public void insertData(String inputName, String inputHP, String inputTel) {
		// TODO Auto-generated method stub
		
	}

		

}
