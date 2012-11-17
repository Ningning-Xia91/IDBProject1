<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import = "java.util.ArrayList" import="java.util.Iterator" 
     import = "happyH.models.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
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
					<li><a href="events.jsp">Events</a></li>
					<li><a href="http://www.mycodes.net" class="last">Contact</a></li>
				</ul>
			</div>
			<!-- end of menu -->
		</div>
		<div id="templatemo_content_area">

			<p>
				<!-- End of left -->
			</p>
			
			<table align="center" height ="250" >
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
