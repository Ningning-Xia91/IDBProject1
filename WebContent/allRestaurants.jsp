<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.ArrayList" import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rated movies page</title>
<link rel="stylesheet" href="style/style.css" type="text/css" />
<script src="script/ui.js" type="text/javascript"></script>
<script src="script/prototype.js" type="text/javascript"></script>
</head>
<body>

<table border="0" cellspacing="0" cellpadding="0" align="center" width="97%" class="header">
    <tr>
    <td>
        <img class="noborder" src="images/movielens-helping.gif" alt="m o v i e l e n s - helping you find the right movies" width="235" height="46"/>
    </td>
    <td align="center" width="90%">
      <table width="100%" border="0" cellspacing="0" cellpadding="9">
        <tr align="center">
		  <td>
            <span class="bigText">Welcome zjut@163.com</span>

		          <span class="smallText">
		               &nbsp;(<a href="/login?action=logout">Log Out</a>)
		          </span>
		          <br/>
		          <span class="text">
		            You've rated
		            <a href="/ratingsStats"><b><span id="numRats">15</span></b></a>
		            movies.
		          </span>

		          <br/>
		         
		      </td>
	    </tr>
      </table>
    </td>
    <td><img src="images/star-legend.gif" width="133" height="68" alt=""/></td>
  </tr>
  </table>
<hr width="100%" size="1" >
    <table width="97%" border="0" cellspacing="0" cellpadding="0" align="center" class="navBar">
      <tr align="center">
        <td>
          <table class="text" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td><a href="firstPage.jsp">Home</a></td>
                <td>|</td>

              <td><a href="allRestaurants">Restaurants</a></td>
                <td>|</td>
              <td><a href="RatedMovie">Events</a></td>
                <td>|</td>
              <td><a href="RecommendedMovie">Reviews</a></td>

                <td>|</td>
              <td><a href="RateNewMovie">Recommendation</a></td>
               
                
               <td>|</td>
              <td><a href="AddNewMovie">Contact US</a></td>
                </tr>
                
          </table>
    <hr width="100%" size="1" >
    
    <br>
        <br>
            <br>
            
            <h4>The movies you have rated:</h4>
<%if(request.getAttribute("str")!=null)
{
	out.println(request.getAttribute("str"));}%>

  <hr width="100%" size="1" >

<%-- <%if(request.getAttribute("s")!=null)
{
	out.println(request.getAttribute("s"));}%> --%>
	
	<table>
	
	

  
  <%
  ArrayList<String> StrLst = (ArrayList<String>)request.getAttribute("StrLst");
  
  //out.println(StrLst.size());
  for(int i=0;i<StrLst.size();i++)
  {
	 
  String stringlist =StrLst.get(i);
	 
  %>
<tr>
<td  height="43"><% out.println(stringlist); %> <br/> <div class="dashed_x"/></td>
</tr>

  

<% } %>

	</table>

 <hr width="100%" size="1" >
</body>
</html>