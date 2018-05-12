package quest.board.first.vo;
/**
 * MemberVO.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 12. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class MemberVO {
	private String mem_id;     //회원 아이디        
	private String mem_pass;   //회원 비밀번호       
	private String mem_name;   //회원 이름         
	private String mem_bir;    //회원 생일         
	private String mem_add1;   //회원 주소1        
	private String mem_add2;   //회원 주소2        
	private String mem_zip;    //회원 우편번호       
	private String mem_alias;  //회원 별명         
	private String mem_profile;//회원 사진         
	private String mem_del_yn; //회원 활성화여부 (Y,N)
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public String getMem_alias() {
		return mem_alias;
	}
	public void setMem_alias(String mem_alias) {
		this.mem_alias = mem_alias;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	public String getMem_del_yn() {
		return mem_del_yn;
	}
	public void setMem_del_yn(String mem_del_yn) {
		this.mem_del_yn = mem_del_yn;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_name=" + mem_name + ", mem_bir=" + mem_bir
				+ ", mem_add1=" + mem_add1 + ", mem_add2=" + mem_add2
				+ ", mem_zip=" + mem_zip + ", mem_alias=" + mem_alias
				+ ", mem_profile=" + mem_profile + ", mem_del_yn=" + mem_del_yn
				+ "]";
	}
	
	public MemberVO(String mem_id, String mem_pass, String mem_name,
			String mem_bir, String mem_add1, String mem_add2, String mem_zip,
			String mem_alias, String mem_profile, String mem_del_yn) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_name = mem_name;
		this.mem_bir = mem_bir;
		this.mem_add1 = mem_add1;
		this.mem_add2 = mem_add2;
		this.mem_zip = mem_zip;
		this.mem_alias = mem_alias;
		this.mem_profile = mem_profile;
		this.mem_del_yn = mem_del_yn;
	}
	
	public MemberVO(String mem_id, String mem_pass) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
	}
	
	public MemberVO(){
		super();
	}
	
}
