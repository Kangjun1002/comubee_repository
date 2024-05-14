package com.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.contents.model.vo.Contents;

public class BoardService {

	public int listCount(String ca) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result=new BoardDao().listCount(conn,ca);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn,pi);
		JDBCTemplate.close(conn);
		return list;
	}

	public int increaseCount(int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().increaseCount(conn, bno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<Category> selectCategoryList() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Category> cList = new BoardDao().selectCategoryList(conn);
		JDBCTemplate.close(conn);
		return cList;
	}

	public Board selectBoard(int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Board b = new Board();
		b=new BoardDao().selectBoard(conn,bno);
		JDBCTemplate.close(conn);
		return b;
	}

	public ArrayList<Attachment> selectAttachment(int bno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Attachment> atList = new BoardDao().selectAttachment(conn,bno);
		JDBCTemplate.close(conn);
		return atList;
	}

	public ArrayList<Board> selectListById(PageInfo pi, String userId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectListById(conn,pi,userId);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Board> selectListByCategory(PageInfo pi, String ca) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().selectListbyCategory(conn,pi,ca);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Board> newPopList(Board b) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().newPopList(conn,b);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Board> bestPopList(Board b) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new BoardDao().bestPopList(conn,b);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Contents> bestContList() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Contents> list=new BoardDao().bestContList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		Connection conn=JDBCTemplate.getConnection();
		int result=new BoardDao().deleteBoard(conn,bno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public ArrayList<Board> selectNoticeListByCategory(){
		ArrayList<Board> noList=new ArrayList<>();
		Connection conn = JDBCTemplate.getConnection();
		noList=new BoardDao().selectNoticeListByCategory(conn);
		JDBCTemplate.close(conn);
		return noList;
	}
	
	public int insertBoard(Board b,ArrayList<Attachment> atList) {
		int result=0;
		Connection conn= JDBCTemplate.getConnection();
		result=new BoardDao().insertBoard(conn,b,atList);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertReply(Reply r) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn = JDBCTemplate.getConnection();
		result=new BoardDao().insertReply(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Reply> replyList(int bno) {
		// TODO Auto-generated method stub
		ArrayList<Reply> rList = new ArrayList<>();
		Connection conn = JDBCTemplate.getConnection();
		rList=new BoardDao().replyList(conn,bno);
		JDBCTemplate.close(conn);
		return rList;
	}

	public ArrayList<Contents> searchContentByTitle(String contTitle) {
		// TODO Auto-generated method stub
		ArrayList<Contents> cList=new ArrayList<>();
		Connection conn=JDBCTemplate.getConnection();
		cList=new BoardDao().searchContentByTitle(conn,contTitle);
		JDBCTemplate.close(conn);
		return cList;
	}

	public int updateBoard(Board b, ArrayList<Attachment> atList) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn=JDBCTemplate.getConnection();
		result=new BoardDao().updateBoard(conn,b,atList);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int likeCheck(int bno, String userId) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn = JDBCTemplate.getConnection();
		result=new BoardDao().likeCheck(conn,bno,userId);
		return result;
	}

	public int deleteLike(int bno, String userId) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn = JDBCTemplate.getConnection();
		result=new BoardDao().deleteLike(conn,bno,userId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertLike(int bno, String userId) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn = JDBCTemplate.getConnection();
		result=new BoardDao().insertLike(conn,bno,userId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int countLike(int bno) {
		int like=0;
		Connection conn=JDBCTemplate.getConnection();
		like=new BoardDao().countLike(conn,bno);
		JDBCTemplate.close(conn);
		return like;
	}

	public int updateBoardLike(int bno,int like) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn = JDBCTemplate.getConnection();
		result=new BoardDao().updateBoardLike(conn,bno,like);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectListByLike(PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<>();
		Connection conn = JDBCTemplate.getConnection();
		list=new BoardDao().selectListByLike(conn,pi);
		JDBCTemplate.close(conn);
		return list;
	}



}
