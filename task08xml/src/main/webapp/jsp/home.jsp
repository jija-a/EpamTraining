<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <style type="text/css">
        .welcome h1, h2 {
            text-align: center;
        }

        .welcome {
            font-family: arial;
            font-size: 24px;
            margin: 0 auto;
            width: 500px;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="welcome">
    <h1>Welcome!</h1>
    <h2>Choose file to upload: </h2>
    <div class="upload">
        <form action="<c:url value="/controller?command=upload"/>" method="post" enctype="multipart/form-data">
            <input type="text" name="parsing_type" />
            <input type="file" name="file" />
            <input type="submit" />
        </form>
    </div>
</div>
</body>
</html>