<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/26/2025
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout.jsp" />
<jsp:body>
    <h3>Tìm NCC</h3>
    <form method="get" action="${pageContext.request.contextPath}/ncc">
        <input type="text" name="q" placeholder="MANCC/Tên/Địa chỉ/SĐT" value="${param.q}"/>
        <button>Tìm</button>
    </form>

    <h3>Danh sách NCC</h3>
    <ul>
        <c:forEach var="n" items="${nccList}">
            <li>
                <a href="${pageContext.request.contextPath}/ncc?mancc=${n.mancc}">
                        ${n.tennhacc} (Mã: ${n.mancc})
                </a>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${not empty dtList}">
        <h3>Sản phẩm thuộc NCC đã chọn</h3>
        <table border="1" cellpadding="6">
            <tr>
                <th>Mã</th><th>Tên</th><th>Năm SX</th><th>Cấu hình</th><th>Ảnh</th><th>Quản lý</th>
            </tr>
            <c:forEach var="d" items="${dtList}">
                <tr>
                    <td>${d.madt}</td>
                    <td>${d.tendt}</td>
                    <td>${d.namsanxuat}</td>
                    <td>${d.cauhinh}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/uploads/${d.hinhanh}" width="80"/>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/manage" method="post"
                              onsubmit="return confirm('Xóa sản phẩm này?')">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="madt" value="${d.madt}"/>
                            <button>Xóa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</jsp:body>
