package egovframework.student.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.student.StudentVO;
import egovframework.student.service.StudentService;

@Controller
@SessionAttributes(types=StudentVO.class)
public class StudentController {

    @Inject
    private StudentService studentService;
    
    @RequestMapping(value="/student/StudentList")
    public String selectStudentList(ModelMap model) throws Exception {
    	List<?> studentList = studentService.selectStudentList();
        model.addAttribute("resultList", studentList);
        
        return "/student/StudentList";
    } 
    
    @RequestMapping("/student/addStudentView")
    public String addStudentView(Model model) throws Exception {
        model.addAttribute("studentVO", new StudentVO());
        return "/student/StudentRegister";
    }
    
    @RequestMapping("/student/addStudent")
    public String addStudent(StudentVO studentVO, SessionStatus status) throws Exception {
        studentService.insertStudent(studentVO);
        status.setComplete();
        return "forward:/student/StudentList";
    }

}
