<%--
  Created by IntelliJ IDEA.
  User: 610155
  Date: 9/18/2019
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="edu.mum.cs.cs472.labs.model.Quiz" %>
<html>
<head>
    <title>Quiz Assignment 13</title>
</head>
<body>
<div>
    <h2>The Number Quiz</h2>
    <% Quiz quiz = (Quiz)request.getAttribute("quiz"); %>
    <p>Your Current Score is <%= ((Quiz)request.getAttribute("quiz")).getScore()  %></p>
    <p>Guess the next number in the sequence</p>
    <p><%= quiz.getQuestion(quiz.currentQuestion())%></p>
    <form action="quiz" method="post">
        <label for="ans">Your Answer </label><input type="number" name="ans" id="ans">
        <br>
        <input type="hidden" value="<%=quiz.currentQuestion()%>" name="questionNo">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
