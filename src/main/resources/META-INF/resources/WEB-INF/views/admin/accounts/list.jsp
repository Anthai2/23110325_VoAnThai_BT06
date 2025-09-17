<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body>
<h2>Users</h2>
<form method="get">
  <input name="q" value="${q}" placeholder="Search username"/><button>Search</button>
  <a href="<c:url value='/admin/users/add'/>">Add</a>
</form>
<table border="1">
  <tr><th>ID</th><th>Username</th><th>Fullname</th><th>Email</th><th>Action</th></tr>
  <c:forEach items="${users}" var="u">
    <tr>
      <td>${u.id}</td><td>${u.username}</td><td>${u.fullName}</td><td>${u.email}</td>
      <td>
        <a href="<c:url value='/admin/users/edit/${u.id}'/>">Edit</a>
        <a href="<c:url value='/admin/users/delete/${u.id}'/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body></html>
