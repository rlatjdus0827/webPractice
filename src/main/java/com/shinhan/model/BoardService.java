package com.shinhan.model;

import java.util.List;

import com.shinhan.dto.BoardDTO;


public class BoardService {
	BoardDAO boardDao = new BoardDAO();
	
	public int deleteBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}
	public int updateBoard(BoardDTO board) {
		return boardDao.updateBoard(board);
	}
	public int insertBoard(BoardDTO board) {
		return boardDao.insertBoard(board);
	}
	public BoardDTO selectById(int bno) {
		return boardDao.selectById(bno);
	}
	public List<BoardDTO> selectAll() {
		return boardDao.selectAll();
	}
}
