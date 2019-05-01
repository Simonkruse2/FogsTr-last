<%@page import="Logic.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% Carport carport = (Carport) (request.getAttribute("carport"));%>
    </head>
    
    <body>
        <h1>Length is <%=carport.getLengthOuter()%></h1>
        <svg height="25000" width="25000" viewBox="-1000 0 200000 200000">
        <defs>
    <marker id="beginArrow"
            markerWidth="<%=carport.getLengthOuter() / 10%>" markerHeight="9"
            refX="0" refY="4"
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
    </marker>
    <marker id="endArrow"
            markerWidth="<%=carport.getLengthOuter() / 10%>" markerHeight="9"
            refX="8" refY="4"
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
    </marker>
    </defs>
    <line x1="0mm"  y1="1100mm" x2="<%=carport.getLengthOuter()%>mm"   y2="1100mm"
          style="stroke:#000000;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>

    <line x1="<%=carport.getLengthOuter() + 100%>mm"  y1="0mm" x2="<%=carport.getLengthOuter() + 100 %>mm"  y2="1000mm"
          style="stroke:#000000;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"
          stroke-width="<%=carport.getLengthOuter() / 250%>"
          />

<line x1="-100mm"  y1="0mm" x2="-100mm"  y2="1000mm"
          style="stroke:#000000;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"
          stroke-width="<%=carport.getLengthOuter() / 250%>"
          />

    <rect y="0mm" width="<%=carport.getLengthOuter() %>mm" height="100mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>

    <rect y="900mm" width="<%=carport.getLengthOuter()%>mm" height="100mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>

    <rect y="0mm" width="100mm" height="1000mm"
          style="stroke: #000000; fill:#ffffff;"/>
    <% int numRaft = 0;
        if (carport.getLengthOuter() % 110 == 0) {
            numRaft = (((carport.getLengthOuter() - 110) / 110) + 1);
        } else {
            numRaft = (int) Math.ceil(((carport.getLengthOuter() - 110) / 110) + 1);
        } %>
    <% for (int i = 0; i < numRaft; i++) { %>
    <rect x="<% out.print(110 * i);%>mm" y="0mm" width="100mm" height="1000mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250 %>"/>
    <%    }
    %>
 
</body>
</html>