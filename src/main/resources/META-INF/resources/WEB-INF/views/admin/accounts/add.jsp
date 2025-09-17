<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><body>
<h2>Add / Edit User</h2>
<form method="post" action="<c:url value='/admin/users/saveOrUpdate'/>">
  <input type="hidden" name="id" value="${user.id}"/>
  Username: <input name="username" value="${user.username}"/><br/>
  Fullname: <input name="fullName" value="${user.fullName}"/><br/>
  Email: <input name="email" value="${user.email}"/><br/>
  Phone: <input name="phone" value="${user.phone}"/><br/>
  RoleId: <input name="roleId" value="${user.roleId}"/><br/>
  <button type="submit">Save</button>
  <a href="<c:url value='/admin/users'/>">Back</a>
</form>
</body></html>
