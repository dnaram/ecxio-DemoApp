<body>
<h1 style="text-align:center;">Browse and Borrow Books</h1>
<form action="/" method="POST">
    <div style="text-align:center;" class="container">
        <label id="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required><br/>

        <label id="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required><br/>

        <button type="submit">Login</button><br/>
    </div>

    <div style="text-align:center;" class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button><br/>
        <span class="psw">Forgot <a href="#">password?</a></span><br/>
        <p style="color:red;">${message}<p/>
    </div>
</form>


</body>