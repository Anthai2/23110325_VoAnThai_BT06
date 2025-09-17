<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Home</title>
  <%@ include file="/WEB-INF/views/common/_styles.jspf" %>
</head>
<body>
<div class="container">
  <h1>Admin Dashboard</h1>
  <p class="muted">Chọn module để quản trị:</p>

  <div class="grid">
    <div class="card">
      <div class="card-header"><span>Categories</span></div>
      <div class="card-body">
        <p>Quản lý danh mục.</p>
        <div class="btn-group">
          <a class="btn btn-primary" href="<c:url value='/admin/categories'/>">Danh sách</a>
          <a class="btn btn-secondary" href="<c:url value='/admin/categories/add'/>">Thêm mới</a>
        </div>
      </div>
    </div>

    <div class="card">
      <div class="card-header"><span>Users</span></div>
      <div class="card-body">
        <p>Quản lý người dùng.</p>
        <div class="btn-group">
          <a class="btn btn-primary" href="<c:url value='/admin/users'/>">Danh sách</a>
          <a class="btn btn-secondary" href="<c:url value='/admin/users/add'/>">Thêm mới</a>
        </div>
      </div>
    </div>

    <div class="card">
      <div class="card-header"><span>Videos</span></div>
      <div class="card-body">
        <p>Quản lý video.</p>
        <div class="btn-group">
          <a class="btn btn-primary" href="<c:url value='/admin/videos'/>">Danh sách</a>
          <a class="btn btn-secondary" href="<c:url value='/admin/videos/add'/>">Thêm mới</a>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
