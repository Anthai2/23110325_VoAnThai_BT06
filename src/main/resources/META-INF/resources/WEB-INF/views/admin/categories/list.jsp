<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>List Category</title>
  <%@ include file="/WEB-INF/views/common/_styles.jspf" %>
</head>
<body>
<div class="container">
  <div class="card">
    <div class="card-header">
      <span>List Category</span>
      <a class="btn btn-primary" href="<c:url value='/admin/categories/add'/>">Add Category</a>
    </div>

    <div class="card-body">
      <!-- Thông báo -->
      <c:if test="${not empty message}">
        <div class="alert alert-success mb-3"><i>${message}</i></div>
      </c:if>

      <!-- Tìm kiếm -->
      <form class="mb-3" method="get" action="<c:url value='/admin/categories'/>">
        <div class="form-row">
          <div>
            <input type="text" name="name" value="${name}" placeholder="Search by name">
          </div>
          <div class="text-right">
            <button type="submit" class="btn btn-secondary">Search</button>
            <a class="btn btn-outline" href="<c:url value='/admin/categories'/>">Clear</a>
          </div>
        </div>
      </form>

      <!-- Bảng -->
      <div class="table-responsive">
        <table class="table table-striped">
          <thead class="thead-inverse">
          <tr>
            <th style="width:110px">ID</th>
            <th>Name</th>
            <th style="width:280px">Action</th>
          </tr>
          </thead>
          <tbody>
          <c:choose>
            <c:when test="${empty categories}">
              <tr><td colspan="3">No categories found.</td></tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${categories}" var="category">
                <tr>
                  <td>${category.id}</td>
                  <td>${category.categoryName}</td>
                  <td>
                    <a class="btn btn-outline"
                       href="<c:url value='/admin/categories/view/${category.id}'/>">View</a>
                    <a class="btn btn-secondary"
                       href="<c:url value='/admin/categories/edit/${category.id}'/>">Edit</a>
                    <a class="btn btn-danger"
                       href="<c:url value='/admin/categories/delete/${category.id}'/>"
                       onclick="return confirm('Delete category #${category.id}?');">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          </tbody>
        </table>
      </div>

      <!-- Phân trang -->
      <c:if test="${page != null && page.totalPages > 1}">
        <nav aria-label="pagination" class="mt-4">
          <ul class="pagination">
            <li class="page-item ${page.first ? 'disabled' : ''}">
              <a class="page-link"
                 href="<c:url value='/admin/categories'>
                          <c:param name='page' value='${page.number - 1}'/>
                          <c:param name='size' value='${page.size}'/>
                          <c:param name='name' value='${name}'/>
                       </c:url>">Prev</a>
            </li>
            <c:forEach var="i" begin="0" end="${page.totalPages - 1}">
              <li class="page-item ${i == page.number ? 'active' : ''}">
                <a class="page-link"
                   href="<c:url value='/admin/categories'>
                            <c:param name='page' value='${i}'/>
                            <c:param name='size' value='${page.size}'/>
                            <c:param name='name' value='${name}'/>
                         </c:url>">${i + 1}</a>
              </li>
            </c:forEach>
            <li class="page-item ${page.last ? 'disabled' : ''}">
              <a class="page-link"
                 href="<c:url value='/admin/categories'>
                          <c:param name='page' value='${page.number + 1}'/>
                          <c:param name='size' value='${page.size}'/>
                          <c:param name='name' value='${name}'/>
                       </c:url>">Next</a>
            </li>
          </ul>
        </nav>
      </c:if>

    </div>
  </div>
</div>
</body>
</html>
