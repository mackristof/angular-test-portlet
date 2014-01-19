package org.mackristof.liferay.portlet.angularjs.pojo;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class User {
    private static Log log = LogFactoryUtil.getLog(User.class);

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String jobTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public static User toUser(com.liferay.portal.model.User liferayUser) {
        User user = new User();

        if (liferayUser != null) {
            user.setId(liferayUser.getUserId());
            user.setFirstName(liferayUser.getFirstName());
            user.setLastName(liferayUser.getLastName());
            user.setJobTitle(liferayUser.getJobTitle());
            user.setEmailAddress(liferayUser.getEmailAddress());
            
        }

        return user;
    }
}
