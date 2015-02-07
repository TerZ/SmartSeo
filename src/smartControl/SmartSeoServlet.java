package smartControl;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartControl.GPIOControl;

/**
 * Servlet implementation class SmartSeoServlet
 */
@WebServlet("/Input")
public class SmartSeoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GPIOControl smartSeoControl;

	/**
	 * Default constructor.
	 */
	public SmartSeoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		smartSeoControl = new GPIOControl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("START");
		String action = request.getParameter("action");
		switch (action) {
		case "oneCup":
			System.out.println("One");
			try {
				smartSeoControl.pushPowerButton();
				Thread.sleep(80000);
				smartSeoControl.pushOneCupButton();
				Thread.sleep(25000);
				smartSeoControl.pushPowerButton();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case "twoCup":
			System.out.println("Two");
			try {
				smartSeoControl.pushPowerButton();
				Thread.sleep(80000);
				smartSeoControl.pushTwoCupButton();
				Thread.sleep(25000);
				smartSeoControl.pushPowerButton();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case "on":
			System.out.println("On");
			smartSeoControl.pushPowerButton();
			break;
			
		case "off":
			System.out.println("Off");
			smartSeoControl.pushPowerButton();
			break;
			
		case "oneCupManual":
			System.out.println("OneCupManual");
			smartSeoControl.pushOneCupButton();
			
		case "twoCupManual":
			System.out.println("TwoCupManual");
			smartSeoControl.pushTwoCupButton();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
