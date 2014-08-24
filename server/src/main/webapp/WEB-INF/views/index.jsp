<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>ActivePortal - platforma społeczności aktywnej</title>

    <meta name="description" content="ActivePortal - platforma społeczności aktywnej">
    <meta name="robots" content="noindex, nofollow">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate"/>
    <meta http-equiv="Cache-Control" content="post-check=0, pre-check=0"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <link rel="shortcut icon" href="static/lib/pro-ui/img/favicon.ico">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon57.png" sizes="57x57">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon72.png" sizes="72x72">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon76.png" sizes="76x76">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon114.png" sizes="114x114">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon120.png" sizes="120x120">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon144.png" sizes="144x144">
    <link rel="apple-touch-icon" href="static/lib/pro-ui/img/icon152.png" sizes="152x152">

    <link rel="stylesheet" href="static/lib/pro-ui/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/lib/pro-ui/css/plugins.css">
    <link rel="stylesheet" href="static/lib/pro-ui/css/main.css">
    <link rel="stylesheet" href="static/lib/pro-ui/css/themes/fancy.css">
    <link rel="stylesheet" href="static/lib/pro-ui/css/themes.css">

    <link href="static/lib/pnotify/jquery.pnotify.default.css" rel="stylesheet" media="screen"/>
    <link href="static/lib/loading-bar/loading-bar.css" rel="stylesheet" media="screen"/>

    <link href="static/css/style.css" rel="stylesheet" media="screen"/>
    <link href="static/css/animations.css" rel="stylesheet" media="screen"/>
    <script src="static/lib/pro-ui/js/vendor/modernizr-2.7.1-respond-1.4.2.min.js"></script>
</head>
<body ng-app="PortalApp" ng-init="injectAuthentication('${user.firstName}','${user.lastName}','${user.type}')">
<div id="page-container" class="sidebar-partial sidebar-visible-lg" ng-cloak>
    <div id="sidebar">
        <div class="sidebar-scroll">
            <div class="sidebar-content">
                <a href="index.html" class="sidebar-brand">
                    <i class="gi gi-baseball"></i><strong>Active</strong>Portal
                </a>

                <div class="sidebar-section sidebar-user clearfix">
                    <div class="sidebar-user-avatar">
                        <a href="page_ready_user_profile.html">
                            <img src="static/lib/pro-ui/img/placeholders/avatars/avatar2.jpg" alt="avatar">
                        </a>
                    </div>
                    <div class="sidebar-user-name">{{user.firstName + " " + user.lastName}}</div>
                    <div class="sidebar-user-links">
                    <span ng-show="hasRole('ROLE_ADMIN')">
                        Administrator
                    </span>
                    <span ng-show="hasRole('ROLE_COMPANY')">
                        Firma
                    </span>
                    </div>
                </div>

                <ul class="sidebar-nav">
                    <c:forEach var="group" items="${menu}">
                        <li class="sidebar-header">
                            <span class="sidebar-header-title">${group.header}</span>
                        </li>
                        <c:forEach var="item" items="${group.items}">
                            <li>
                                <a ui-sref="${item.state}" class="sidebar-nav-menu" ng-class="{active: $state.includes('${item.state}')}">
                                    <i class="${item.icon} sidebar-nav-icon"></i>
                                    ${item.label}
                                </a>
                            </li>
                        </c:forEach>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <div id="main-container">
        <header class="navbar navbar-default">
            <ul class="nav navbar-nav-custom">
                <li>
                    <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');">
                        <i class="fa fa-bars fa-fw"></i>
                    </a>
                </li>
            </ul>

            <ul class="nav navbar-nav-custom pull-right">
                <li>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="Profil">
                        <i class="gi gi-user"></i>
                    </a>
                </li>
                <li>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="Wiadomości">
                        <i class="gi gi-envelope"></i>
                        <span class="label label-primary label-indicator">4</span>
                    </a>
                </li>
                <li>
                    <a href="#" data-toggle="tooltip" data-placement="bottom" title="Ustawienia">
                        <i class="gi gi-cogwheel"></i>
                    </a>
                </li>
                <li>
                    <a href="logout" data-toggle="tooltip" data-placement="bottom" title="Wyloguj">
                        <i class="gi gi-gi gi-exit"></i>
                    </a>
                </li>
            </ul>
        </header>

        <div id="page-content">
            <div class="angular-view" ui-view></div>
        </div>

        <footer class="clearfix">
            <div class="pull-right">
                Crafted with <i class="fa fa-heart text-danger"></i> by <a href="http://goo.gl/vNS3I" target="_blank">pixelcave</a>
            </div>
            <div class="pull-left">
                <span id="year-copy"></span> &copy; <a href="http://goo.gl/TDOSuC" target="_blank">Active-Portal 1.2</a>
            </div>
        </footer>
    </div>
</div>

<a href="#" id="to-top"><i class="fa fa-angle-double-up"></i></a>

<script src="static/lib/jquery/jquery.min.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="static/lib/pro-ui/js/vendor/jquery-1.11.0.min.js"%3E%3C/script%3E'));</script>

<script src="static/lib/pro-ui/js/vendor/bootstrap.min.js"></script>
<script src="static/lib/pro-ui/js/plugins.js"></script>
<script src="static/lib/pro-ui/js/app.js"></script>
<script src="static/lib/pro-ui/js/ckeditor/ckeditor.js"></script>
<script src="static/lib/pnotify/jquery.pnotify.js"></script>

<script src="static/lib/angular/angular.min.js"></script>
<script src="static/lib/angular/angular-sanitize.min.js"></script>
<script src="static/lib/angular/angular-resource.min.js"></script>
<script src="static/lib/angular/angular-cookies.js"></script>
<script src="static/lib/angular/angular-animate.js"></script>
<script src="static/lib/angular-ui/ng-grid.js"></script>
<script src="static/lib/angular-ui/angular-ui-router.min.js"></script>
<script src="static/lib/loading-bar/loading-bar.js"></script>

<script src="static/js/app.js"></script>
<script src="static/js/utils.js"></script>

<script src="static/js/services/news-service.js"></script>
<script src="static/js/services/notification-service.js"></script>
<script src="static/js/services/user-service.js"></script>
<script src="static/js/services/menu-service.js"></script>
<script src="static/js/services/room-service.js"></script>

<script src="static/js/controllers/class-controller.js"></script>
<script src="static/js/controllers/news-controller.js"></script>
<script src="static/js/controllers/user-controller.js"></script>
<script src="static/js/controllers/room-controller.js"></script>

<script src="static/js/filters.js"></script>
<script src="static/js/directives.js"></script>
</body>
</html>
