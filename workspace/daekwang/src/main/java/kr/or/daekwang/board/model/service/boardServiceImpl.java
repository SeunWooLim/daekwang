package kr.or.daekwang.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.dao.BoardDao;
import kr.or.daekwang.board.model.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> personNewsList() {
		return boardDao.personNewsList();
	}

	@Override
	public int listCount() {
		return boardDao.listCount();
	}

	@Override
	public List<ApplyVo> churchNewsList(HashMap<String, Object> map) {
		return boardDao.churchNewsList(map);
	}

	@Override
	public int countChurchNews(HashMap<String, Object> countMap) {
		return boardDao.countChurchNews(countMap);
	}

	@Override
	public int insertChurchNews(BoardVo boardVo) {
		return boardDao.insertChurchNews(boardVo);
	}

	@Override
	public BoardVo selectChurchNewsDetail(int BOARD_NO) {
		return boardDao.selectChurchNewsDetail(BOARD_NO);
	}

	@Override
	public int addChurchNewsReadCount(int BOARD_NO) {
		return boardDao.addChurchNewsReadCount(BOARD_NO);
	}
	
	
	
	
}
