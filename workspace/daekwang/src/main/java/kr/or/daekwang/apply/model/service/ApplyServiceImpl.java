package kr.or.daekwang.apply.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.apply.model.dao.ApplyDao;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyDao applyDao;
}
