package edu.mum.cs.cs472.labs.controller;

import edu.mum.cs.cs472.labs.model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "quiz",urlPatterns = {"/","/quiz"})
public class QuizServlet extends HttpServlet {
    private Quiz quiz;
    private static String sessionName = "quiz";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        if(session.getAttribute(sessionName) !=null){
            quiz = (Quiz)session.getAttribute(sessionName);
        }
        else {
            quiz = new Quiz();
            session.setAttribute(sessionName, quiz);
        }
        req.setAttribute("quiz",quiz);


        //out.println((Quiz)session.getAttribute(sessionName));
        if(quiz.currentQuestion() <= quiz.maxQuestionNos()) {
            RequestDispatcher rd = req.getRequestDispatcher("views/quiz.jsp");
            rd.forward(req,resp);

        }else{
            RequestDispatcher rd = req.getRequestDispatcher("views/result.jsp");
            rd.forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        quiz = (Quiz)session.getAttribute(sessionName);
        int questionNo = Integer.parseInt(req.getParameter("questionNo"));
        int ans = Integer.parseInt(req.getParameter("ans"));
        if(quiz!=null) {
            quiz.setAnswer(questionNo, ans);
        }
        session.setAttribute(sessionName, quiz);
        resp.sendRedirect("quiz");
    }
}
