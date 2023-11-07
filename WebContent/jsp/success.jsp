<jsp:useBean id="register_course" class="model.Course" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style> 
body{
                position: relative;
                background-color:antiquewhite;
            }
           
            .box{
                width: 400px;
                height: 400px;
                background-color: whitesmoke;
                display: flex;
                justify-content: center;
                box-shadow: 0 0 50px 1px;
                position:absolute;
                left: 37%;
                border-radius: 20px;   
            }
            #submit{
            	border-radius:10px;
                padding: 10px;
            }
            .subleft{
            	padding-left: 50px;
            }
            .formbox input{
                width: 200px;
                line-height: 30px;
                outline: none;
                padding:  0 20px 0 20px;
                border-top: none;
                border-left: none;
                border-right: none;
                background: none;
                display: flex;
            }
</style>
 	<%@include file="header.jsp"%>
 	
 	<h1> Thank you for interesting to attend the session.
	All the detail information, we'll send via from email. 
	Please check. Have a nice day. </h1>
	
	<h1>Detail Register Session Information</h1>

	<table border="1" width="50%">
	<tr>
			<td>Register Name</td>
			<td><jsp:getProperty name="register_course" property="name"/></td>
		</tr>
		<tr>
			<td>Register Courses</td>
			<td><jsp:getProperty name="register_course" property="courses"/></td>
		</tr>
		<tr>
			<td>Register Trainingdate</td>
			<td><jsp:getProperty name="register_course" property="trainingdate"/></td>
		</tr>
		<tr>
			<td>Register Session</td>
			<td><jsp:getProperty name="register_course" property="session"/></td>
		</tr>
		<tr>
			<td>Register Email</td>
			<td><jsp:getProperty name="register_course" property="email"/></td>
		</tr>
		<tr>
			<td>Register Contact</td>
			<td><jsp:getProperty name="register_course" property="contact"/></td>
		</tr>
			
		
	</table>
	</br>
	<input type="button" value="return" onclick="javascript:history.back()">

</body>
</html>