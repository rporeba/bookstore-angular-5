<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<#--@ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken"
@ftlvariable name="error" type="java.util.Optional-->

<style>
    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 40px;
        text-align: center;
    }

    .form-signin .checkbox {
        font-weight: normal;
    }

    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    #users {
        text-align: left;
        margin-bottom: 20px;
        margin-top: 20px;
    }

</style>

<div class="container">
    <div class="jumbotron">
        <form class="form-signin" role="form" action="/bookstore/login" method="post">

            <h2 class="form-signin-heading">Bookstore</h2>

            <div id="users">
                <h5>Login with:</h5>
                <h5>admin@localhost / admin</h5>
                <h5>dba@localhost / dba</h5>
                <h5>user1@localhost / user1</h5>
            </div>

<#--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

            <label for="email" class="sr-only">Email address</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required
                   autofocus>

            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                   required>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me" id="remember-me"> Remember me
                </label>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

        <#if error.isPresent()>
            <p>The email or password you have entered is invalid, try again.</p>
        </#if>

        </form>

    </div>
</div>


