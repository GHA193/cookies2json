package com.wk.util;

import com.alibaba.fastjson.JSON;
import com.wk.util.po.EditThisCookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getjson")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String domain=req.getParameter("domain");
        String cookies=req.getParameter("cookies");

        System.out.println(domain);
        System.out.println(cookies);

        String json = "";
        if (domain==null||cookies==null||domain.equals("")||cookies.equals("")){
            json = "信息不完整";
        }else {
            json = getJsonFromCookies(domain,cookies);
        }

        System.out.println(json);

        req.setAttribute("json",json);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public static String getJsonFromCookies(String domain, String cookies){
        List<EditThisCookies> editThisCookiesList = new ArrayList<EditThisCookies>();
        cookies = cookies.replaceAll("Cookie: ", "").replace(" ","");
        String cookiePair[] = cookies.split(";");
        long id = 1;
        for (String string:
                cookiePair){
            String key = string.substring(0,string.indexOf('='));
            String value = string.substring(string.indexOf('=')+1,string.length());
            EditThisCookies editThisCookie = new EditThisCookies();
            editThisCookie.setName(key);
            editThisCookie.setValue(value);
            editThisCookie.setId(id);
            id ++;
            editThisCookie.setDomain(domain);
            editThisCookiesList.add(editThisCookie);
        }

        return JSON.toJSONString(editThisCookiesList);

    }
}
