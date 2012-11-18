<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"     
    import = "java.util.ArrayList" import="java.util.Iterator" 
    import = "happyH.models.Restaurant"  import = "happyH.models.User"
    import = "happyH.models.Event" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View Restaurants</title>
<meta name="keywords"
	content="free design template, download web templates, Fresh Creativet Website, XHTML, CSS" />
<meta name="description"
	content="Fresh Creative - www.mycodes.net, Free XHTML CSS Design Layout" />
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
				<a href="http://www.mycodes.net"><img
					src="images/templatemo_icon_3.jpg" alt="RSS" /></a> <a
					href="http://www.mycodes.net"><img
					src="images/templatemo_icon_2.jpg" alt="Twitter" /></a> <a
					href="http://www.mycodes.net"><img
					src="images/templatemo_icon_1.jpg" alt="Delicious" /></a>
				<form action="http://www.mycodes.net" method="post">
				<%if(session.getAttribute("user")!=null)
				{
					User user = (User)session.getAttribute("user");
					String userName = user.getU_name();	
					out.println(userName);} 
					%>

					<input type="text" value="SEARCH" name="q" class="field"
						title="email" onfocus="clearText(this)" onblur="clearText(this)" />
					<!--  <input type="submit" name="search" value="" alt="Search"
						class="button" title="Subscribe" />-->
				</form>
			</div>
			<div id="templatemo_menu">
				<ul>
					<li><a href="firstPage.jsp" class="current">Home</a></li>
					<li><a href="signUp.jsp">SignUp</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="viewRestaurant">Restaurants</a></li>
					<li><a href="http://www.mycodes.net">News &amp; Events</a></li>
					<li><a href="http://www.mycodes.net" class="last">Contact</a></li>
				</ul>
			</div>
			<!-- end of menu -->
		</div>
		<div id="templatemo_content_area">

			<p>
				<!-- End of left -->
			</p>
			
			<table align="center" >
			<% if ((request.getAttribute("event")!=null)&&(request.getAttribute("rest")!=null)) { 
			Restaurant rest = (Restaurant)request.getAttribute("rest");
			Event event = (Event)request.getAttribute("event");%>
			<tr>
			<td colspan ="2" align="center">
			 <span class="blue_title"> <%= event.getEvt_title() %> </span>
			</td>
			</tr>
			<tr>
			<td>Start Time </td>
			<td> <%= event.getStart_time() %></td>	
			</tr>
			<tr>
			<td>End Time </td>
			<td> <%= event.getEnd_time() %></td>
			</tr>
			<tr>
			<td>Details</td>
			<td>
			<%= event.getE_details() %>
			</td></tr>
			<tr>
			<td>
			Host Restaurant</td>
			<td>
			<%= rest.getR_name() %></td></tr>
			
			<form name = "viewRestForm" method = "post" action ="restaurantHome.do">
			<tr>
			<td colspan="2" align="center">
			<input type="text" name = "id" value = <%= rest.getR_id() %> ></input>
			<input type="submit" value = "See The Restaurant" ></input></td></tr>
			</form>	
				
				<% } %>
				
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