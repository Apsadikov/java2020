<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>${head}</h1>

<ul>
        <#list items as item>
            <li>
                <#if item<0.4>
                    <b>${item}!!!</b>
                <#else>
                    ${item}
                </#if>
            </li>
        </#list>
</ul>

</body>
</html>