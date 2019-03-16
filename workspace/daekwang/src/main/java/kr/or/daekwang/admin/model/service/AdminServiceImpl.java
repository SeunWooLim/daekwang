package kr.or.daekwang.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.admin.model.dao.AdminDao;
import kr.or.daekwang.apply.model.vo.ApplyVo;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<ApplyVo> weekPageApplyAdminList(HashMap<String, Object> map) {
		return adminDao.weekPageApplyAdminList(map);
	}

	@Override
	public int countWeekPageApplyAdminList(HashMap<String, Object> countMap) {
		return adminDao.countWeekPageApplyAdminList(countMap);
	}

	@Override
	public int deleteWeekPageApplyAdmin(int apply_no) {
		return adminDao.deleteWeekPageApplyAdmin(apply_no);
	}

	@Override
	public int ckDeleteWeekPageApplyAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		System.out.println("arrIdx : " + arrIdx);
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWeekPageApplyAdmin(Integer.parseInt(arrIdx[i]));
			System.out.println("arrIdx["+i+"] : " + arrIdx[i]);
			if(result > 0) {
				stackNum++;
			}
		}
		System.out.println(stackNum);
		System.out.println(result);
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public List<ApplyVo> worshipDataApplyAdminList(HashMap<String, Object> map) {
		return adminDao.worshipDataApplyAdminList(map);
	}

	@Override
	public int countWorshipDataApplyAdmin(HashMap<String, Object> countMap) {
		return adminDao.countWorshipDataApplyAdmin(countMap);
	}

	@Override
	public int deleteWorshipDataApplyAdmin(int apply_no) {
		return adminDao.deleteWorshipDataApplyAdmin(apply_no);
	}

	@Override
	public int ckDeleteWorshipDataApplyAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		System.out.println("arrIdx : " + arrIdx);
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWorshipDataApplyAdmin(Integer.parseInt(arrIdx[i]));
			System.out.println("arrIdx["+i+"] : " + arrIdx[i]);
			if(result > 0) {
				stackNum++;
			}
		}
		System.out.println(stackNum);
		System.out.println(result);
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public List<ApplyVo> personNewsAdminList(HashMap<String, Object> map) {
		return adminDao.personNewsAdminList(map);
	}

	@Override
	public int countPersonNewsAdmin(HashMap<String, Object> countMap) {
		return adminDao.countPersonNewsAdmin(countMap);
	}

	@Override
	public int deletePersonNewsAdmin(int apply_no) {
		return adminDao.deletePersonNewsAdmin(apply_no);
	}

	@Override
	public int ckDeletePersonNewsAdmin(String idx) {
		return adminDao.ckDeletePersonNewsAdmin(idx);
	}
	
	
	
	
}
