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
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="./">Bootstrap</a>

        </div>
    </div>
</div>
<div class="jumbotron masthead">
    <div class="container">
        <h1>What we eat today</h1>
    </div>
</div>

<div class="container" style="padding-top: 30px;">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Run</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${restaurants}">
                    <tr>
                        <td>${item}</td>
                        <td>
                            <form class="form-horizontal" method="post" action="<c:url value='/runner/${item}' />">
                                <button type="submit" class="btn btn-success">Run</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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