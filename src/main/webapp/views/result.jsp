<%--
  Created by IntelliJ IDEA.
  User: 610158
  Date: 9/18/2019
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>The Number Quiz</h2>
<p>Your Current Score is ${quiz.getScore()} </p>
<p>You have completed the number quiz with a score of ${quiz.getScore()}  out of  ${(quiz.currentQuestion()-1)}  </p>
</body>
</html>
