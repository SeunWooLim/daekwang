package kr.or.daekwang.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.daekwang.admin.model.dao.AdminDao;
import kr.or.daekwang.apply.model.vo.ApplyVo;
import kr.or.daekwang.board.model.vo.BoardVo;

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
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWeekPageApplyAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
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
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteWorshipDataApplyAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
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
	public int deletePersonNewsAdmin(int board_no) {
		return adminDao.deletePersonNewsAdmin(board_no);
	}

	@Override
	public int ckDeletePersonNewsAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeletePersonNewsAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int insertPersonNewsAdmin(BoardVo boardVo) {
		return adminDao.insertPersonNewsAdmin(boardVo);
	}

	@Override
	public int updatePersonNewsAdmin(BoardVo boardVo) {
		return adminDao.updatePersonNewsAdmin(boardVo);
	}

	@Override
	public List<ApplyVo> churchNoticeAdminList(HashMap<String, Object> map) {
		return adminDao.churchNoticeAdminList(map);
	}

	@Override
	public int countChurchNoticeAdmin(HashMap<String, Object> countMap) {
		return adminDao.countChurchNoticeAdmin(countMap);
	}

	@Override
	public int deleteChurchNoticeAdmin(int board_no) {
		return adminDao.deleteChurchNoticeAdmin(board_no);
	}

	@Override
	public int ckDeleteChurchNoticeAdmin(String idx) {
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeleteChurchNoticeAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				stackNum++;
			}
		}
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int insertChurchNoticeAdmin(BoardVo boardVo) {
		return adminDao.insertChurchNoticeAdmin(boardVo);
	}

	@Override
	public int updateChurchNoticeAdmin(BoardVo boardVo) {
		return adminDao.updateChurchNoticeAdmin(boardVo);
	}

	@Override
	public List<ApplyVo> photoAdminList(HashMap<String, Object> map) {
		return adminDao.photoAdminList(map);
	}

	@Override
	public int countPhotoAdmin(HashMap<String, Object> countMap) {
		return adminDao.countPhotoAdmin(countMap);
	}

	@Override
	public int deletePhotoAdmin(int board_no) {
		int deleteResult = adminDao.deletePhotoAdmin(board_no);
		int result = 0;
		
		if(deleteResult != 0 ) {
			result = adminDao.deleteImagePhotoAdmin(board_no);
		}
		
		return result;
	}

	@Override
	public int ckDeletePhotoAdmin(String idx) {
		
		String[] arrIdx = idx.toString().split(",");
		int stackNum = 0;
		int result = 0;
		
		for (int i=0; i<arrIdx.length; i++) {
			result = adminDao.ckDeletePhotoAdmin(Integer.parseInt(arrIdx[i]));
			if(result > 0) {
				int photoResult = adminDao.deleteImagePhotoAdmin(Integer.parseInt(arrIdx[i]));
				
				if(photoResult != 0) {
					stackNum++;
				}
			}
		}
		
		if(stackNum == arrIdx.length) {
			return result;
		}else {
			return 0;
		}
	}

	@Override
	public int updatePhotoAdmin(BoardVo boardVo) {
		return adminDao.updatePhotoAdmin(boardVo);
	}
	
	
	
	
	
}
