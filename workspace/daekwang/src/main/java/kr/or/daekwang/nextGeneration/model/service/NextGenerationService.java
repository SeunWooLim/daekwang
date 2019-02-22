package kr.or.daekwang.nextGeneration.model.service;

import java.util.List;

import kr.or.daekwang.nextGeneration.model.vo.NextGenerationVo;

public interface NextGenerationService {

	List<NextGenerationVo> selectNextGenerationList();

	List<NextGenerationVo> selectNextGenerationYouthList();

}
