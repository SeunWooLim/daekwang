package kr.or.daekwang.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.apply.model.vo.ApplyVo;

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

	public int deletePersonNewsAdmin(int apply_no) {
		return mybatis.update("adminMapper.deletePersoewsAdmin", apply_no);
	}

	public int ckDeletePersonNewsAdmin(String idx) {
		return mybatis.update("adminMapper.deletePersoewsAdmin", idx);
	}
}
