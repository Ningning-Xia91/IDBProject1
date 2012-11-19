<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"     
    import = "java.util.ArrayList" import="java.util.Iterator" 
    import = "happyH.models.User"
    import = "happyH.models.Special"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View specials</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="fullsize/fullsize.css" media="screen" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="fullsize/jquery.js"></script>
<script type="text/javascript"
	src="fullsize/jquery.fullsize.minified.js"></script>
<script language="javascript" type="text/javascript">
function clearText(field)
{
	if (field.defaultValue == field.value) field.value = '';
	else if (field.value == '') field.value = field.defaultValue;
}
$(function(){
				$("div.templatemo_gallery img").fullsize();
			});
</script>
</head>
<body>
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="templatemo_logo_area">
				<div id="templatemo_logo">HAPPYH</div>
				<div id="templatemo_slogan">Your Happy Hour</div>
			</div>
			<div id="templatemo_social">
				<img
					src="images/templatemo_icon_3.jpg" alt="RSS" /><img
					src="images/templatemo_icon_2.jpg" alt="Twitter" /><img
					src="images/templatemo_icon_1.jpg" alt="Delicious" />
				<form action="http://www.mycodes.net" method="post">
				<table>
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%if(session.getAttribute("user")==null) {%>
				<a href="signUp.jsp">SignUp</a></li>
					 &nbsp;|&nbsp; <a href="login.jsp" class="last">Login</a></li>
		
				<%
				}
				else
				{
					User user = (User)session.getAttribute("user");
					String userName = user.getU_name();	
					out.println("Welcome!   "+userName);
					} 
					%>
</td>
					</tr>
				</table>
					<!-- <input type="text" value="SEARCH" name="q" class="field"
						title="email" onfocus="clearText(this)" onblur="clearText(this)" />
					 <input type="submit" name="search" value="" alt="Search"
						class="button" title="Subscribe" />-->
				</form>
			</div>
			<div id="templatemo_menu">
				<ul>
					<li><a href="firstPage.jsp" class="current">Home</a></li>	
					<li><a href="viewRestaurant">Restaurants</a></li>
					<li><a href="viewEvent">Events</a></li>
					<li><a href="viewSpecial">Special Types</a></li>
					<li><a href="search.jsp" class="last">Search</a></li>
					<%if(session.getAttribute("user")!=null)
					{%>
					<li><a href="Logout">Logout</a></li>
					<%
					}
					%>
				</ul>
			</div>
			<!-- end of menu -->
		</div>
		<div id="templatemo_content_area">

			<p>
				<!-- End of left -->
			</p>
			
			<table align="center" height ="300">
			<% if (request.getAttribute("specialList")!=null)
				{%>
			<tr>
			<td align = "center" colspan = "3">
			<span class = "blue_title" ><%= String.valueOf(request.getAttribute("rname")) %></span></td></tr>
			<tr>
			<td ><h2>Specials</h2></td>
			<td><h2>Details</h2></td>
			<td>
			<h2>Price</h2></td>
			
			</tr>
			<%
			
			ArrayList<Special> specialList = (ArrayList<Special>)request.getAttribute("specialList");
			
			for(int i=0;i<specialList.size();i++)
			{
				Special special =specialList.get(i);
				String sname = special.getSc_name();
				String sdetails = special.getSc_details();
				int sprice = special.getSc_price();
				%>
				<tr><td >
				<%=sname %> </td>
				<td ><%= sdetails%> </td>
				<td><%= sprice %></td>
				</tr>
				<% } 
				}%>
				<tr>
				<td height = "50"></td></tr>
				
				
				</table>
			
			<p>
				<!-- End of right -->
			</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
		<!-- End of content_area -->
	</div>
	<!-- End Of Container -->
	<div class="cleaner"></div>
	<div id="templatemo_footer">
		Copyright @ 2012 HappyH | Designed by NX YY
	</div>
	
</body>
</html>
