package kr.or.daekwang.sermonAndPraise.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.sermonAndPraise.model.dao.SermonAndPraiseDao;
import kr.or.daekwang.sermonAndPraise.model.vo.SermonAndPraiseVo;

@Service("sermonAndPraiseService")
public class SermonAndPraiseServiceImpl implements SermonAndPraiseService{
	
	@Autowired SermonAndPraiseDao sermonAndPraiseDao;

	@Override
	public SermonAndPraiseVo selectshalomChoir() {
		return sermonAndPraiseDao.selectshalomChoir();
	}

	@Override
	public SermonAndPraiseVo selectImmanuelChoir() {
		return sermonAndPraiseDao.selectImmanuelChoir();
	}
	
	
}
