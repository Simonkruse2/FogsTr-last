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
-- left arrow
   <line x1="-100mm"  y1="0mm" x2="-100mm"  y2="<%=carport.getWidthOuter()%>mm"
          style="stroke:#000000;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"
          stroke-width="<%=carport.getWidthOuter() / 250%>"
          />
   
    -- bottom arrow
    <line x1="0mm"  y1="<%=carport.getWidthOuter() + 100%>mm" x2="<%=carport.getLengthOuter()%>mm"   y2="<%=carport.getWidthOuter() + 100%>mm"
          style="stroke:#000000;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>
 
        <rect y="0mm" width="<%=carport.getLengthOuter() + 10%>mm" height="<%=carport.getWidthOuter()%>mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter()/50%>"/>

    <rect y="<%=carport.getWidthOuter()*0.05%>mm" width="<%=carport.getLengthOuter()%>mm" height="10mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>

    <rect y="<%=carport.getWidthOuter()*0.95%>mm" width="<%=carport.getLengthOuter()%>mm" height="10mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>

    <rect y="0mm" width="10mm" height="<%=carport.getWidthOuter()%>mm"
          style="stroke: #000000; fill:#ffffff;"/>
    
    
    <rect x="100mm" y="<%=carport.getWidthOuter()*0.05%>mm" width="13mm" height="13mm"
          stroke-width="<%=carport.getWidthOuter() / 150%>"
          />
    
    <rect x="100mm" y="<%=carport.getWidthOuter()*0.95%>mm" width="13mm" height="13mm"
          stroke-width="<%=carport.getWidthOuter() / 150%>"
          />
    
    <rect x="<%=carport.getLengthOuter()-30%>mm" y="<%=carport.getWidthOuter()*0.95%>mm" width="13mm" height="13mm"
          stroke-width="<%=carport.getWidthOuter() / 150%>"
          />
    
    <rect x="<%=carport.getLengthOuter()-30%>mm" y="<%=carport.getWidthOuter()*0.05%>mm" width="13mm" height="13mm"
          stroke-width="<%=carport.getWidthOuter() / 150%>"
          />    
    
    <% int numRaft = (int) Math.ceil((carport.getLengthOuter()/60));
       double distance = carport.getLengthOuter()/(numRaft);
    %>
    <% for (int i = 0; i <= numRaft; i++) { %>
    <rect x="<%=distance * i %>mm" y="0mm" width="10mm" height="<%=carport.getWidthOuter()%>mm"
          style="stroke: #000000; fill:#ffffff;"
          stroke-width="<%=carport.getLengthOuter() / 250%>"/>
    <%    }
    %>

</body>
</html>