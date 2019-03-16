package kr.or.daekwang.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.daekwang.apply.model.vo.ApplyVo;

public interface AdminService {

	List<ApplyVo> weekPageApplyAdminList(HashMap<String, Object> map);

	int countWeekPageApplyAdminList(HashMap<String, Object> countMap);

	int deleteWeekPageApplyAdmin(int apply_no);

	int ckDeleteWeekPageApplyAdmin(String idx);

	List<ApplyVo> worshipDataApplyAdminList(HashMap<String, Object> map);

	int countWorshipDataApplyAdmin(HashMap<String, Object> countMap);

	int deleteWorshipDataApplyAdmin(int apply_no);

	int ckDeleteWorshipDataApplyAdmin(String idx);

	List<ApplyVo> personNewsAdminList(HashMap<String, Object> map);

	int countPersonNewsAdmin(HashMap<String, Object> countMap);

	int deletePersonNewsAdmin(int apply_no);

	int ckDeletePersonNewsAdmin(String idx);

}
