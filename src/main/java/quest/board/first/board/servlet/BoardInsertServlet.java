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

@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSpring/uploadStorage";
	
    public BoardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//게시글 처리 부분
		BoardServiceInf boardService = BoardService.getInstance();
		
		BoardVO boardVO = new BoardVO();
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_mem_id = request.getParameter("board_mem_id");
		String board_tboard_seq = request.getParameter("board_tboard_seq");
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		boardVO.setBoard_mem_id(board_mem_id);
		boardVO.setBoard_tboard_seq(board_tboard_seq);
		
		String board_p_seq = request.getParameter("board_p_seq");
		if (board_p_seq.isEmpty()) {
			boardService.insertBoard(boardVO);
		} else {
			boardVO.setBoard_p_seq(board_p_seq);
			boardService.insertBoardP(boardVO);
		}
		
		//파일 처리 부분
		FileAddServiceInf fileAddService = FileAddService.getInstance();
		List<FileAddVO> fileAddVOList = new ArrayList<FileAddVO>();
		fileSetting(request, boardVO.getBoard_seq(), fileAddVOList);
		for (FileAddVO fileAddVO : fileAddVOList) {
			fileAddService.insertFileAdd(fileAddVO);
		}
		
		
		request.getSession().setAttribute("board_tboard_seq", board_tboard_seq);
		response.sendRedirect(request.getContextPath() + "/boardList");
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
