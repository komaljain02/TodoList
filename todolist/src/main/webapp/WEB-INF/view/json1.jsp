<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"  %>
[
	<c:forEach items="${tasklist}" var="j" varStatus="c" >
	<c:set value="${j.date.time}" var="d"></c:set>
	<c:set value="${f:split(d,' ')}" var="s"></c:set>
		{
			"time" : "${s[3]}" ,
			"years" :${j.years} ,
			"month" :${j.month} ,
			"day" :${j.day} ,
			"title" : "${j.title}" ,
			"description" : "${j.taskdata}" ,
			"priority" : ${j.priority} ,
			"tsid" : ${j.tid} ,
			"rid" : ${j.regvo.rid}
			
		}
		<c:if test="${ c.count ne  f:length(tasklist) }" >
			,
		</c:if>
	</c:forEach>
]