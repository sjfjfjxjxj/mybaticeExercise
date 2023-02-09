package notice.model.service;

import java.util.List;

import notice.model.vo.Notice;
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
	 * @return
	 */
	public List<Notice> printAllNotice();

	/**
	 * 공지사항 목록 디테일 조회
	 * @param noticeNo
	 * @return
	 */
	public Notice showOneNotice(int noticeNo);

}
