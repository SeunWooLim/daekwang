package kr.or.daekwang.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

public interface AdminService {

	List<ApplyVo> weekPageApplyAdminList(HashMap<String, Object> map);

	int countWeekPageApplyAdminList(HashMap<String, Object> countMap);

	int deleteWeekPageApplyAdmin(int apply_no);

	int ckDeleteWeekPageApplyAdmin(String idx);

	List<ApplyVo> worshipDataApplyAdminList(HashMap<String, Object> map);

	int countWorshipDataApplyAdmin(HashMap<String, Object> countMap);

	int deleteWorshipDataApplyAdmin(int apply_no);

	int ckDeleteWorshipDataApplyAdmin(String idx);

	List<ApplyVo> personNewsAdminList(HashMap<String, Object> map);

	int countPersonNewsAdmin(HashMap<String, Object> countMap);

	int deletePersonNewsAdmin(int board_no);

	int ckDeletePersonNewsAdmin(String idx);

	int insertPersonNewsAdmin(BoardVo boardVo);

	int updatePersonNewsAdmin(BoardVo boardVo);

	List<ApplyVo> churchNoticeAdminList(HashMap<String, Object> map);

	int countChurchNoticeAdmin(HashMap<String, Object> countMap);

	int deleteChurchNoticeAdmin(int board_no);

	int ckDeleteChurchNoticeAdmin(String idx);

	int insertChurchNoticeAdmin(BoardVo boardVo);

	int updateChurchNoticeAdmin(BoardVo boardVo);

	List<ApplyVo> photoAdminList(HashMap<String, Object> map);

	int countPhotoAdmin(HashMap<String, Object> countMap);

	int deletePhotoAdmin(int board_no);

	int ckDeletePhotoAdmin(String idx);

	int updatePhotoAdmin(BoardVo boardVo);

}
