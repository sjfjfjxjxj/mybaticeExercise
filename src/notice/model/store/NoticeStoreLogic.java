package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagenation;

public class NoticeStoreLogic implements NoticeStore{

	@Override
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagenation pagenation) {
		//pagenation.setStart(11);
		//pagenation.setEnd(20); vo에서 다 적어놔서 이제 필요없음
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectAllNotice", pagenation);
		return nList;
	}

	@Override
	public String generatePageNavi(SqlSession sqlSession, int currentPage) {
		int totalCount = getRecordTotalCount(sqlSession); //전체 게시물 개수 불러오기
		int recordCountPerPage = 10;  //한페이지에 게시물 10개씩 보여줄거야
		int naviTotalCount = 0;  //전체페이지 개수를 한페이지에 10개씩 보여줄때 페이지 개수
		if(totalCount % recordCountPerPage>0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		}else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5; //1~5까지 보여주고 6페이지부터는 6~10까지 보여주고ㅇㅇ
		int startNavi = ((currentPage -1) / naviCountPerPage) *naviCountPerPage+1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi>naviTotalCount) {
			endNavi = naviTotalCount; //최대값으로 세팅!
		}
		StringBuilder sb = new StringBuilder();
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/list.do?page="+i+"'> "+i+" </a>");
		}
		return sb.toString();
	}

	@Override
	public Notice selectOneByNo(SqlSession sqlSession, int noticeNo) {
		Notice notice = sqlSession.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int updateNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, int noticeNo) {
		int result = sqlSession.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public int getRecordTotalCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeMapper.selectTotalCount");
		return result;
	}
	
}
