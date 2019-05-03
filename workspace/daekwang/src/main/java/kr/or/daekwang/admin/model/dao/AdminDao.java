package kr.or.daekwang.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.admin.model.vo.SliderVo;
import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;
import kr.or.daekwang.board.model.vo.PhotoVo;
import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;
import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Repository("adminDao")
public class AdminDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<ApplyVo> weekPageApplyAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.weekPageApplyAdminList", map);
	}

	public int countWeekPageApplyAdminList(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countWeekPageApplyAdminList", countMap);
	}

	public int deleteWeekPageApplyAdmin(int apply_no) {
		return mybatis.update("adminMapper.deleteWeekPageApplyAdmin", apply_no);
	}

	public int ckDeleteWeekPageApplyAdmin(int checkNum) {
		return mybatis.update("adminMapper.deleteWeekPageApplyAdmin", checkNum);
	}

	public List<ApplyVo> worshipDataApplyAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.worshipDataApplyAdminList", map);
	}

	public int countWorshipDataApplyAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countWorshipDataApplyAdmin", countMap);
	}

	public int deleteWorshipDataApplyAdmin(int apply_no) {
		return mybatis.update("adminMapper.deleteWorshipDataApplyAdmin", apply_no);
	}

	public int ckDeleteWorshipDataApplyAdmin(int checkNum) {
		return mybatis.update("adminMapper.deleteWorshipDataApplyAdmin", checkNum);
	}

	public List<ApplyVo> personNewsAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.personNewsAdminList", map);
	}

	public int countPersonNewsAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countPersonNewsAdmin", countMap);
	}

	public int deletePersonNewsAdmin(int board_no) {
		return mybatis.update("adminMapper.deletePersoewsAdmin", board_no);
	}

	public int ckDeletePersonNewsAdmin(int checkNum) {
		return mybatis.update("adminMapper.deletePersoewsAdmin", checkNum);
	}

	public int insertPersonNewsAdmin(BoardVo boardVo) {
		return mybatis.insert("adminMapper.insertPersonNewsAdmin", boardVo);
	}

	public int updatePersonNewsAdmin(BoardVo boardVo) {
		return mybatis.update("adminMapper.updatePersonNewsAdmin", boardVo);
	}

	public List<ApplyVo> churchNoticeAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.churchNoticeAdminList", map);
	}

	public int countChurchNoticeAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countChurchNoticeAdmin", countMap);
	}

	public int deleteChurchNoticeAdmin(int board_no) {
		return mybatis.update("adminMapper.deleteChurchNoticeAdmin", board_no);
	}

	public int ckDeleteChurchNoticeAdmin(int parseInt) {
		return mybatis.update("adminMapper.deleteChurchNoticeAdmin", parseInt);
	}

	public int insertChurchNoticeAdmin(BoardVo boardVo) {
		return mybatis.insert("adminMapper.insertChurchNoticeAdmin", boardVo);
	}

	public int updateChurchNoticeAdmin(BoardVo boardVo) {
		return mybatis.update("adminMapper.updateChurchNoticeAdmin", boardVo);
	}

	public List<ApplyVo> photoAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.photoAdminList", map);
	}

	public int countPhotoAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countPhotoAdmin", countMap);
	}

	public int deletePhotoAdmin(int board_no) {
		return mybatis.update("adminMapper.deletePhotoAdmin", board_no);
	}

	public int ckDeletePhotoAdmin(int parseInt) {
		return mybatis.update("adminMapper.deletePhotoAdmin", parseInt);
	}
	
	public int deleteImagePhotoAdmin(int board_no) {
		return mybatis.update("adminMapper.deleteImagePhotoAdmin", board_no);
	}

	public int updatePhotoAdmin(BoardVo boardVo) {
		return mybatis.update("adminMapper.updatePhotoAdmin", boardVo);
	}

	public List<ApplyVo> memberAdminList(HashMap<String, Object> map) {
		return mybatis.selectList("adminMapper.memberAdminList", map);
	}

	public int countMemberAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countMemberAdmin", countMap);
	}

	public int updateMemberAuthChange(HashMap<String, Object> map) {
		return mybatis.update("adminMapper.updateMemberAuthChange", map);
	}

	public int insertDeleteDate(int board_no) {
		return mybatis.update("adminMapper.insertDeleteDate", board_no);
	}

	public List<BoardVo> churchPhotoBoardMap(HashMap<String, Object> mapp) {
		return mybatis.selectList("adminMapper.churchPhotoBoardMap", mapp);
	}

	public int PhotoListCount(int board_no) {
		return mybatis.selectOne("adminMapper.PhotoListCount", board_no);
	}

	public List<PhotoVo> churchPhotoPhotoList(int board_no) {
		return mybatis.selectList("adminMapper.churchPhotoPhotoList", board_no);
	}

	public int countChurchPhotoAdmin(HashMap<String, Object> countMap) {
		return mybatis.selectOne("adminMapper.countChurchPhotoAdmin", countMap);
	}

	public SermonAndPraiseVo choirAdminList(char PRAISE_FG) {
		return mybatis.selectOne("adminMapper.choirAdminList", PRAISE_FG);
	}

	public int modifyChoirAdmin(SermonAndPraiseVo sermonAndPraiseVo) {
		return mybatis.update("adminMapper.modifyChoirAdmin", sermonAndPraiseVo);
	}

	public List<NextGenerationVo> selectNextGenerationList() {
		return mybatis.selectList("adminMapper.selectNextGenerationList");
	}

	public List<NextGenerationVo> selectNextGenerationYouthList() {
		return mybatis.selectList("adminMapper.selectNextGenerationYouthList");
	}

	public int modifyChurchSchoolAdmin(NextGenerationVo nextGenerationVo) {
		return mybatis.update("adminMapper.modifyChurchSchoolAdmin", nextGenerationVo);
	}

	public List<ApplyVo> mainSlideAdminList() {
		return mybatis.selectList("adminMapper.mainSlideAdminList");
	}

	public int deleteMainSlideAdmin(int slider_no) {
		return mybatis.delete("adminMapper.deleteMainSlideAdmin", slider_no);
	}

	public int updateMainSlideAdmin(SliderVo sliderVo) {
		return mybatis.update("adminMapper.updateMainSlideAdmin", sliderVo);
	}

	public int insertMainSlideAdmin(SliderVo sliderVo) {
		return mybatis.insert("adminMapper.insertMainSlideAdmin", sliderVo);
	}
	
	public List<PhotoVo> autoDeletePhoto() {
		return mybatis.selectList("adminMapper.autoDeletePhoto");
	}

	public int completeDeletePhoto(String photo_rename) {
		return mybatis.delete("adminMapper.completeDeletePhoto", photo_rename);
	}

}
