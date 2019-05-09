<%-- 
    Document   : login
    Created on : May 9, 2019, 3:02:13 PM
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
              href="/static/css/loginform.css">
    </head>

    <body>
        <div class="wrapper">

            <!-- Login Form -->
            <form action="${pageContext.request.contextPath}/admin/user/all"
                  method="POST" class="form-horizontal">

                <!-- Place for messages: error, alert etc ... -->
                <div class="form-group">
                    <div class="col-xs-15">
                        <div>

                            <!-- Check for login error -->

                            <c:if test="${param.error != null}">

                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                    Invalid username and password.</div>

                            </c:if>

                            <!-- Check for logout -->

                            <c:if test="${param.logout != null}">

                                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                    You have been logged out.</div>

                            </c:if>

                        </div>
                    </div>
                </div>

                <div class="login is-active">
                    <div class="profile">
                        <i class="fa fa-camera fa-2x"></i>
                    </div>
                    <div class="form-element">
                        <span><i class="fa fa-envelope"></i></span><input type="text"
                                                                          name="username" placeholder="Your Email" />
                    </div>
                    <div class="form-element">
                        <span><i class="fa fa-lock"></i></span><input type="password"
                                                                      name="password" placeholder=" Password" />
                    </div>
                    <button class="btn-login">login</button>
                </div>

                <!-- manually adding tokens  -->

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>


            <div class="login-view-toggle">
                <div class="sign-up-toggle is-active">
                    Don't have an account? <a href="${pageContext.request.contextPath}/register/showRegistrationForm">Sign Up</a>
                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script src="/static/js/loginform.js"></script>
    </body>

</html>
