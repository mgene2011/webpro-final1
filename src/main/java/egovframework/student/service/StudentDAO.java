package egovframework.student.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.student.StudentVO;

@Repository
public class StudentDAO {
	
	@Inject
	private SqlSession session;

	public void insertStudent(StudentVO vo) throws Exception {
        session.insert("Student_SQL.insert", vo);
    }

	public List<StudentVO> selectStudentList() throws Exception {
        return session.selectList("Student_SQL.select");
    }

}
