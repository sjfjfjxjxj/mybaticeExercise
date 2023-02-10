package notice.model.service;

import java.util.List;

import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagenation;
//이제부터 인터페이스를 쓸것이다. 스프링 쓰기 준비래. 결합도랑 관련있대. ?.?
public interface NoticeService {
	
	/**
	 * 공지사항등록 service
	 * @param notice
	 * @return
	 */
	public int insertNotice(Notice notice); //몸체가 없는 추상메소드!
	
	/**
	 * 공지사항목록조회(전부불러와서 보임) service
	 * @return List<Notice>
	 */
	public PageData printAllNotice(Pagenation pagenation);

	/**
	 * 공지사항 목록 상세 조회 service
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice printOneByNo(int noticeNo);

	/**
	 * 공지사항 삭제 service
	 * @param noticeNo
	 * @return int
	 */
	public int removeNotice(int noticeNo);

	/**
	 * 공지사항 수정 service
	 * @param notice
	 * @return int
	 */
	public int modifyNotice(Notice notice);
	
}
