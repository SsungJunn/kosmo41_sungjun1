package com.study.jsp.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest MultipartRequest, HttpServletResponse MultipartResponse)
			throws UnsupportedEncodingException {

		MultipartRequest multi = null;

		int sizeLimit = 10 * 1024 * 1024; // 10메가입니다.

		String savePath = MultipartRequest.getRealPath("/upload"); // 파일이 업로드될 실제 tomcat 폴더의 WebContent 기준

		try {

			multi = new MultipartRequest(MultipartRequest, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

			String regip = MultipartRequest.getRemoteAddr();

			String bTitle = multi.getParameter("bTitle");
			String bPw = multi.getParameter("bPw");
			String bContent = multi.getParameter("bContent");
			String sports = multi.getParameter("sports");
			String filename = multi.getFilesystemName("filename");
			String id = multi.getParameter("id");

			HttpSession session = null;
			session = MultipartRequest.getSession();
			session.setAttribute("sports", sports);
			session.setAttribute("id", id);
			String name = (String)session.getAttribute("name");

			BDao dao = BDao.getInstance();
			dao.write(name, bTitle, bPw, bContent, sports, filename);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
