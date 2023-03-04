package com.laioffer.spork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.spork.entity.Customer;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// name = "helloServlet" - gives servlet a name
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        Customer customer= new Customer();
        customer.setEmail("tiffanyfang67@gmail.com");
        customer.setPassword("12345");
        customer.setFirstName("Tiffany");
        customer.setLastName("Fang");
        customer.setEnabled(true);

        response.getWriter().print(objectMapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
//        Customer customer = objectMapper.readValue(IOUtils.toString(request.getReader()), Customer.class);
        Customer customer = objectMapper.readValue(request.getReader(), Customer.class);

        // Print customer information to the IDE console
        System.out.println("Email is: " + customer.getEmail());
        System.out.println("First name is: " + customer.getFirstName());
        System.out.println("Last name is: " + customer.getLastName());

        // Return status = ok as response body to the client
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}