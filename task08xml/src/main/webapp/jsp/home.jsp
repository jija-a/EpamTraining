<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <style type="text/css">
        .welcome h1, h2{
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
        <form action="<c:url value="/controller?command=upload"/>">
            <p>Enter parsing type: <input type="text" name="parse_type"></p>
            <input type="file" id="myFile" name="filename">
            <input type="submit">
        </form>
    </div>
</div>
</body>
</html>