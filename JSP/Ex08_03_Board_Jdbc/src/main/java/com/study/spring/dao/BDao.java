/*
 *  데이터 베이스에 접속해서 데이터 추가, 삭제, 수정 등의 
 *  작업을 하는 클래스
 */
package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.BDto;
import com.study.spring.util.Constant;

public class BDao {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	
//	int listCount = 10;	// 한 페이지당 보여줄 게시물의 갯수
//	int pageCount = 10;	// 하단에 보여줄 페이지 리스트이 갯수
	
	public BDao() {
		template = Constant.template;
	}
	
	public BDto contentView(String strID) {
//		upHit(strID);
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String query = "insert into mvc_board " +
							   " (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " + 
							   " values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";

				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);

				return pstmt;
			}
		});
	}
	
	public ArrayList<BDto> list() {
		
//		int nStart = (curPage - 1) * listCount + 1;
//		int nEnd = (curPage - 1) * listCount + listCount;
			
//			String query = "select * " +
//					   	   " from ( " +
//					   	   "  select rownum num, A.* " +
//					   	   "   from ( " +
//					   	   "    select * " +
//					   	   "     from mvc_board " +
//					   	   "     order by bgroup desc, bstep asc) A " +
//					   	   "   where rownum <= ?) B " +
//					   	   "where B.num >= ? ";
			
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent " + 
                    	"  from mvc_board " +
                    	" order by bGroup desc, bStep asc";

		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
//	public BPageInfo articlePage(int curPage) {
//		// 로직
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet resultSet = null;
//		
//		// 총 게시물의 갯수
//		int totalCount = 0;
//		try{
//			con = dataSource.getConnection();
//			
//			String query = "select count(*) as total from mvc_board";
//			pstmt = con.prepareStatement(query);
//			resultSet = pstmt.executeQuery();
//			
//			if (resultSet.next()) {
//				totalCount = resultSet.getInt("total");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(pstmt != null) pstmt.close();
//				if(con != null) con.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		
//		// 총 페이지 수
//		int totalPage = totalCount / listCount;
//		if (totalCount % listCount > 0)
//			totalPage++;
//		
//		// 현재 페이지
//		int myCurPage = curPage;
//		if (myCurPage > totalPage)
//			myCurPage = totalPage;
//		if (myCurPage < 1)
//			myCurPage = 1;
//		
//		// 시작 페이지
//		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
//		
//		// 끝 페이지
//		int endPage = startPage + pageCount + 1;
//		if (endPage > totalPage)
//			endPage = totalPage;
//		
//		BPageInfo pinfo = new BPageInfo();
//		// set
//		pinfo.setTotalCount(totalCount);
//		pinfo.setLinstCount(listCount);
//		pinfo.setTotalPage(totalPage);
//		pinfo.setCurPage(myCurPage);
//		pinfo.setPageCount(pageCount);
//		pinfo.setStartPage(startPage);
//		pinfo.setEndPage(endPage);
//		
//		return pinfo;
//	}
	
	
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}
	
	private void upHit(final String bId) {
		
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}	
		});
	}
	
	public void delete(final String bId) {

		String query = "delete from mvc_board where bId = ?";	
		template.update(query, new PreparedStatementSetter() {
				
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bId);
			}
		});
	}
	
	public BDto reply_view(String str) {
		
		String query = "select * from mvc_board where bId = " + str;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void reply(final String bId, final String bName, final String bTitle, final String bContent, 
						final String bGroup, final String bStep, final String bIndent) 
	{
		replyShape(bGroup, bStep);

		String query = "insert into mvc_board " +
					   " (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " +
					   " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}
	
	private void replyShape(final String strGroup, final String strStep) {
		
		String query = "update mvc_board set bStep = bStep + 1 " +
					   " where bGroup = ? and bStep > ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strGroup));
				ps.setInt(2, Integer.parseInt(strStep));
			}
		});
	}
}
