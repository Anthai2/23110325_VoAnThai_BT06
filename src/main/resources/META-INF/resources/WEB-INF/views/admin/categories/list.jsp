<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>List Category</title></head>
<body>
<section class="row">
  <div class="col mt-4">
    <div class="card">
      <div class="card-header">List Category</div>
      <div class="card-body">
        <c:if test="${message != null}">
          <div class="alert alert-primary" role="alert"><i>${message}</i></div>
        </c:if>

        <div style="margin-bottom:10px">
          <form method="get" action="<c:url value='/admin/categories/search'/>">
            <input type="text" name="name" placeholder="Search by name"/>
            <button type="submit">Search</button>
            <a class="btn btn-primary" href="<c:url value='/admin/categories/add'/>">Add Category</a>
          </form>
        </div>

        <table class="table table-striped table-responsive">
          <thead>
          <tr><th>ID</th><th>Name</th><th>Action</th></tr>
          </thead>
          <tbody>
          <c:forEach items="${categories}" var="category">
            <tr>
              <td>${category.id}</td>
              <td>${category.categoryName}</td>
              <td>
                <a href="<c:url value='/admin/categories/view/${category.id}'/>">View</a>
                <a href="<c:url value='/admin/categories/edit/${category.id}'/>">Edit</a>
                <a href="<c:url value='/admin/categories/delete/${category.id}'/>">Delete</a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</section>
</body>
</html>
