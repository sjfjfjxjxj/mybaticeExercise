package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.store.NoticeStore;
import notice.model.store.NoticeStoreLogic;
import notice.model.vo.Notice;

public class NoticeServiceImpl implements NoticeService{ //인터페이스 임플리먼츠!
	
	private NoticeStore nStore;//전역변수
	
	public NoticeServiceImpl() {
		nStore = new NoticeStoreLogic(); //전역변수 초기화ㅇㅇ
	}

	@Override
	public int insertNotice(Notice notice) {
		//서비스역할ⓐ연결생성->Store(dao)에 전달  ⓑ커밋 롤백
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		//NoticeStore nStore = new NoticeStoreLogic(); //인터페이스에 의해 업캐스팅! 인터페이스타입 객체를 만들자(결합도와 연관있음)
		//위에 전역변수로ㅇㅇ
		int result = nStore.insertNotice(sqlSession, notice);
		sqlSession.commit();
		return result;
	}

	@Override
	public List<Notice> printAllNotice() {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();		
		List<Notice> nList = nStore.selectAllNotice(sqlSession);
		return nList;
	}

	@Override
	public Notice showOneNotice(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		Notice noticeOne = nStore.selectOneNotice(sqlSession, noticeNo);
		return noticeOne;
	}

}
