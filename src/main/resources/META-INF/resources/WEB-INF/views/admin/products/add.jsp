<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
<%@ include file="/WEB-INF/views/common/_styles.jspf" %>
</head>
<html><body>
<h2>Add / Edit Video</h2>
<form method="post" action="<c:url value='/admin/videos/saveOrUpdate'/>">
  <input type="hidden" name="id" value="${video.id}"/>
  Title: <input name="title" value="${video.title}"/><br/>
  Poster: <input name="poster" value="${video.poster}"/><br/>
  Views: <input name="views" value="${video.views}"/><br/>
  Active: <input type="checkbox" name="active" <c:if test="${video.active}">checked</c:if> /><br/>
  Category:
  <select name="category.id">
    <c:forEach items="${categories}" var="c">
      <option value="${c.id}" <c:if test="${video.category != null && video.category.id == c.id}">selected</c:if>>${c.categoryName}</option>
    </c:forEach>
  </select><br/>
  Description:<br/>
  <textarea name="description">${video.description}</textarea><br/>
  <button type="submit">Save</button>
  <a href="<c:url value='/admin/videos'/>">Back</a>
</form>
</body></html>
