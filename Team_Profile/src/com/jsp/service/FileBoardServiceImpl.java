package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.FFileDAO;
import com.jsp.dao.FileBoardDAO;
import com.jsp.dto.FFileVO;
import com.jsp.dto.FileBoardVO;

public class FileBoardServiceImpl implements FileBoardService {
	

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private FileBoardDAO fileBoardDAO;
	public void setFileBoardDAO(FileBoardDAO fileBoardDAO) {
		this.fileBoardDAO = fileBoardDAO;
	}

	private FFileDAO fFileDAO;
	public void setFFileDAO(FFileDAO fFileDAO) {
		this.fFileDAO = fFileDAO;
	}

	@Override
	public Map<String, Object> getFileBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<FileBoardVO> fileBoardList = fileBoardDAO.selectFileBoardList(session, cri);
		
			if (fileBoardList != null)
				for (FileBoardVO fileBoard : fileBoardList)
					addFFileList(session, fileBoard);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(fileBoardDAO.selectFileBoardCount(session, cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("fileBoardList", fileBoardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public FileBoardVO getFileBoard(int f_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			FileBoardVO fileBoard = fileBoardDAO.selectFileBoardByf_no(session, f_no);
			System.out.println(fileBoard.getF_title());
			addFFileList(session, fileBoard);
			
			return fileBoard;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(FileBoardVO fileBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int f_no = fileBoardDAO.getSeqNextValue(session);

			fileBoard.setF_no(f_no);
			fileBoardDAO.insertFileBoard(session, fileBoard);		

			if (fileBoard.getfFileList() != null)
				for (FFileVO fFile : fileBoard.getfFileList()) {
					fFile.setF_no(f_no);
					fFile.setAttacher(fileBoard.getF_writer());
					fFileDAO.insertFFile(session, fFile);
				}
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(FileBoardVO fileBoard) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			fileBoardDAO.updateFileBoard(session, fileBoard);		
			if (fileBoard.getfFileList() != null)
				for (FFileVO fFile : fileBoard.getfFileList()) {
					fFile.setF_no(fileBoard.getF_no());
					fFile.setAttacher(fileBoard.getF_writer());
					fFileDAO.insertFFile(session, fFile);
				}

		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int f_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			fileBoardDAO.deleteFileBoard(session, f_no);
			
		} finally {
			session.close();
		}
	}

	private void addFFileList(SqlSession session, FileBoardVO fileBoard) throws SQLException {

		if (fileBoard == null)
			return;

		int f_no = fileBoard.getF_no();
		List<FFileVO> fFileList = fFileDAO.selectFFilesByf_no(session, f_no);

		fileBoard.setfFileList(fFileList);
	}

	@Override
	public FFileVO getFFileBya_no(int ano) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			FFileVO fFile = fFileDAO.selectFFileBya_no(session, ano);

			return fFile;
		} finally {
			session.close();
		}
	}

	@Override
	public void removeFFileBya_no(int a_no) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			fFileDAO.deleteFFile(session, a_no);

		} finally {
			session.close();
		}

	}
}
