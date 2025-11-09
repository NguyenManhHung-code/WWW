<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/26/2025
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout.jsp" />
<jsp:body>
    <h3>Thêm mới điện thoại</h3>
    <p style="color:red">${error}</p>
    <form method="post" action="${pageContext.request.contextPath}/phone/new"
          enctype="multipart/form-data">
        <div>
            <label>Tên điện thoại*</label>
            <input name="tendt" required />
        </div>
        <div>
            <label>Năm sản xuất*</label>
            <input name="namsx" required pattern="^\d{4}$" title="4 chữ số"/>
        </div>
        <div>
            <label>Cấu hình*</label>
            <input name="cauhinh" required maxlength="255"/>
        </div>
        <div>
            <label>Nhà cung cấp*</label>
            <select name="mancc" required>
                <c:forEach var="n" items="${nccList}">
                    <option value="${n.mancc}">${n.tennhacc}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Hình ảnh*</label>
            <input type="file" name="hinhanh" accept=".png,.jpg,.jpeg" required />
        </div>
        <button>Thêm</button>
    </form>
</jsp:body>
