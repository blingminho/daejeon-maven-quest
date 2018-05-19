package quest.board.first.board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import quest.board.first.board.service.BoardService;
import quest.board.first.board.service.BoardServiceInf;
import quest.board.first.fileadd.service.FileAddService;
import quest.board.first.fileadd.service.FileAddServiceInf;
import quest.board.first.vo.BoardVO;
import quest.board.first.vo.FileAddVO;

/**
 * BoardUpdateServlet.java
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
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSpring/uploadStorage";
	private FileAddServiceInf fileAddService;
	
    public BoardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String board_seq = request.getParameter("board_seq");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		//게시글 수정 부분
		BoardServiceInf boardService = BoardService.getInstance();
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(board_seq);
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		boardService.updateBoard(boardVO);
		
		//===========================================================================
		//파일 처리 부분
		fileAddService = FileAddService.getInstance();
		
		//사용할 파일 목록
		List<FileAddVO> fileAddVOList = new ArrayList<FileAddVO>();
		
		//기존 파일에서 남은 파일들 배열
		String[] chkBoxFiles = request.getParameterValues("chkBox");
		
		//기존 파일을 제거
		fileAddService.deleteFileAdd(board_seq);
		
		if (chkBoxFiles != null) {
			//유지할 파일만 선정하기
			for (String chkBoxFile : chkBoxFiles) {
				FileAddVO fileAddVO = new FileAddVO();
				fileAddVO.setFile_path(chkBoxFile);
				fileAddVO.setFile_board_seq(board_seq);
				fileAddVOList.add(fileAddVO);
			}
		}
		fileSetting(request, board_seq, fileAddVOList);
		
		for (FileAddVO fileAddVO : fileAddVOList) {
			fileAddService.insertFileAdd(fileAddVO);
		}
		

		//해당 게시글 상세화면으로 이동
		response.sendRedirect(request.getContextPath() + "/boardInfo?board_seq=" + board_seq);
//		request.getRequestDispatcher("/boardInfo?board_seq=" + board_seq).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void fileSetting(HttpServletRequest request, String file_board_seq, List<FileAddVO> fileAddVOList) throws ServletException, IOException {
		//파일 처리 부분
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			
			if (part.getName().equals("file_path")) {
				String file_path = "";
					
				String contentDisposition = part.getHeader("Content-Disposition");
				System.out.println("contentDisposition : " + contentDisposition);
				String[] headers = contentDisposition.split(";");
				//form-data;
				// name="file_path";
				// filename="test.html" or filename=""
				
				String fileName = null;
				
				for (String header : headers) {
					if (header.startsWith(" filename=\"\"")) {
						break;
					} else if (header.startsWith(" filename=")) {
						fileName = header.substring(header.lastIndexOf("."), header.length()-1);
						
						fileName = UUID.randomUUID().toString() + fileName;
						file_path = UPLOAD_PATH + "/" + fileName;
						part.write(file_path);
						part.delete();
						
						FileAddVO fileAddVO = new FileAddVO();
						fileAddVO.setFile_board_seq(file_board_seq);
						fileAddVO.setFile_path(fileName);
						
						fileAddVOList.add(fileAddVO);
						
						break;
					}
				}
			}
		}
	}
	
}
