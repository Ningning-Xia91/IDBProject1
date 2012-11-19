<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"     
    import = "java.util.ArrayList" import="java.util.Iterator" 
    import = "happyH.models.Restaurant"  import = "happyH.models.User"
    import = "happyH.models.Location" 
    import = "happyH.models.Cuisine"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>View Restaurants</title>
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
			
			<table align="center" >
			<% if (request.getAttribute("rest")!=null) { 
			Restaurant rest = (Restaurant)request.getAttribute("rest"); %>
			<tr>
			<td colspan ="2" align="center">
			 <span class="blue_title"> <%= rest.getR_name() %> </span>
			</td>
			</tr>
			<tr>
			<td><h3>Average Price</h3>   </td>
			<td> $<%= rest.getAve_price() %></td>	
			</tr>
						<% if (request.getAttribute("average")!=null)  {%>
			<tr>
			<td>
			<h3>Average Grade</h3>
			</td>
			<td>
			<%=String.valueOf(request.getAttribute("average")) %>
			</td>
			</tr>
<%} %>

			<tr>
			<td><h3>Details</h3> </td>
			<td> <%= rest.getR_details() %></td>
			</tr>

			<% if (request.getAttribute("locList")!=null) {
				ArrayList<Location> locList =(ArrayList<Location>)request.getAttribute("locList");
				Location loc;
				for(int i=0;i<locList.size();i++)
				{
					loc = locList.get(i);
					%>
					<tr>
					<td>
					<h3>Location</h3>
					</td>
					<td>
					<%= loc.toString() %>
					</td>
					</tr>
					<% 
				}
			}%>
			
			<% if (request.getAttribute("cuisine")!=null) {
				Cuisine cuisine =(Cuisine)request.getAttribute("cuisine");%>
					<tr>
					<td><h3>
					Cuisine Type</h3>
					</td>
				
					<td>
					<%= cuisine.getCt_name() %>
					
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="viewCuisine" >View All Cuisine Types</a>
			
				</td>
					</tr>
					<tr>
					<td>
					<h3>Speical Cuisines</h3></td>
					<td>
					<a href="viewSpecial?rid=<%=rest.getR_id() %>">Check Out Specials</a></td></tr>
					<% 
				
			}%>
			
			
			
			<form name = "viewReviewsForm" method = "post" action ="viewEvaluations.do">
			<tr>
			<td><input type="hidden" name = "rid" value = <%= rest.getR_id() %> ></input></td>
			</tr>
			<tr>
			<td colspan="2" align= "center"> <input type = "submit" value ="View Reviews"/>
			</td>
			</tr>
			</form>	

			<form name ="reviewForm" method = "post" action = review.jsp>
			<tr>
			<td colspan="2" align ="center">
			<input type="hidden" name = "rid" value = <%=rest.getR_id()%> ></input>
		    <input type = "submit" value ="Review This Restaurant"/>
		    </td>
			</tr>
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
