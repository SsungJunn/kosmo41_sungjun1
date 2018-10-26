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

public class BDao {
	private static BDao instance = new BDao();
	DataSource dataSource = null;

	int listCount = 5; // 한 페이지당 보여줄 게시물의 갯수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트이 갯수

	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;

	private BDao() {
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

	public static BDao getInstance() {
		return instance;
	}

	public int insertMember(BDto dto) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into members values (?,?,?,?,?,?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			ri = BDao.MEMBER_JOIN_SUCCESS;
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

		return ri;
	}

	public int confirmId(String id) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if (set.next()) {
				ri = BDao.MEMBER_EXISTENT;
			} else {
				ri = BDao.MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();

			if (set.next()) {
				dbPw = set.getString("pw");
				if (dbPw.equals(pw)) {
					System.out.println("login ok");
					ri = BDao.MEMBER_LOGIN_SUCCESS; // 로그인 ok
				} else {
					System.out.println("login fail");
					ri = BDao.MEMBER_LOGIN_PW_NO_GOOD; // 비밀번호 x
				}
			} else {
				System.out.println("login fail");
				ri = BDao.MEMBER_LOGIN_IS_NOT; // 아이디 x
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	public BDto getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from members where id = ?";
		BDto dto = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();

			if (set.next()) {
				dto = new BDto();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));
				dto.setAddress(set.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public int updateMember(BDto dto) {
		int ri = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?, eMail=?, address=? where id=?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			ri = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	public void write(String name, String bTitle, String bPw, String bContent, String sports, String filename) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();

			if (sports.equals("축구")) {
				String query = "insert into mvc_board "
						+ " (bId, bName, bTitle, bPw, bContent, bHit, bGroup, bStep, bIndent, bBoard,filename) " + " values "
						+ " (mvc_board_seq.nextval, ?, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, '" + sports + "', ?)";
				pstmt = con.prepareStatement(query);
			} else if (sports.equals("야구")) {
				String query = "insert into mvc_board "
						+ " (bId, bName, bTitle, bPw, bContent, bHit, bGroup, bStep, bIndent, bBoard,filename) " + " values "
						+ " (mvc_board_seq.nextval, ?, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, '" + sports + "', ?)";
				pstmt = con.prepareStatement(query);
			} else {
				String query = "insert into mvc_board "
						+ " (bId, bName, bTitle, bPw, bContent, bHit, bGroup, bStep, bIndent, bBoard,filename) " + " values "
						+ " (mvc_board_seq.nextval, ?, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, '" + sports + "', ?)";
				pstmt = con.prepareStatement(query);
			}

			pstmt.setString(1, name);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bPw);
			pstmt.setString(4, bContent);
			pstmt.setString(5, filename);
			pstmt.executeUpdate();
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

	public ArrayList<BDto> list(int curPage, String choose, String search, String board) {

		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;

		// 전체 게시판에서 검색
		try {
			con = dataSource.getConnection();
			if (board == null && choose == null) {
				String query = "select * " + " from ( " + "  select rownum num, A.* " + "   from ( " + "    select * "
						+ "     from mvc_board " + "     order by bgroup desc, bstep asc) A "
						+ "   where rownum <= ?) B " + "where B.num >= ? ";

				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);

				resultSet = pstmt.executeQuery();
			} else if (board == null && choose != null) {
				String query = "select * " + " from ( " + "  select rownum num, A.* " + "   from ( " + "    select * "
						+ "     from mvc_board " + "		where " + choose + " like '%" + search + "%'"
						+ "     order by bgroup desc, bstep asc) A " + "   where rownum <= ?) B " + "where B.num >= ? ";

				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);

				resultSet = pstmt.executeQuery();
			} else if (board != null && choose == null) {
				String query = "select * " + " from ( " + "  select rownum num, A.* " + "   from ( " + "    select * "
						+ "     from mvc_board " + "		where bBoard like ? "
						+ "     order by bgroup desc, bstep asc) A " + "   where rownum <= ?) B " + "where B.num >= ? ";

				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "%" + board + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);

				resultSet = pstmt.executeQuery();
			} else {
				String query = "select * " + " from ( " + "  select rownum num, A.* " + "   from ( " + "    select * "
						+ "     from mvc_board " + "		where bBoard like ? " + "		and " + choose + " like '%"
						+ search + "%'" + "     order by bgroup desc, bstep asc) A " + "   where rownum <= ?) B "
						+ "where B.num >= ? ";

				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "%" + board + "%");
				pstmt.setInt(2, nEnd);
				pstmt.setInt(3, nStart);

			}

			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bPw = resultSet.getString("bPw");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String bBoard = resultSet.getString("bBoard");
				String filename = resultSet.getString("filename");

				BDto dto = new BDto(bId, bName, bTitle, bPw, bContent, bDate, bHit, bGroup, bStep, bIndent, bBoard,
						filename);
				dtos.add(dto);
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
		return dtos;
	}

	public BPageInfo articlePage(int curPage, String choose, String search, String board) {
		// 로직
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		// 총 게시물의 갯수
		int totalCount = 0;
		try {
			con = dataSource.getConnection();
			if (board == null && choose == null) {

				String query = "select count(*) as total from mvc_board";
				pstmt = con.prepareStatement(query);
				resultSet = pstmt.executeQuery();
			} else if (board != null && choose == null) {

				String query = "select count(*) as total from mvc_board " + "where bBoard like ? ";
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "%" + board + "%");
				resultSet = pstmt.executeQuery();
			} else if (board == null && choose != null) {

				String query = "select count(*) as total from mvc_board " + "where " + choose + " like '%" + search
						+ "%'";
				pstmt = con.prepareStatement(query);

				resultSet = pstmt.executeQuery();
			} else {
				String query = "select count(*) as total from mvc_board " + "where bBoard like ? " + "and " + choose
						+ " like '%" + search + "%'";
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "%" + board + "%");
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");

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

		// 총 페이지 수
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0)
			totalPage++;

		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;

		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

		// 끝 페이지
		int endPage = startPage + pageCount + 1 - 2;
		if (endPage > totalPage) 
			endPage = totalPage;
		 
		BPageInfo pinfo = new BPageInfo();
		// set
		pinfo.setTotalCount(totalCount);
		pinfo.setLinstCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(myCurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}

	public BDto contentView(String strID) {
		upHit(strID);

		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();

			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bPw = resultSet.getString("bPw");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String bBoard = resultSet.getString("bBoard");
				String filename = resultSet.getString("filename");

				dto = new BDto(bId, bName, bTitle, bPw, bContent, bDate, bHit, bGroup, bStep, bIndent, bBoard,
						filename);
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
		return dto;
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

	private void upHit(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
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

	public BDto reply_view(String str) {
		BDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bPw = resultSet.getString("bPw");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String bBoard = resultSet.getString("bBoard");
				String filename = resultSet.getString("filename");

				dto = new BDto(bId, bName, bTitle, bPw, bContent, bDate, bHit, bGroup, bStep, bIndent, bBoard,
						filename);
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
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bPw, String bContent, String bGroup, String bStep,
			String bIndent) {
		replyShape(bGroup, bStep);

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "insert into mvc_board " + " (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bPw);
			pstmt.setString(4, bContent);
			pstmt.setInt(5, Integer.parseInt(bGroup));
			pstmt.setInt(6, Integer.parseInt(bStep) + 1);
			pstmt.setInt(7, Integer.parseInt(bIndent) + 1);

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
}
