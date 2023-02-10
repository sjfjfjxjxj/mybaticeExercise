package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagenation;

public interface NoticeStore {
	
	/**
	 * 공지사항 등록 Store(DAO)
	 * @param sqlSession
	 * @param notice
	 * @return
	 */
	public int insertNotice(SqlSession sqlSession, Notice notice);
	
	/**
	 * 공지사항 목록조회 store(dAO)
	 * @param sqlSession
	 * @return List
	 */
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagenation pagenation);
	
	/**
	 * 공지사항 목록 페이지 네비게이터 store
	 * @param sqlSession
	 * @param currentPage
	 * @return String
	 */
	public String generatePageNavi(SqlSession sqlSession, int currentPage);

	/**
	 * 공지사항 전체 게시물 개수 store
	 * @param sqlSession
	 * @return int
	 */
	public int getRecordTotalCount(SqlSession sqlSession);
	
	/**
	 * 공지사항 개별 조회 store(dao)
	 * @param sqlSession
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectOneByNo(SqlSession sqlSession, int noticeNo);
	
	/**
	 * 공지사항 삭제 store(da0)
	 * @param sqlSession
	 * @param noticeNo
	 * @return int
	 */
	public int deleteNotice(SqlSession sqlSession, int noticeNo);
	
	/**
	 * 공지사항 수정 store(dao)
	 * @param sqlSession
	 * @param noticeNo
	 * @return int
	 */
	public int updateNotice(SqlSession sqlSession, Notice notice);
	
	
}



