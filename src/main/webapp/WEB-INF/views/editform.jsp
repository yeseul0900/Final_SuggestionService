<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.finalproject.DAO.SuggestionDAO, com.finalproject.VO.SuggestionVO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Form</title>
</head>
<body>



<h1>Edit Form</h1>
<form:form modelAttribute="suggestionVO" method="post" action="../editok">
    <form:hidden path="seq"/>
    <table id="edit">
        <tr><td>Category:</td><td><form:input path="category"/></td></tr>
        <tr><td>Title:</td><td><form:input path="title"/></td></tr>
        <tr><td>Writer:</td><td><form:input path="writer"/></td></tr>
        <tr><td>Nickname:</td><td><form:input path="nickname"/></td></tr>
        <tr><td>Number:</td><td><form:input path="number"/></td></tr>
        <tr><td>Major:</td><td><form:input path="major"/></td></tr>
        <tr><td>Department:</td><td><form:input path="department"/></td></tr>
        <tr><td>Content:</td><td><form:textarea cols="50" rows="5" path="content" /></td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit Post"/>
            <input type="button" value="Cancel" onclick="history.back()" /></td></tr>
    </table>
</form:form>

</body>
</html>