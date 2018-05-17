package quest.board.first.vo;

/**
 * FileAddVO.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class FileAddVO {
	private String file_seq;
	private String file_board_seq;
	private String file_path;
	
	public String getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}
	public String getFile_board_seq() {
		return file_board_seq;
	}
	public void setFile_board_seq(String file_board_seq) {
		this.file_board_seq = file_board_seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	public FileAddVO(String file_seq, String file_board_seq, String file_path) {
		super();
		this.file_seq = file_seq;
		this.file_board_seq = file_board_seq;
		this.file_path = file_path;
	}
	
	public FileAddVO() {
	}
	
	@Override
	public String toString() {
		return "FileAddVO [file_seq=" + file_seq + ", file_board_seq="
				+ file_board_seq + ", file_path=" + file_path + "]";
	}
	
}
