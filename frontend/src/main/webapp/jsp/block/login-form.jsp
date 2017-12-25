<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../../resources/js/custom/login.js"></script>

<div class="form-group">
    <input class="form-control jsUsername" id="inputUsername" placeholder="Username" type="text"/>
</div>
<div class="alert alert-danger jsUsernameNotification" role="alert" style="display: none">
    Input your username. Only letters and digits available. Length 3..15 symbols.
</div>

<div class="form-group">
    <input class="form-control jsPassword" id="exampleInputPassword1" placeholder="Password" type="password" />
</div>
<div class="alert alert-danger jsPasswordNotification" role="alert" style="display: none">
    Input your password. Only letters and digits available. Length 3..15 symbols.
</div>

<div class="form-check">
    <label class="form-check-label">
        <input type="checkbox" class="form-check-input jsRememberMe" name="remember-me" />
        Remember me
    </label>
</div>
<button type="submit" class="btn btn-primary jsSubmitLogin">Log in</button>
<a href="register">Go register</a>
<div class="alert alert-danger jsInputIncorrectNotification" role="alert" style="display: none">
    Some fields are empty. Fill `em all!
</div>
<div class="alert alert-danger jsCredentialsIncorrectNotification" role="alert" style="display: none">
    No such user. Check your username and password.
</div>