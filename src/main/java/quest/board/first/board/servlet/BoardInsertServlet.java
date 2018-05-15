package quest.board.first.board.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSpring/uploadStorage";
	
    public BoardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getName().equals("file_path")) {
				String filePath = "";
				if (part.getSize() > 0) {
					filePath = UPLOAD_PATH + File.separator + UUID.randomUUID().toString();
					part.write(filePath);
					part.delete();
				}
				
				filePath ==> fileadd 테이블에 저장
				
				//filePath webmember.mem_profile에 저장
				//기존 : url형태로 저장 /uploadFolder/Jellyfish.jpg
				//변경 : 물리적 디스크의 절대경로로 저장 D:\\A_TeachingMaterial\\7.JspSpring\\uploadStorage
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
