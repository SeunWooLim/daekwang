package kr.or.daekwang.nextGeneration.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.nextGeneration.model.dao.NextGenerationDao;
import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;

@Service("nextGenerationService")
public class NextGenerationServiceImpl implements NextGenerationService{
	
	@Autowired
	private NextGenerationDao nextGenerationDao;

	@Override
	public List<NextGenerationVo> selectNextGenerationList() {
		return nextGenerationDao.selectNextGenerationList();
	}

	@Override
	public List<NextGenerationVo> selectNextGenerationYouthList() {
		return nextGenerationDao.selectNextGenerationYouthList();
	}
	
	
	
}
