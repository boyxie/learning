<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>首页</title>
        <style>
            .form-control{
                border:1px solid #CCC;
                border-radius:3px;
                width:200px;
                height:24px;
                line-height:24px;
                font-size:16px
            }
            .btn{
                border:1px solid #CCC;
                border-radius:4px;
                color:#333;
                background-color:#FFF;
                padding:6px 12px;
                font-weight:400;
                font-size:14px;
            }
        </style>
    </head>
    <body>
        <div style="text-align:center;margin-top:50px">
            <form action="/client/oauth/callback" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit" class="btn">登录</button>
            </form>
        </div>
    </body>
</html>