package kr.or.daekwang.sermonAndPraise.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.sermonAndPraise.model.dao.SermonAndPraiseDao;

@Service("sermonAndPraiseService")
public class SermonAndPraiseServiceImpl implements SermonAndPraiseService{
	
	@Autowired SermonAndPraiseDao sermonAndPraiseDao;
}
