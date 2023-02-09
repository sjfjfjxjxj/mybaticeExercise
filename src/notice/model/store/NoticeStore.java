package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

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
	 * @return
	 */
	public List<Notice> selectAllNotice(SqlSession sqlSession);

	/**
	 * 공지사항 개별 조회 store(dao)
	 * @param sqlSession
	 * @param noticeNo
	 * @return
	 */
	public Notice selectOneNotice(SqlSession sqlSession, int noticeNo);
}
