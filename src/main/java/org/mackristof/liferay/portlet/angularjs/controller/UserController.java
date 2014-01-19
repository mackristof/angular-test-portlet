package org.mackristof.liferay.portlet.angularjs.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.util.PortalUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mackristof.liferay.portlet.angularjs.pojo.User;
import org.mackristof.liferay.portlet.angularjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/services/users")
public class UserController {
    private Log log = LogFactoryUtil.getLog(getClass());
    
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> list(HttpServletRequest request) {
        
        try {
            com.liferay.portal.model.User user = PortalUtil.getUser(request);

            PrincipalThreadLocal.setName(user.getUserId());
            PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);
            CompanyThreadLocal.setCompanyId(PortalUtil.getCompanyId(request));
            
            
        } catch (Exception ex) {
            log.debug("Ouuch: big problem. let's see : " + ex.getMessage(), ex);
        }
        return userService.getUsers();
    }
}
