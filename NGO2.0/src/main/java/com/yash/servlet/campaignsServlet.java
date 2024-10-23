package com.yash.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.yash.DAO.CampaignDAO;
import com.yash.DAO.UserDAO;
import com.yash.DB.DBConnect;
import com.yash.entities.Campaigns;
import com.yash.entities.User;

@WebServlet("/campaignsServlet")
public class campaignsServlet extends HttpServlet {

    private CampaignDAO campaignDAO;

    public void init() {
        campaignDAO = new CampaignDAO(DBConnect.getConnection());  // Initialize your DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertCampaign(request, response);
                    break;
                case "/delete":
                    deleteCampaign(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCampaign(request, response);
                    break;
                default:
                    listCampaign(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        String cname=request.getParameter("cname");
		String des=request.getParameter("des");
		double gamt=Double.parseDouble(request.getParameter("gamt"));

		CampaignDAO dao=new CampaignDAO(DBConnect.getConnection());
		Campaigns camps=dao.insertCampaign(cname,des,gamt);
    }

    private void listCampaign(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Campaigns> listCamps = campaignDAO.selectAllCampaigns();
        request.setAttribute("listCampaigns", listCamps);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ownerDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("campaignform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Campaigns existingCampaign = campaignDAO.selectCampaigns(id);  // Fetch existing campaign
        RequestDispatcher dispatcher = request.getRequestDispatcher("campaignform.jsp");
        request.setAttribute("campaign", existingCampaign);
        dispatcher.forward(request, response);
    }

    private void insertCampaign(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cname = request.getParameter("cname");
        String des = request.getParameter("des");
        double gamt = Double.parseDouble(request.getParameter("gamt"));  // Convert string to double
        Campaigns newCamp = new Campaigns(cname, des, gamt);
        CampaignDAO.insertCampaign(newCamp);
        response.sendRedirect("list");
    }

    private void updateCampaign(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cname = request.getParameter("cname");
        String des = request.getParameter("des");
        double gamt = Double.parseDouble(request.getParameter("gamt"));

        Campaigns campaign = new Campaigns(id, cname, des, gamt);  // Create updated campaign object
        campaignDAO.updateCampaign(campaign);
        response.sendRedirect("list");
    }

    private void deleteCampaign(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        campaignDAO.deleteCampaign(id);
        response.sendRedirect("list");
    }
}

