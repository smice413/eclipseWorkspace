package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao {
	
	private SqlSession getSession() {
		SqlSession session=null;
		Reader reader=null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml"); //환경설정xml파일을 불러오면서 db접속함.따라서 예외처리도 해야함
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			session = sf.openSession(true);			// auto commit
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return session;
	}

	public int insert(Member member) {
		int result = 0;
		SqlSession session=null;
		try { 
			session = getSession(); 
			result = session.insert("insert", member);			
			/* result = session.insert("memberns.insert", member); */
			// memberns.insert는 namespace를 설정한 것으로 mapper.xml을 불러오는 것인데 mapper파일 많을때 id가 겹치면 namespace를 기준으로 불러온다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int chk(Member member) {
		int result = 0;
		SqlSession session=null;
		try { session = getSession(); 
			Member mem = (Member) session.selectOne("select", member.getId());
			if (mem.getId().equals(member.getId())) {
				result = -1;	//아이디 일치
				if (mem.getPassword().equals(member.getPassword())) {
					result = 1; //아이디가 일치하고 비번 일치
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	// 수정폼 : 1명의 상세정보 구하기
	public Member select(String id) throws SQLException {
		Member mem = null;
		SqlSession session=null;
		try { session = getSession(); 
		mem = (Member) session.selectOne("select", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mem;
	}
	
//회원목록
	public List<Member> list() {
		List<Member> list = new ArrayList<Member>();
		SqlSession session=null;
		try { session = getSession(); 
			list = session.selectList("list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
// 회원정보 삭제
	public int delete(String id) {
		int result = 0;
		SqlSession session=null;
		try { session = getSession(); 
			result = session.delete("delete", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
//회원정보 수정
	public int update(Member mem) {
		int result = 0;
		SqlSession session=null;
		try { session = getSession(); 
			result = session.update("update", mem);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
