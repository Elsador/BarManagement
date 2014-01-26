package cool_bar.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cool_bar.beans.ProductsBean;
import cool_bar.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ProductsBean productsBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allProducts = productsBean.getAllProducts();

        PrintWriter out = response.getWriter();

        out.println("<html><body><table>");
//        out.println("  Hello "+ request.getRemoteUser());
        for (cool_bar.model.Product Product : allProducts) {
            out.println("<tr>");
            out.println("<td>" + Product.getName() + "</td>");
            out.println("<td>" + Product.getType() + "</td>");
            out.println("<td>" + Product.getDescription() + "</td>");
            out.println("<td>" + Product.getPrice() + "</td>");

//            if(request.isUserInRole("Daskal")) {
//                out.println("<td><a href='deleteProduct?id=" + Product.getId()
//                        + "'>remove</a></td>");
//            }
            out.println("</tr>");
        }
        out.println("</table></body></html>");
        System.out.println("doGet Finish");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product newProduct = new Product();
        newProduct.setName(request.getParameter("name"));
        newProduct.setType(request.getParameter("type"));
        newProduct.setDescription(request.getParameter("description"));
        newProduct.setPrice(Double.parseDouble(request.getParameter("price")));

        response.sendRedirect("Product");
	}

}
