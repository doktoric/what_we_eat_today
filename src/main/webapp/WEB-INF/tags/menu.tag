<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="item" required="true" type="com.acme.doktorics.domain.DailyMenu" %>
<div class="alert alert-info">
    <strong><c:out value="${item.day}"/></strong>
    <c:if test="${not empty item.appetizer}">
        <p>
            <c:out value="${item.appetizer}"/>
        </p>
    </c:if>
    <c:if test="${not empty item.mainDish}">
        <p>
            <c:out value="${item.mainDish}"/>
        </p>
    </c:if>
    <c:if test="${not empty item.dessert}">
        <p>
            <c:out value="${item.dessert}"/>
        </p>
    </c:if>
</div>