<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import = "java.util.ArrayList" import="java.util.Iterator" 
     import = "happyH.models.User"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
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
					<input type="text" value="SEARCH" name="q" class="field"
						title="email" onfocus="clearText(this)" onblur="clearText(this)" />
					<input type="submit" name="search" value="" alt="Search"
						class="button" title="Subscribe" />
				</form>
			</div>
			<div id="templatemo_menu">
				<ul>
					<li><a href="firstPage.jsp" class="current">Home</a></li>
					<li><a href="signUp.jsp">Sign Up</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="http://www.mycodes.net">Testimonial</a></li>
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
			<form name="loginForm" method="post" action="login.do">
			<table align="center" height="300">
			<tr>
			<td  colspan="2" align="center" ><span class="blue_title">Login</span></td>
			</tr>
				<tr>
					<td >Account</td>
					<td><input name ="account" type="text" size="25" /></td>
				</tr>
				<tr>
					<td >Password</td>
					<td><input name ="password" type = "password" size="25" /></td>
				</tr>
				<tr>
					<td align = "center" colspan="2"><input type="submit" value="login" />
					<input type="reset" value="reset" /></td>
				</tr>
				<tr>
				<td height="150">
				</td></tr>
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
