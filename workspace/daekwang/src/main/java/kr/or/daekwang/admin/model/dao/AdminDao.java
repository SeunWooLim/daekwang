package kr.or.daekwang.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

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
	
}
