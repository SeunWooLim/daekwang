package kr.or.daekwang.apply.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.apply.model.dao.ApplyDao;
import kr.or.daekwang.apply.model.vo.ApplyVo;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyDao applyDao;

	@Override
	public int insertWeekPage(ApplyVo applyVo) {
		return applyDao.insertWeekPage(applyVo);
	}

	@Override
	public int insertWorshipData(ApplyVo applyVo) {
		return applyDao.insertWorshipData(applyVo);
	}
	
	
}
