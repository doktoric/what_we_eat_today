<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%@page contentType="text/html;charset=UTF-8" %>

<c:url value="/resources" var="resource"/>
<c:url value="/resources/bootstrap" var="bootstrap"/>

<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="${resource}/favicon.ico"/>
    <meta charset="utf-8">
    <title>What we eat today</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="${bootstrap}/css/bootstrap.css" rel="stylesheet">
    <link href="${bootstrap}/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${bootstrap}/css/bootstrap-docs.css" rel="stylesheet">
    <link href="${bootstrap}/css/prettify.css" rel="stylesheet">
    <style type="text/css">
        .rest-tab {
            text-decoration: none !important;
        }
    </style>
</head>
<body data-twttr-rendered="true" style="padding-top: 0px;">

<div class="container" style="padding-top: 30px;">
    <div class="container">

        <div class="row">
            <div class="container">
                <form class="form-horizontal" method="post" action="<c:url value='/edit' />">
                    <legend>Edit Restaurant Daily</legend>
                    <div class="control-group">
                        <label class="control-label" for="restaurant">Restaurant: </label>

                        <div class="controls">
                            <select name="restaurant" id="restaurant">
                                <c:forEach items="${restaurants}" var="option">
                                    <option value="${option}">
                                        <c:out value="${option}"></c:out>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="day">Day: </label>

                        <div class="controls">
                            <select name="day" id="day">
                                <c:forEach items="${days}" var="option">
                                    <option value="${option}">
                                        <c:out value="${option}"></c:out>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="appetizer">Apptizer:</label>

                        <div class="controls">
                            <input type="text" name="appetizer" id="appetizer" placeholder="Appetizer...">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label"  for="mainDish">Main:</label>

                        <div class="controls">
                            <input type="text" name="mainDish" id="mainDish" placeholder="MainDish...">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="dessert">Dessert:</label>

                        <div class="controls">
                            <input type="text" name="dessert" id="dessert" placeholder="Dessert...">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn">Send</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${resource}/js/jquery-1.8.3.min.js"></script>

<script src="${bootstrap}/js/bootstrap.js"></script>
<script src="${bootstrap}/js/bootstrap.min.js"></script>
<script src="${bootstrap}/js/google-code-prettify/prettify.js"></script>

<script src="${resource}/js/bootstrap-affix.js"></script>
<script src="${resource}/js/bootstrap-alert.js"></script>
<script src="${resource}/js/bootstrap-button.js"></script>
<script src="${resource}/js/bootstrap-carusel.js"></script>
<script src="${resource}/js/bootstrap-collapse.js"></script>
<script src="${resource}/js/bootstrap-dropdown.js"></script>
<script src="${resource}/js/bootstrap-modal.js"></script>
<script src="${resource}/js/bootstrap-popover.js"></script>
<script src="${resource}/js/bootstrap-scrollspy.js"></script>
<script src="${resource}/js/bootstrap-tab.js"></script>
<script src="${resource}/js/bootstrap-tooltip.js"></script>
<script src="${resource}/js/bootstrap-transition.js"></script>
<script src="${resource}/js/bootstrap-typeahead.js"></script>
<script src="${resource}/js/holder.js"></script>
</body>
</html>