package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, ArrayList> userHobby;
    @Override
    public void init() {
        ArrayList input1= new ArrayList();
        input1.add("skiing");
        ArrayList input2= new ArrayList();
        input2.add("knitting");
        ArrayList input3= new ArrayList();
        input3.add("scuba");
        ArrayList input4= new ArrayList();
        input4.add("dating");

       userHobby = new HashMap<>();
       userHobby.put("Bob", input1);
       userHobby.put("Jim", input1);
       userHobby.put("James", input2);
       userHobby.put("Tom", input2);
       userHobby.put("Fei", input3);
       userHobby.put("Jone", input3);
       userHobby.put("Fred", input4);
       userHobby.put("Pradeep", input4);
       userHobby.put("Philippe", input4);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
        List<String> users = new ArrayList<>();
        users.add(hobby);
       userHobby.forEach((k, v) -> {
           if (v.equals(users)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
