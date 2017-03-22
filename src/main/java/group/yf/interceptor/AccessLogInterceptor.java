package group.yf.interceptor;

import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessLogInterceptor extends HandlerInterceptorAdapter {

	private Logger log = Logger.getLogger(this.getClass());
	long startTime=0L;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		startTime= System.currentTimeMillis();
		request.setCharacterEncoding("utf-8");
	    log.info("url=" + URLDecoder.decode(request.getRequestURI(),"utf-8"));
		return super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//logger.info("ModelAndView=" + modelAndView.toString() + ",resp=" + response.getClass());
		super.postHandle(request, response, handler, modelAndView);
	    
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	     long endTime = System.currentTimeMillis();
	     long executeTime = endTime - startTime;
		 log.info("executeTime:"+executeTime+"ms");
		 super.afterCompletion(request, response, handler, ex);
	}

    	
	

}
