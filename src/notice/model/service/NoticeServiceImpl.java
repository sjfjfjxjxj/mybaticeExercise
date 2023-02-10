package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.store.NoticeStore;
import notice.model.store.NoticeStoreLogic;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagenation;

public class NoticeServiceImpl implements NoticeService{ //인터페이스 임플리먼츠!
	
	private NoticeStore nStore;//전역변수
	
	public NoticeServiceImpl() {
		nStore = new NoticeStoreLogic(); //전역변수 초기화ㅇㅇ
	}

	@Override
	public PageData printAllNotice(Pagenation pagenation) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();		
		//Pagenation pagenation = new Pagenation();
		List<Notice> nList = nStore.selectAllNotice(sqlSession, pagenation);
		String pageNavigator = nStore.generatePageNavi(sqlSession, pagenation.getCurrentPage());
		PageData pageData = new PageData(nList);
		pageData.setPageNavigator(pageNavigator);
		return pageData;
	}

	@Override
	public Notice printOneByNo(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		Notice notice = nStore.selectOneByNo(sqlSession, noticeNo);
		return notice;
	}

	@Override
	public int insertNotice(Notice notice) {
		//서비스역할ⓐ연결생성->Store(dao)에 전달  ⓑ커밋 롤백
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		//NoticeStore nStore = new NoticeStoreLogic(); //인터페이스에 의해 업캐스팅! 인터페이스타입 객체를 만들자(결합도와 연관있음)
		//위에 전역변수로ㅇㅇ
		int result = nStore.insertNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int modifyNotice(Notice notice) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.updateNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int removeNotice(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.deleteNotice(sqlSession, noticeNo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
