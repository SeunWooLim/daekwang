package kr.or.daekwang.nextGeneration.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;

@Repository("nextGenerationDao")
public class NextGenerationDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<NextGenerationVo> selectNextGenerationList() {
		return mybatis.selectList("nextGenerationMapper.selectNextGenerationList");
	}

	public List<NextGenerationVo> selectNextGenerationYouthList() {
		return mybatis.selectList("nextGenerationMapper.selectNextGenerationYouthList");
	}
	
	
}
