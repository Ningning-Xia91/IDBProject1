<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import = "java.util.ArrayList" import="java.util.Iterator" 
     import = "happyH.models.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<SCRIPT LANGUAGE = "JavaScript">
function check()
{
var account=document.editAccountForm.account.value;
var password=document.editAccountForm.password.value;
var cword=document.editAccountForm.confirmPassword.value;
var username=document.editAccountForm.userName.value;
var email=document.editAccountForm.email.value;
var cuisine=document.editAccountForm.cuisineType.value;
var area=document.editAccountForm.area.value;

  if((account.length<3)||(account.length>16))
  {alert("The length of account should be between 3 and 16");
  return false;
  }
  
  if((username.length<3)||(username.length>16))
  {alert("The length of name should be between 3 and 16");
  return false;
  }


  if((password.length<3)||(password.length>16))
  {alert("The length of your password should be between 3 and 16");
  return false;
  }
  
  if(password!=cword)
  {alert("Your confirm password is not the same with password");
  return false;
  }
  
  

var k=document.editAccountForm.email.value;
var j=0;
var g,f;
if(k==""){
alert("Email should not be empty");
return false;
}
for(var i=0;i<=k.length-1;i++){
if(k.charAt(i)=='@'){
f=i;
j++;
}
}
if(j==0){
alert("The format of email is wrong(not contain @)");
return false;}
for(var i=0;i<=k.length-1;i++){
if(k.charAt(i)=='.'){
g=i;
j++;
}
}
if(j<=1){
alert("The format of email is wrong(not contain .)");
return false;}
if(g<f){
alert("The format of email is wrong(. should follow @)");
return false;
}
	
	alert("Succeed！"); 
	return true;
}
</SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Account</title>
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
					String userName = user.getU_name();	%>
					"Welcome!   "
					<a href = "eidtAccount.jsp"> <%= userName%></a>
				
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
			<form name="editAccountForm" method="post" onsubmit="return check()"  action="editAccount.do">
			<table align="center" height ="300">
			<%if(session.getAttribute("user")==null) {
				User user = (User)session.getAttribute("user");
			
			%>
			<tr>
			<td colspan="2" align="center" ><span class="blue_title">Edit Account</span></td>
			</tr>
				<tr>
					<td>Account</td>
					<td><input name ="account" type="text" size="25" value =<%= user.getU_account() %> /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input name ="password" type = "password" size="25" value=<%= user.getU_password() %> /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input name = "confirmPassword" type= "password" size="25" value =<%= user.getU_password() %>/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input name = "userName" type = "text" size="25" value = <%= user.getU_name() %> /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input name = "email" type = "text" size="25" value = <%= user.getU_email() %> /></td>
				</tr>
				<tr>
					<td>Preference Cuisine Type</td>
					<td> 
					<select name = "cuisineType">
							<option value="Chinese"> Chinese </option>
							<option value="Indian">  Indian  </option>
							<option value="Korean">  Korean   </option>
							<option value="Japanese">   Japanese   </option>
							<option value="American">   American  </option>
							<option value="Italian">   Italian   </option>
							<option value="French">   French   </option>
							<option value="Mexican">   Mexican  </option>
						    <option value="Russian">   Russian   </option>
							<option value="Brazillian">   Brazillian   </option>
					</select></td>
					
				</tr>
				<tr>
				<td>
				Preference Area</td>
									<td> 
					<select name = "area">
							<option value="Manhattan"> Manhattan </option>
							<option value="Bronx">  Bronx  </option>
							<option value="Queens">  Queens   </option>
							<option value="Brooklyn">   Brooklyn   </option>
							<option value="Stanten Island">   Stanten Island  </option>
					</select></td>
					</tr>
				<tr>
					<td align = "center" colspan = "2"><input type="submit" value="submit" />
					<input type="reset" value="reset" /></td>
				</tr>
				<tr>
				<td height = "30">
				</td></tr>
				<tr>
				<%} %>
				<td colspan = "2" align="center"> <% if (request.getAttribute("SameAccount")!=null){
					String sameAccount = String.valueOf(request.getAttribute("SameAccount"));
					out.println(sameAccount);}%></td></tr>
				
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
