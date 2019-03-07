package kr.or.daekwang.board.model.service;

import java.util.List;

import kr.or.daekwang.board.model.vo.BoardVo;

public interface BoardService {

	List<BoardVo> personNewsList();

	int listCount();

}
