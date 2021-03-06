package com.team5.controller.action;

import com.team5.dao.UserDAO;
import com.team5.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
*
*클래스 : JoinAction
*작성자 : 김지혜
*작성일 : 3/10/22
*
**/
public class JoinAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "auth/login.jsp";
        
        // joinForm.jsp 에서 생성된 변수로 유저 객체 생성
        UserVO userVO = new UserVO();
        userVO.setUsername(request.getParameter("username"));
        userVO.setPassword(request.getParameter("password"));

        // userDAO insert 메소드 호출
        UserDAO userDAO = UserDAO.getInstance();
        userDAO.insertUser(userVO);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}//end class
