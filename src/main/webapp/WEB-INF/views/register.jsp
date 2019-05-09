<%-- 
    Document   : register
    Created on : May 9, 2019, 3:04:01 PM
    Author     : jnap
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Log in | Sign Up</title>

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/static/css/loginform.css">
        <style>
            .white {
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="wrapper">

            <!-- Registration Form -->
            <form:form
                action="${pageContext.request.contextPath}/register/processRegistrationForm"
                modelAttribute="crmUser">

                <!-- Place for messages: error, alert etc ... -->
                <div class="form-group">
                    <div class="col-xs-15">
                        <div>

                            <!-- Check for registration error -->
                            <c:if test="${registrationError != null}">

                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                    ${registrationError}</div>

                            </c:if>

                        </div>
                    </div>
                </div>
                <div class="login is-active">
                    <!-- Username -->
                    <div class="form-element">
                        <form:errors path="userName" cssClass="error" />
                        <form:input path="userName" placeholder="username (*)" />
                    </div>
                    <!-- Password -->
                    <div class="form-element">
                        <form:errors path="password" cssClass="error" />
                        <form:password path="password" placeholder="password (*)" />
                    </div>
                    <!-- Confirm Password -->
                    <div class="form-element">
                        <form:errors path="matchingPassword" cssClass="error" />
                        <form:password path="matchingPassword"
                                       placeholder="confirm password (*)" />
                    </div>
                    <!-- First Name -->
                    <div class="form-element">
                        <form:errors path="firstName" cssClass="error" />
                        <form:input path="firstName" placeholder="first name (*)" />
                    </div>
                    <!-- Last Name -->
                    <div class="form-element">
                        <form:errors path="lastName" cssClass="error" />
                        <form:input path="lastName" placeholder="last name (*)" />
                    </div>
                    <!-- Email -->
                    <div class="form-element">
                        <form:errors path="email" cssClass="error" />
                        <form:input path="email" placeholder="email (*)" />
                    </div>
                    <button class="btn-register">register</button>
                </div>
            </form:form>

            <div class="white">
                Already have an account? <a class="white"
                                            href="${pageContext.request.contextPath}/login">Login</a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/loginform.js"></script>
    </body>
</html>
