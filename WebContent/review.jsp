<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import = "java.util.ArrayList" import="java.util.Iterator" 
     import = "happyH.models.User"
     import = "happyH.tables.RestaurantTable"
     import = "happyH.models.Restaurant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Review</title>
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
				<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%if(session.getAttribute("user")==null) {%>
				<a href="signUp.jsp">Sign Up</a></li>
					 &nbsp;|&nbsp; <a href="login.jsp" class="last">Login</a></li>
		
				<%
				}
				else
				{
					User user = (User)session.getAttribute("user");
					String userName = user.getU_name();	
					out.println("Welcome!   "+userName); %>
				
					<a href="Logout">Logout</a>
					
						<% } 
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
					

					
					<li><a href="viewRestaurant">Restaurant</a></li>
					<li><a href="viewEvent">Event</a></li>
					<li><a href="viewCuisine">Cuisine</a></li>
					<%if(session.getAttribute("user")!=null)
					{%>
					<li><a href="recommend" >Recommendation</a></li>
					<%
					}
					else {
					%>
					<li><a href="login.jsp" >Recommendation</a></li>
					<%} %>
					
					<li><a href="search.jsp" class="last">Search</a></li>
				<!-- <%if(session.getAttribute("user")!=null)
					{%>
					<li><a href="Logout">Logout</a></li>
					<%
					}
					%> -->	
				</ul>
			</div>
			<!-- end of menu -->
		</div>
		<div id="templatemo_content_area">

			<p>
				<!-- End of left -->
			</p>
			<form name = "reviewForm" method = "post" action = "review.do">
			<table align="center" height ="250" >
								<%if(session.getAttribute("user")==null)
					{%>
					<tr>
					<td>
					<h2>
					You should login first.</h2></td></tr>
					<%
					}
					%>
					
			<% 
			if ((request.getParameter("rid")!=null)&& (session.getAttribute("user")!=null)){
			String rid = request.getParameter("rid");
			//RestaurantTable restaurantTable = new RestaurantTable();
			Restaurant rest = RestaurantTable.getRestaurantById(rid); 
			User user = (User)session.getAttribute("user");
			String uid = user.getU_id();	
					%>

				<tr>
					<td  align="center"><span class="blue_title"><%=rest.getR_name()%></span></td>
				</tr>
				<tr>
				<td>
				<input name = "uid" type = "hidden" value = <%=uid%> ></input>
				<input name = "rid" type = "hidden" value = <%=rid%> ></input>
				</td></tr>
				<tr>
					<td>Score     
					<select name = "rating">
							<option value="1">   1   </option>
							<option value="2">   2   </option>
							<option value="3">   3   </option>
							<option value="4">   4   </option>
							<option value="5">   5   </option>
							<option value="6">   6   </option>
							<option value="7">   7   </option>
							<option value="8">   8   </option>
						    <option value="9">   9   </option>
							<option value="10">   10   </option>
					</select></td>
					</tr>
					<tr>
					<td>
					<textarea name= "review" rows = "4" cols ="70" ></textarea></td></tr>
					<tr> 
					<td align= "center" >
					<input type="submit" value="review" /> 
					<input type = "reset" value ="reset"/>
					</td></tr>
					<%} %>
			</table>
			</form>
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
