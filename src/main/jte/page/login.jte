@layout("layout/main.jte")
@content {
<div class="login-container">
    <div class="login-header">
        <div class="logo">Login</div>
        <p>Please enter your credentials</p>
    </div>
    <form class="login-form" id="loginForm" action="/login" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </div>
        <button type="submit" class="login-button">Login</button>
        <div class="create-account">
            <p>Don't have an account? <a href="/signup">Create Account</a></p>
        </div>
    </form>
</div>
}
