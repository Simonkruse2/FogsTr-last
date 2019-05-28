<%@page import="Data.User"%>
<%@page import="Data.Carport"%>
<%@page import="Logic.CarportCalc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple drawing</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="style_fog.css" rel="stylesheet" type="text/css"/>
        <% User u = (User) session.getAttribute("user"); %>
        <% if (null == session.getAttribute("user")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }%>
        <% Carport carport = (Carport) (request.getAttribute("carport"));%>
        <% CarportCalc CarportCalc = (CarportCalc) (request.getAttribute("CarportCalc"));%>
        <% int poleHeight = 230;%>
        <% int width_outer = carport.getWidthOuter();%>
        <% int length_outer = carport.getLengthOuter();%>
    </head>

    <body>
        <nav class="">
            <ul>
                <li>
                    <form class="float-right" action="FrontController" method="post">
                        <input type="hidden" name="command" value="logout">
                        <input type="submit" value="Log out"/>  
                    </form>
                </li>
                <li>
                    <b><% out.print(u.getUsername().toUpperCase());%></b>
                </li>
                <li>
                    <form class="float-left" action="" method="">
                        <button type="button" name="back" onclick="history.back()">Back</button>
                    </form>
                </li>
                <li>
                    <a href="ViewOrders.jsp" >click here to view previous orders</a>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">

                <h1 class="col-md-12">Carport drawing</h1>
                <svg class="kassen col-md-8 col-sm-8" viewBox="-1000 -1800 <%=length_outer * 10%> <%=width_outer * 10%>">

                <defs>
                <marker id="beginArrow"
                        markerWidth="<%=length_outer / 10%>" markerHeight="9"
                        refX="0" refY="4"
                        orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
                </marker>
                <marker id="endArrow"
                        markerWidth="<%=length_outer / 10%>" markerHeight="9"
                        refX="8" refY="4"
                        orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
                </defs>
                -- left arrow
                <line x1="-200mm"  y1="0mm" x2="-200mm"  y2="<%=width_outer%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />
                --Left arrow inner width
                <line x1="-100mm"  y1="<%=width_outer * 0.05%>mm" x2="-100mm"  y2="<%=width_outer * 0.95%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />

                -- bottom arrow
                <line x1="0mm"  y1="<%=width_outer + 100%>mm" x2="<%=length_outer%>mm"   y2="<%=width_outer + 100%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=length_outer / 150%>"/>

                --Encircling rectangle
                <rect y="0mm" width="<%=length_outer%>mm" height="<%=width_outer%>mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 50%>"/>

                --Beams start
                <rect y="<%=width_outer * 0.05%>mm" width="<%=length_outer%>mm" height="10mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"/>

                <rect y="<%=width_outer * 0.95%>mm" width="<%=length_outer%>mm" height="10mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"/>

                --First Raft
                <rect y="0mm" width="5mm" height="<%=width_outer%>mm"
                      style="stroke: #000000; fill:#ffffff;"/>

                <%
                    double numPoles = CarportCalc.polesDrawing(length_outer);

                    double distPoles = CarportCalc.poleDist(length_outer);
                %> 

                <%
                    for (int i = 1; i < numPoles; i++) {%>
                --Poles Birds eye view
                <rect x="<%= 100 + distPoles * i%>mm" y="<%=width_outer * 0.05%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"/>
                <rect x="<%= 100 + distPoles * i%>mm" y="<%=width_outer * 0.95%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"/>
                --Poles side view
                <rect x="<%= 100 + distPoles * i%>mm" y="-600mm" width="15mm" height="<%=poleHeight%>mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"/>
                --Poles bottom arrows from side view
                <line x1="<%=100 + distPoles * i%>mm"  y1="-225mm" x2="<%=100 + distPoles * (i + 1)%>mm"   y2="-225mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=length_outer / 150%>"/>

                <%    }
                %>

                --POLES

                <rect x="100mm" y="<%=width_outer * 0.05%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"
                      />

                <rect x="100mm" y="<%=width_outer * 0.95%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"
                      />

                <rect x="<%=length_outer - 30%>mm" y="<%=width_outer * 0.95%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"
                      />

                <rect x="<%=length_outer - 30%>mm" y="<%=width_outer * 0.05%>mm" width="13mm" height="13mm"
                      stroke-width="<%=width_outer / 150%>"
                      />    


                --Rafts
                <% double numRaft = CarportCalc.rafts(length_outer, width_outer).getAmount();
                    double distance = CarportCalc.raftDistance(length_outer, width_outer);
                %>


                <% for (int i = 0; i <= numRaft; i++) {%>
                <rect x="<%=distance * i%>mm" y="0mm" width="10mm" height="<%=width_outer%>mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 50%>"
                      fill-opacity="0"/>
                <line x1="<%= distance * (i)%>mm"  y1="-50mm" x2="<%= distance * (i)%>mm"  y2="-150mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                <%    }%>

                --Rafts distance measurement
                <% for (int i = 0; i <= numRaft - 1; i++) {%>
                <line x1="<%= distance * (i)%>mm"  y1="-100mm" x2="<%= distance * (i + 1)%>mm"  y2="-100mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />
                <text x="<%= (distance * (i)) + 5%>mm" y="-125mm" font-size="6em" fill="black"><%=distance%></text>
                <%    }%>

                --Text for bottom arrow
                <text x="<%=(length_outer / 2) - 10%>mm" y="<%=width_outer + 80%>mm" font-size="7em" fill="black"><%=length_outer%></text>
                --Text for left arrow outer width 
                <text transform = "translate(-800, <%=width_outer + width_outer%>) rotate(-90 60 60)" font-size="7em" fill="black"><%=width_outer%></text>
                --Text for left arrow inner width
                <text transform = "translate(-500, <%=width_outer + width_outer%>) rotate(-90 60 60)" font-size="7em" fill="black"><%=width_outer - 70%></text>

                --Line start and end for bottom arrow
                <line x1="0mm"  y1="<%=width_outer + 50%>mm" x2="0mm"  y2="<%=width_outer + 150%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="<%=length_outer%>mm"  y1="<%=width_outer + 50%>mm" x2="<%=length_outer%>mm"  y2="<%=width_outer + 150%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Line start and end for left arrow outer width
                <line x1="-150mm"  y1="0mm" x2="-250mm"  y2="0mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="-150mm"  y1="<%=width_outer%>mm" x2="-250mm"  y2="<%=width_outer%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Line start and end for left arrow inner width
                <line x1="-50mm"  y1="<%=width_outer * 0.05%>mm" x2="-150mm"  y2="<%=width_outer * 0.05%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="-50mm"  y1="<%=width_outer * 0.95%>mm" x2="-150mm"  y2="<%=width_outer * 0.95%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Carport view from side drawing start
                --Poles side view
                <rect x="100mm" y="-600mm" width="15mm" height="<%=poleHeight%>mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"/>

                <rect x="<%=length_outer - 30%>mm" y="-600mm" width="15mm" height="<%=poleHeight%>mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"/>
                --Roof side view
                <rect x="0mm" y="-616mm" width="<%=length_outer%>mm" height="15mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"
                      transform = "rotate(1 <%=length_outer / 2%> 0)"/>
                <rect x="0mm" y="-635mm" width="<%=length_outer%>mm" height="15mm"
                      style="stroke: #000000; fill:#ffffff;"
                      stroke-width="<%=length_outer / 150%>"
                      transform = "rotate(1 <%=length_outer / 2%> 0)"/>

                --Bottom arrows for side view

                --Text for bottom measurements
                <text x="35mm" y="-250mm" font-size="7em" fill="black">100</text>


                --Arrow first
                <line x1="0mm"  y1="-225mm" x2="100mm"   y2="-225mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=length_outer / 150%>"/>
                <line x1="0mm"  y1="-175mm" x2="0mm"  y2="-275mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                --Line measurement for arrows bottom first
                <line x1="100mm"  y1="-175mm" x2="100mm"  y2="-275mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Arrow between poles
                <line x1="100mm"  y1="-225mm" x2="<%=100 + distPoles%>mm"   y2="-225mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=length_outer / 150%>"/>
                <%
                    for (int i = 0; i < numPoles; i++) {%>  
                --Line measurement for arrows bottom side view

                <line x1="<%=100 + distPoles * (i + 1)%>mm"  y1="-175mm" x2="<%=100 + distPoles * (i + 1)%>mm"  y2="-275mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Text for pole arrows
                <text x="<%=250 + distPoles * i%>mm" y="-250mm" font-size="7em" fill="black"><%=distPoles%></text>

                <%    }
                %>

                -- left arrow side view
                <line x1="-200mm"  y1="-630mm" x2="-200mm"  y2="-<%=(poleHeight + 140)%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />
                --Left arrow inner width side view
                <line x1="-100mm"  y1="-615mm" x2="-100mm"  y2="-<%=(poleHeight + 140)%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />
                --Text for left arrow outer width side view
                <text transform = "translate(-800, -1800) rotate(-90 60 60)" font-size="7em" fill="black">230</text>
                --Text for left arrow inner width side view
                <text transform = "translate(-500, -1800) rotate(-90 60 60)" font-size="7em" fill="black">210</text>

                --Line start and end for left arrow outer width side view
                <line x1="-150mm"  y1="-630mm" x2="-250mm"  y2="-630mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="-150mm"  y1="-<%=(poleHeight + 140)%>mm" x2="-250mm"  y2="-<%=(poleHeight + 140)%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />

                --Line start and end for left arrow inner width side view
                <line x1="-50mm"  y1="-615mm" x2="-150mm"  y2="-615mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="-50mm"  y1="-<%=(poleHeight + 140)%>mm" x2="-150mm"  y2="-<%=(poleHeight + 140)%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                --Arrow Right side
                <line x1="<%=length_outer + 100%>mm"  y1="-615mm" x2="<%=length_outer + 100%>mm"  y2="-<%=(poleHeight + 140)%>mm"
                      style="stroke:#000000;
                      marker-start: url(#beginArrow);
                      marker-end: url(#endArrow);"
                      stroke-width="<%=width_outer / 150%>"
                      />
                <line x1="<%=length_outer + 50%>mm"  y1="-615mm" x2="<%=length_outer + 150%>mm"  y2="-615mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <line x1="<%=length_outer + 50%>mm"  y1="-<%=(poleHeight + 140)%>mm" x2="<%=length_outer + 150%>mm"  y2="-<%=(poleHeight + 140)%>mm"
                      stroke-width="<%=width_outer / 150%>"
                      style="stroke:#000000;" />
                <text transform = "translate(<%=(length_outer * 4) + 20%>, -1800) rotate(-90 60 60)" font-size="7em" fill="black"><%=220%></text>

                --Carport  view from side drawing end

                --Crossing lines with stroke dash-array
                <line x1="<%=distance%>mm" y1="<%=width_outer * 0.05%>mm" x2="<%=length_outer * 0.95%>mm" y2="<%=width_outer * 0.95%>mm"
                      style="stroke: #000000; fill:none;
                      stroke-dasharray: 100 50"
                      stroke-width="<%=length_outer / 150%>"/>
                <line x1="<%=distance%>mm" y1="<%=width_outer * 0.06%>mm" x2="<%=length_outer * 0.95%>mm" y2="<%=width_outer * 0.96%>mm"
                      style="stroke: #000000; fill:none;
                      stroke-dasharray: 100 50"
                      stroke-width="<%=length_outer / 150%>"/>

                <line x1="<%=distance%>mm" y1="<%=width_outer * 0.95%>mm" x2="<%=length_outer * 0.95%>mm" y2="<%=width_outer * 0.05%>mm"
                      style="stroke: #000000; fill:none;
                      stroke-dasharray: 100 50"
                      stroke-width="<%=length_outer / 150%>"/>
                <line x1="<%=distance%>mm" y1="<%=width_outer * 0.96%>mm" x2="<%=length_outer * 0.95%>mm" y2="<%=width_outer * 0.06%>mm"
                      style="stroke: #000000; fill:none;
                      stroke-dasharray: 100 50"
                      stroke-width="<%=length_outer / 150%>"/>

                </svg>
            </div>
        </div>
    </body>
</html>