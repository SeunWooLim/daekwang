package kr.or.daekwang.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.daekwang.member.model.vo.MemberVo;

public class Intercepter extends HandlerInterceptorAdapter{
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		MemberVo member = (MemberVo) session.getAttribute("loginUser");
		
		if(member != null) {
			if(Integer.parseInt(member.getMEMBER_FG()) != 1) {
				response.sendRedirect("/daekwang/forwardMain.do");
				return false;
			}
		}else {
			response.sendRedirect("/daekwang/forwardMain.do");
			return false;
		}
		
        return super.preHandle(request, response, handler);
    }
 
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }
 

}
