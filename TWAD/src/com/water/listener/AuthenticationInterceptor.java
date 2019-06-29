package com.water.listener;

/**
 * Created by Mahalingam (Freelancer) On 27-Apr-2017
 * 
 * @author Mahalingam
 * 
 *        This class is a Interceptor to intercept the request and response of the application
 *        
 *        In prehandle interface method Session checking done.
 *        
 *        User is allowed only the user session is in  live or else user will be redirected to error/session expired page 
 *
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// long startTime = System.currentTimeMillis();
		// System.out.println("Request URL::" +
		// request.getRequestURL().toString()
		// + ":: Start Time=" + System.currentTimeMillis());
		// request.setAttribute("startTime", startTime);
		// if returned false, we need to make sure 'response' is sent

		String uri = request.getRequestURI();

		if (uri != null && !"".equals(uri) && uri.indexOf("/") != -1)
			uri = uri.substring(uri.lastIndexOf("/") + 1, uri.length());

		if (!uri.equals("signOut.do") && !"".equals(uri)
				&& !uri.equals("error.do") && !uri.equals("validate.do")
				&& !uri.equals("index.do") && !uri.equals("downloadFile.do") && !uri.equals("formRegister.do") 
				&& !uri.equals("companyRegister.do") && !uri.equals("adminLogin.do") && !uri.equals("appAcknoledgement.do") && !uri.equals("uploadDocument.do")
				&& !uri.equals("downloadImage.do") && !uri.equals("checkApplicationStatus.do") && !uri.equals("initialPayment.do")&& !uri.equals("initialPaymentOnline.do") 
				&& !uri.equals("savePaymentsDetails.do") && !uri.equals("uploadMultipleFile.do") &&  !uri.equals("getPaymentAmount.do") &&  !uri.equals("InitialPayment.do") &&   !uri.equals("getReqMLDCost.do")
				&&  !uri.equals("withdrawApp.do") &&  !uri.equals("saveOnlinePaymentsDetails.do") &&  !uri.equals("onlinePaymentResponse.do")  &&  !uri.equals("onlinePaymentResponseFailure.do") 
				&&  !uri.equals("downloadTypePdf.do") &&  !uri.equals("onlineFinalResponseFailure.do") &&  !uri.equals("callEasyBusiness.do") && !uri.equals("ApplicationDetails.do") && !uri.equals("forgotPassword.do") 
				&& !uri.equals("downloadPDF.do") && !uri.equals("saveDDPaymentDtls.do") && !uri.equals("getDDAmount.do") && !uri.equals("eeSaveHeaderList.do") && !uri.equals("getHeaderList.do")  && !uri.equals("onlinePayment.do")   && !uri.equals("getOnlinePaymentAmount.do")     ) {
			
			if (request.getSession().getAttribute("LoginID") == null) {
				response.sendRedirect("index.do");
				return false;
			}
			return true;
		} else
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// System.out.println("Request URL::" +
		// request.getRequestURL().toString()
		// + " Sent to Handler :: Current Time="
		// + System.currentTimeMillis());
		// we can add attributes in the modelAndView and use that in the view
		// page
		// System.out.println("--post");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// long startTime = (Long) request.getAttribute("startTime");
		// System.out.println("Request URL::" +
		// request.getRequestURL().toString()
		// + ":: End Time=" + System.currentTimeMillis());
		// System.out.println("Request URL::" +
		// request.getRequestURL().toString()
		// + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
		// System.out.println("--after");
	}

}