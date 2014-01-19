
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<div ng-app>
	
	<div class="users" ng-controller="UsersListController" ng-cloak>
	Search in Liferay users LastName : <input type="text" ng-model="search.lastName"/>
	    <div class="user" ng-repeat="user in users | orderBy:'lastName' | filter:search:strict">        
	        <div class="right-panel">
	            <div class="first-name"><a href="mailto: {{user.emailAddress}}">{{user.firstName}} {{user.lastName}}</a></div>            
	        </div>
	        <div class="clear"/>
	    </div>
	</div>
</div>