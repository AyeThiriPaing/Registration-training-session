<%@page import="java.util.ArrayList"%>
<%--Importing all the dependent classes--%>
<%@page import="model.Course"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	<h1>Training Session Register </h1>
	
	<form method="post" action="registerSession">
	
		
		
		<label>Name</label> 
		<input type="text" name="name"/> <br/> <br/>
		
		<label>Courses</label>
		<select name="courses">
			<%
		

			if (request.getAttribute("mycourses") != null) 
			{
				List<String> courses = (List<String>) request.getAttribute("mycourses");
				for (int i = 0; i < courses.size(); i++) {
					%>
					
					<option><%=courses.get(i)%></option>
					<%  
					}

			}
			%>
			
		</select> <br/> <br/>
		
		
		
		<label>Training Date</label>
		<select name="trainingdate"/> 
		<option>1-Apr-2022</option>
		<option>15-Apr-2022</option>
		<option>25-Apr-2022</option>
		</select><br/><br/>
		
		<label>Session</label>
		<input type="radio" name="session" value="Morning">Morning <input type="radio" name="session" value="Evening">Evening <br/> <br/>
		
		<label>Email</label>
		<input type="email" name="email"/> <br/> <br/>
		
		<label>Contact</label> 
		<input type="text" name="contact"/> <br/> <br/>
		
		
		
		<br/> <br/>
		<input type="submit" value="Attend the Session" />

	</form>


</body>
</html>