<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
<div class="login-background">
    <div id="login-container" class="animation-fadeIn" style="z-index:9999;">
        <div class="login-title text-center">
            <h1><i class="gi gi-flash"></i> <strong>ActivePortal</strong><br>
                <small>Zaloguj sie</small>
            </h1>
        </div>

        <div class="block remove-margin">
            <form name='loginForm' action="auth" method='POST' class="form-horizontal form-bordered form-control-borderless">
                <div class="form-group">
                    <div class="col-xs-12">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i></span>
                            <input ng-model="username" focus-on="login" type="text" id="login" name="username"
                                   class="form-control input-lg" placeholder="Login">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="gi gi-asterisk"></i></span>
                            <input ng-model="password" type="password" id="login-password" name="password"
                                   class="form-control input-lg" placeholder="Hasło">
                        </div>
                    </div>
                </div>
                <div class="form-group form-actions">
                    <div class="col-xs-12 text-right">
                        <button type="submit" class="btn btn-sm btn-primary">
                            <i class="fa fa-sign-in"></i>
                            Zaloguj
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <p class="text-center remove-margin"></p>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script src="static/lib/jquery/jquery.min.js"></script>
<script>!window.jQuery && document.write(unescape('%3Cscript src="static/js/vendor/jquery-1.11.0.min.js"%3E%3C/script%3E'));</script>

<script src="static/lib/pro-ui/js/vendor/bootstrap.min.js"></script>
<script src="static/lib/pro-ui/js/plugins.js"></script>
<script src="static/lib/pro-ui/js/app.js"></script>
<script src="static/lib/pro-ui/js/ckeditor/ckeditor.js"></script>
<script src="static/lib/pnotify/jquery.pnotify.js"></script>
</body>
</html>