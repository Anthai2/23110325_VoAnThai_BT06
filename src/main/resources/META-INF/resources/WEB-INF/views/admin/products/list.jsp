<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body>
<h2>Videos</h2>
<form method="get">
  <input name="q" value="${q}" placeholder="Search title"/><button>Search</button>
  <a href="<c:url value='/admin/videos/add'/>">Add</a>
</form>
<table border="1">
  <tr><th>ID</th><th>Title</th><th>Category</th><th>Views</th><th>Active</th><th>Action</th></tr>
  <c:forEach items="${videos}" var="v">
    <tr>
      <td>${v.id}</td>
      <td>${v.title}</td>
      <td><c:out value="${v.category != null ? v.category.categoryName : ''}"/></td>
      <td>${v.views}</td>
      <td>${v.active}</td>
      <td>
        <a href="<c:url value='/admin/videos/edit/${v.id}'/>">Edit</a>
        <a href="<c:url value='/admin/videos/delete/${v.id}'/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body></html>
