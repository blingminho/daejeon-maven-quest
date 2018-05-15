package quest.board.first.vo;

import java.util.Date;

/**
 * BoardVO.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 15. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class BoardVO {

	private String board_seq;
	private String board_p_seq;
	private String board_tboard_seq;
	private String board_group_seq;
	private String board_title;
	private String board_content;
	private Date board_reg_dt;
	private String board_del_yn;
	private String board_mem_id;
	private String ROWNUM;
	private int LEVEL;
	
	
	public String getROWNUM() {
		return ROWNUM;
	}
	public void setROWNUM(String rOWNUM) {
		ROWNUM = rOWNUM;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_p_seq() {
		return board_p_seq;
	}
	public void setBoard_p_seq(String board_p_seq) {
		this.board_p_seq = board_p_seq;
	}
	public String getBoard_tboard_seq() {
		return board_tboard_seq;
	}
	public void setBoard_tboard_seq(String board_tboard_seq) {
		this.board_tboard_seq = board_tboard_seq;
	}
	public String getBoard_group_seq() {
		return board_group_seq;
	}
	public void setBoard_group_seq(String board_group_seq) {
		this.board_group_seq = board_group_seq;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_reg_dt() {
		return board_reg_dt;
	}
	public void setBoard_reg_dt(Date board_reg_dt) {
		this.board_reg_dt = board_reg_dt;
	}
	public String getBoard_del_yn() {
		return board_del_yn;
	}
	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}
	public String getBoard_mem_id() {
		return board_mem_id;
	}
	public void setBoard_mem_id(String board_mem_id) {
		this.board_mem_id = board_mem_id;
	}
	public BoardVO(String board_seq, String board_p_seq,
			String board_tboard_seq, String board_group_seq,
			String board_title, String board_content, Date board_reg_dt,
			String board_del_yn, String board_mem_id, String ROWNUM, int LEVEL) {
		super();
		this.board_seq = board_seq;
		this.board_p_seq = board_p_seq;
		this.board_tboard_seq = board_tboard_seq;
		this.board_group_seq = board_group_seq;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_reg_dt = board_reg_dt;
		this.board_del_yn = board_del_yn;
		this.board_mem_id = board_mem_id;
		this.ROWNUM = ROWNUM;
		this.LEVEL = LEVEL;
	}
	public BoardVO() {
		super();
	}
	public int getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(int lEVEL) {
		LEVEL = lEVEL;
	}
	@Override
	public String toString() {
		return "BoardVO [board_seq=" + board_seq + ", board_p_seq="
				+ board_p_seq + ", board_tboard_seq=" + board_tboard_seq
				+ ", board_group_seq=" + board_group_seq + ", board_title="
				+ board_title + ", board_content=" + board_content
				+ ", board_reg_dt=" + board_reg_dt + ", board_del_yn="
				+ board_del_yn + ", board_mem_id=" + board_mem_id + ", ROWNUM="
				+ ROWNUM + ", LEVEL=" + LEVEL + "]";
	}
	
	
}
