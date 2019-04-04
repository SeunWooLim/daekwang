package kr.or.daekwang.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;

public interface BoardService {

	List<BoardVo> personNewsList(int endRow);

	int listCount();

	List<ApplyVo> churchNewsList(HashMap<String, Object> map);

	int countChurchNews(HashMap<String, Object> countMap);

	int insertChurchNews(BoardVo boardVo);

	BoardVo selectChurchNewsDetail(int BOARD_NO);

	int addChurchNewsReadCount(int BOARD_NO);

	List<BoardVo> newFamilyIntroducing(int endRow);

	int insertNewFamilyIntroducing(BoardVo boardVo, PhotoVo photoVo);

	List<BoardVo> flowerPhotoList(int endRow);

	int insertFlowerPhoto(BoardVo boardVo, PhotoVo photoVo);

	int insertChurchPhotoBoardVo(BoardVo boardVo);

	int insertChurchPhotoPhotoVo(PhotoVo photoVo);

	List<Map< String, Object>> churchPhoto(int endRow);



}
