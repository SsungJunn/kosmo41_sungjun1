/*
 *  데이터 베이스에 접속해서 데이터 추가, 삭제, 수정 등의 
 *  작업을 하는 클래스
 */
package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RDao {
	private static RDao instance = new RDao();
	DataSource dataSource = null;

	int listCount = 5; // 한 페이지당 보여줄 게시물의 갯수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트이 갯수
	int rlistCount = 5; // 한 페이지당 보여줄 게시물의 갯수
	int rpageCount = 5;

	private RDao() {
		try {
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			// 접속 정보만 가지고 있음
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RDao getInstance() {
		return instance;
	}

	public void MakeRoom(String RName, String RId, String RPw) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "insert into roomboard " +
					   " (RNum, RName, RId, RPw, RBoss) " +
					   " values " +
					   " (roomboard_seq.nextval, ?, '" + RId + "', ?, ?)";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, RName);
			pstmt.setString(2, RPw);
			pstmt.setString(3, RId);
			
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

public ArrayList<RDto> list(int rcurPage, String choose, String search, String BPw) {
		
		ArrayList<RDto> rdtos = new ArrayList<RDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		int nStart = (rcurPage - 1) * rlistCount + 1;
		int nEnd = (rcurPage - 1) * rlistCount + rlistCount;

		try{
			con = dataSource.getConnection();
			
			String query = "select * " +
					   	   " from ( " +
					   	   "  select rownum num, A.* " +
					   	   "   from ( " +
					   	   "    select * " +
					   	   "     from roomboard " +
					   	   "     order by Rnum desc) A " +
					   	   "   where rownum <= ?) B " +
					   	   "where B.num >= ? ";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nEnd);
			pstmt.setInt(2, nStart);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				int RNum = resultSet.getInt("RNum");
				String RName = resultSet.getString("RName");
				String RId = resultSet.getString("RId");
				String RPw = resultSet.getString("RPw");
				String RBoss = resultSet.getString("RBoss");
				
				RDto rdto = new RDto(RNum, RName, RPw, RId, RBoss);
				rdtos.add(rdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rdtos;
	}

public RPageInfo articlePage(int rcurPage, String choose, String search) {
	// 로직
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	// 총 게시물의 갯수
	int rtotalCount = 0;
	try{
		con = dataSource.getConnection();
		
		String query = "select count(*) as total from roomboard";
		pstmt = con.prepareStatement(query);
		resultSet = pstmt.executeQuery();
		
		if (resultSet.next()) {
			rtotalCount = resultSet.getInt("total");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	// 총 페이지 수
	int rtotalPage = rtotalCount / rlistCount;
	if (rtotalCount % rlistCount > 0)
		rtotalPage++;
	
	// 현재 페이지
	int rmyCurPage = rcurPage;
	if (rmyCurPage > rtotalPage)
		rmyCurPage = rtotalPage;
	if (rmyCurPage < 1)
		rmyCurPage = 1;
	
	// 시작 페이지
	int rstartPage = ((rmyCurPage - 1) / rpageCount) * rpageCount + 1;
	
	// 끝 페이지
	int rendPage = rstartPage + rpageCount + 1 - 2;
	if (rendPage > rtotalPage)
		rendPage = rtotalPage;
	
	RPageInfo rpinfo = new RPageInfo();
	// set
	rpinfo.setRtotalCount(rtotalCount);
	rpinfo.setRlistCount(rlistCount);
	rpinfo.setRtotalPage(rtotalPage);
	rpinfo.setRcurPage(rmyCurPage);
	rpinfo.setRpageCount(rpageCount);
	rpinfo.setRstartPage(rstartPage);
	rpinfo.setRendPage(rendPage);
	
	return rpinfo;
}

	public RDto contentView(String RNum, String RName, String RPw, String RId, String RBoss) {
		
		RDto rdto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();

			String query = "select * from roomboard where RNum = ? and RPw = ? and RId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(RNum));
			pstmt.setString(2, RPw);
			pstmt.setString(3, RId);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				RNum = resultSet.getString("RNum");
				RName = resultSet.getString("RName");
				RId = resultSet.getString("RId");
				RPw = resultSet.getString("RPw");
				RBoss = resultSet.getString("RBoss");
				
				rdto = new RDto(Integer.parseInt(RNum), RName, RPw, RId, RBoss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rdto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update mvc_board " + "    set bName = ?, " + "        bTitle = ?, " + "        bContent = ? "
				+ " where bId = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bId);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public RDto reply_view(String str) {
		RDto rdto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = dataSource.getConnection();
			String query = "select * from roomboard where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int RNum = resultSet.getInt("RNum");
				String RName = resultSet.getString("RName");
				String RId = resultSet.getString("RId");
				String RPw = resultSet.getString("RPw");
				String RBoss = resultSet.getString("RBoss");
				
				rdto = new RDto(RNum, RName, RPw, RId, RBoss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rdto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		replyShape(bGroup, bStep);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board " + " (bId, bName, bTitle, bContent, bGroup, bStep, bInden) "
					+ " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);

			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String strGroup, String strStep) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board " + " set bStep = bStep + 1 " + " where bGroup = ? and bStep > ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));

			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public RDto getRNum(String id) {
		RDto rdto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = dataSource.getConnection();
			String query = "select * from roomboard where RId = ?";
			pstmt.setString(1, id);
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int RNum = resultSet.getInt("RNum");
				String RName = resultSet.getString("RName");
				String RId = resultSet.getString("RId");
				String RPw = resultSet.getString("RPw");
				String RBoss = resultSet.getString("RBoss");

				rdto = new RDto(RNum, RName, RPw, RId, RBoss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rdto;
	}
	
	
	
}