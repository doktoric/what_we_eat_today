<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<c:url value="/resources" var="resource"/>
<c:url value="/resources/bootstrap" var="bootstrap"/>

<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="${resource}/favicon.ico" />
    <meta charset="utf-8">
    <title>What we eat today</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="${bootstrap}/css/bootstrap.css" rel="stylesheet">
    <link href="${bootstrap}/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${bootstrap}/css/bootstrap-docs.css" rel="stylesheet">
    <link href="${bootstrap}/css/prettify.css" rel="stylesheet">
    <link href="${resource}/css/flat-ui.css" rel="stylesheet">
    <style type="text/css">
        .rest-tab {text-decoration: none !important;}
    </style>
</head>
<body data-twttr-rendered="true" style="padding-top: 0px;">

<div class="jumbotron masthead">
    <div class="container">
        <h1>What we eat today</h1>
    </div>
</div>

<div class="container" style="padding-top: 30px;">
    <div class="tabbable tabs-left">
        <ul class="nav nav-tabs">
            <li class="active" ><a class="rest-tab" href="#kompot" data-toggle="tab">Kompót</a></li>
            <li><a class="rest-tab" href="#fiktiv" data-toggle="tab">Fiktív</a></li>
            <li><a class="rest-tab" href="#klubcaffe" data-toggle="tab">Klub Caffe</a></li>
            <li><a class="rest-tab" href="#tenminutes" data-toggle="tab">Ten Minutes</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="kompot">
                <div class="page-header">
                    <h1>Kompót étlap</h1>
                </div>
            </div>
            <div class="tab-pane" id="fiktiv">
                <div class="page-header">
                    <h1>Fiktív étlap</h1>
                </div>
            </div>
            <div class="tab-pane" id="klubcaffe">
                <div class="page-header">
                    <h1>Club Caffe étlap</h1>
                </div>
            </div>
            <div class="tab-pane" id="tenminutes">
                <div class="page-header">
                    <h1>Ten Minutes étlap</h1>
                </div>
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