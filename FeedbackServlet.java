package comp.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String message=req.getParameter("message");
		int rating=Integer.parseInt(req.getParameter("rating"));
		
		System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Message: " + message);
        System.out.println("Rating: " + rating);
        
        
        int status=FBDao.saveFeedback(name, email, phone, message, rating);
        
        resp.setContentType("text/html");
        
        if(status>0) {
        	resp.getWriter().println(
        	        "<body style='"
        	        + "margin:0;"
        	        + "min-height:100vh;"
        	        + "display:flex;"
        	        + "justify-content:center;"
        	        + "align-items:center;"
        	        + "font-family:Poppins,sans-serif;"
        	        + "background:linear-gradient(to bottom right, blue, red);'>"

        	        + "<div style='"
        	        + "text-align:center;"
        	        + "border:3px solid black;"
        	        + "border-radius:30px;"
        	        + "padding:40px;"
        	        + "background:linear-gradient(to bottom right, rgb(206,41,41), rgb(53,53,195));'>"

        	        + "<h1 style='color:white;font-size:40px;'>"
        	        + "Feedback Submitted Successfully!"
        	        + "</h1>"

        	        + "<a href='index.html' style='text-decoration:none;'>"
        	        + "<button style='"
        	        + "border:3px solid black;"
        	        + "border-radius:10px;"
        	        + "background-color:rgb(173,173,34);"
        	        + "font-size:20px;"
        	        + "padding:12px 25px;"
        	        + "cursor:pointer;'>"
        	        + "New Feedback"
        	        + "</button>"
        	        + "</a>"

        	        + "</div>"
        	        + "</body>"
        	    );
        	}
        else {
        	resp.getWriter().println("<h2>Something went wrong!</h2>");
        }
	}
}
