package kr.or.daekwang.board.model.service;

import java.util.HashMap;
import java.util.List;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

public interface BoardService {

	List<BoardVo> personNewsList();

	int listCount();

	List<ApplyVo> churchNewsList(HashMap<String, Object> map);

	int countChurchNews(HashMap<String, Object> countMap);

	int insertChurchNews(BoardVo boardVo);

	BoardVo selectChurchNewsDetail(int BOARD_NO);

	int addChurchNewsReadCount(int BOARD_NO);

}
