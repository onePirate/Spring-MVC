package com.blog.interceptor;

import com.blog.enums.ConstantEnum;
import com.blog.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @function: 权限控制以及token验证
 * @Author: gaodawei
 * @Date: 2018/1/16 20:08
 */
public class ParamHandlerInterceptor  implements HandlerInterceptor {

    private static Logger log= LoggerFactory.getLogger(ParamHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("\n***************请求在处理之前执行调用****************");
        String paramStr="";
        if(ConstantEnum.CONTENT_TYPE_JSON.getValue().equals(request.getHeader("Content-type"))) {
            paramStr= HttpServletRequestUtil.getBodyString(request);
        }
        log.info("\n******请求参数:{}",paramStr);
//        if(StringsUtil.isEmpty(paramStr)){
//            response.getWriter().print(ResultUtil.error());
//            return false;
//        }
//        JSONObject paramJson = JSONObject.parseObject(paramStr);
//        StateEnum stateEnum= TokenUtil.volidateToken(paramJson.getString("account"),paramJson.getString("token"));
//        log.info("\n******token验证:{}",stateEnum);
//        //token过期
//        if(stateEnum.equals(StateEnum.STATE_201)){
//            response.getWriter().print(ResultUtil.error(stateEnum.getState(),stateEnum.getDesc()));
//            return false;
//        }
//        //被迫下线
//        else if(stateEnum.equals(StateEnum.STATE_202)){
//            response.getWriter().print(ResultUtil.error(stateEnum.getState(),stateEnum.getDesc()));
//            return false;
//        }
        long reqTime = System.currentTimeMillis();
        request.setAttribute("reqTime",reqTime);
//        log.info("\n*****【时间】:{},  【接口】:{},  【参数数据】:{}",reqTime,request.getServletPath(),paramJson);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        log.info("\n***************请求model之后视图之前执行调用****************");
        long reqTime = Long.valueOf(request.getAttribute("reqTime").toString());
        log.info("\n*****【时间】:{},  【接口】:{},  【耗时】:{},  【响应数据】:",reqTime,request.getServletPath(),(System.currentTimeMillis()-reqTime)+"ms","拦截器普通方式拿不到响应数据");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("\n***************请求视图都已经渲染完成之后执行调用****************");
    }
}
